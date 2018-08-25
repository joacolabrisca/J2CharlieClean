package ModelAdapters.DataSearchResultAdapter;

import DataEntities.DataSearchResult.DataSearchResult;
import Entities.SearchResult.SearchResult;

public interface DataSearchResultAdapter {

    SearchResult adaptToModelSearchResult(DataSearchResult dataSearchResult);
}
