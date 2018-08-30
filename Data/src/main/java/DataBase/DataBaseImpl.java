package DataBase;

import DataEntities.DataSearchResult.DataSearchResult;
import DataEntities.DataSearchResult.DataSearchResultFactory;
import java.sql.*;

class DataBaseImpl implements DataBase {

    private final String MISSING_DATABASE_EXCEPTION = "ERROR: Missing database";
    private final String Url = "jdbc:sqlite:./dictionary.db";
    private final String TERM = "term";
    private final String MEANING = "meaning";
    private final String SOURCE = "source";
    private final int MISSING_DATABASE_ERROR = 1;
    private final int QUERY_TIMEOUT = 30;

    public DataSearchResult searchTerm(String term, String searchSource) throws MissingDataBaseException {
        DataSearchResult searchResult = getMeaning(term, searchSource);
        return searchResult;
    }

    public void saveTerm(DataSearchResult searchResult)  {
        Connection connection = getConnection();
        Statement statement = createStatement(connection);
        executeUpdate(statement, searchResult);
        closeStatement(statement);
        closeConnection(connection);
    }

    private DataSearchResult getMeaning(String term, String searchSource) throws MissingDataBaseException {
        Connection connection = getConnection();
        DataSearchResult searchResult = executeQuery(connection, term, searchSource);
        closeConnection(connection);
        return searchResult;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Url);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Statement createStatement(Connection connection) {
        Statement statement = null;
        try {
            if(notNull(connection)) {
                statement = connection.createStatement();
                statement.setQueryTimeout(QUERY_TIMEOUT);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private boolean notNull(Object param) {
        return (param != null);
    }

    private void executeUpdate(Statement statement, DataSearchResult searchResult) {
        try {
            if(notNull(statement)) {
                String Sql = generateSql(searchResult);
                statement.executeUpdate(Sql);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private String generateSql(DataSearchResult searchResult) {
        String meaning = searchResult.getSearchResultText();
        String term = searchResult.getSearchResultTerm();
        String source = searchResult.getSearchResultSource();
        meaning = DataBaseStringConverter.replaceDangerousCharacters(meaning);
        String SQL = "insert into terms values(null, '" + term + "', '" + meaning + "', '" + source + "' )";
        return SQL ;
    }

    private void closeConnection(Connection connection) {
        try {
            if(notNull(connection))
                if(!connection.isClosed())
                    connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private DataSearchResult executeQuery(Connection connection, String term, String searchSource) throws MissingDataBaseException {
        DataSearchResult searchResult = null;
        if(notNull(connection))
            try {
                Statement statement = createStatement(connection);
                term = DataBaseStringConverter.replaceDangerousCharacters(term);
                String SQLQuery = "select * from terms WHERE term = '" + term + "'" + " AND source = '" + searchSource + "'";
                ResultSet resultSet = statement.executeQuery(SQLQuery);
                if(isOpened(resultSet)) {
                    resultSet.next();
                    String resultTerm = resultSet.getString(TERM);
                    String resultText = resultSet.getString(MEANING);
                    resultText = aggregateFoundIndicator(resultText);
                    String resultSource = resultSet.getString(SOURCE);
                    searchResult = DataSearchResultFactory.makeSearchResult(resultTerm, resultText, resultSource);
                }
                closeStatement(statement);
                closeResultSet(resultSet);
                return searchResult;
            } catch(SQLException e) {
                int error = e.getErrorCode();
                if(error == MISSING_DATABASE_ERROR) {
                    throw new MissingDataBaseException(MISSING_DATABASE_EXCEPTION);
                }
                e.printStackTrace();
            }
        return searchResult;
    }

    private boolean isOpened(ResultSet resultSet) {
        boolean opened = false;
        try {
            if(notNull(resultSet))
                opened = !resultSet.isClosed();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return opened;
    }

    private String aggregateFoundIndicator(String resultText) {
        String resultTextWithFoundIndicator = DataBaseStringConverter.aggregateFoundIndicator(resultText);
        return resultTextWithFoundIndicator;
    }

    private void closeStatement(Statement statement) {
        try {
            if(notNull(statement))
                if(!statement.isClosed())
                    statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if(notNull(resultSet))
                if(!resultSet.isClosed())
                    resultSet.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}