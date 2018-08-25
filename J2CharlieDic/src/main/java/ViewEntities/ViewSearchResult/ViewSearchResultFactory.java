package ViewEntities.ViewSearchResult;

public class ViewSearchResultFactory {

    public static ViewSearchResult makeViewSearchResult(String searchResultTerm, String searchResultString, String searchResultSource) {

        ViewSearchResult searchResult = new ViewSearchResultImpl(searchResultTerm, searchResultString, searchResultSource);
        return searchResult;
    }
}
