package ModelAdapters.ViewSearchResultAdapter;

import Entities.SearchResult.SearchResult;
import ViewEntities.ViewSearchResult.ViewSearchResult;
import ViewEntities.ViewSearchResult.ViewSearchResultFactory;

class ViewSearchResultAdapterImpl implements ViewSearchResultAdapter {

    public ViewSearchResult adaptFromModelSearchResult(SearchResult modelSearchResult){
        String searchResultTerm = modelSearchResult.getSearchResultTerm();
        String searchResultText = modelSearchResult.getSearchResultText();
        String searchResultSource = modelSearchResult.getSearchResultSource();
        ViewSearchResult viewSearchResult = ViewSearchResultFactory.makeViewSearchResult(searchResultTerm, searchResultText, searchResultSource);
        return viewSearchResult;
    }
}
