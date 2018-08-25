package Entities.SearchResult;

public class SearchResultFactory {

    public static SearchResult makeSearchResult(String searchResultTerm, String searchResultString, String searchResultSource) {

        SearchResult searchResult = new SearchResultImpl(searchResultTerm, searchResultString, searchResultSource);
        return searchResult;
    }
}
