package DataBase;

import DataEntities.DataSearchResult.DataSearchResult;

public interface DataBase {

    DataSearchResult searchTerm(String term, String searchSource) throws MissingDataBaseException;
    void saveTerm(DataSearchResult searchResult) ;
}
