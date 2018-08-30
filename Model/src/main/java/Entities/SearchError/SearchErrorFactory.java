package Entities.SearchError;

public class SearchErrorFactory {

    public static SearchError makeSearchError(String searchErrorSource, String searchErrorText) {
        SearchError searchError = new SearchErrorImpl(searchErrorSource, searchErrorText);
        return searchError;
    }
}
