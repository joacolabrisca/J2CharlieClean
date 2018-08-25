package ModelAdapters.DataSearchResultAdapter;

import DataEntities.DataSearchResult.DataSearchResult;
import Entities.SearchResult.SearchResult;
import Entities.SearchResult.SearchResultFactory;

class DataSearchResultAdapterImpl implements DataSearchResultAdapter {

    public SearchResult adaptToModelSearchResult(DataSearchResult dataSearchResult) {
        String searchResultTerm = dataSearchResult.getSearchResultTerm();
        String searchResultText = dataSearchResult.getSearchResultText();
        String searchResultSource = dataSearchResult.getSearchResultSource();
        SearchResult modelSearchResult = SearchResultFactory.makeSearchResult(searchResultTerm, searchResultText, searchResultSource);
        return modelSearchResult;
    }
}
