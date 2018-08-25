package DataEntities.DataSearchResult;

public class DataSearchResultFactory {

    public static DataSearchResult makeSearchResult(String searchResultTerm, String searchResultString, String searchResultSource) {

        DataSearchResult searchResult = new DataSearchResultImpl(searchResultTerm, searchResultString, searchResultSource);
        return searchResult;
    }
}
