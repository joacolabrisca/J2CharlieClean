package ModelAdapters.ViewSearchResultAdapter;

import Entities.SearchResult.SearchResult;
import ViewEntities.ViewSearchResult.ViewSearchResult;

public interface ViewSearchResultAdapter {

    ViewSearchResult adaptFromModelSearchResult(SearchResult ModelSearchResult);
}
