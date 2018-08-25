package ModelAdapters.DataSearchErrorAdapter;

import DataEntities.DataSearchError.DataSearchError;
import Entities.SearchError.SearchError;
import Entities.SearchError.SearchErrorFactory;

class DataSearchErrorAdapterImpl implements DataSearchErrorAdapter {

    public SearchError adaptToModelSearchError(DataSearchError dataSearchError) {
        String searchErrorSource = dataSearchError.getErrorSource();
        String searchErrorText = dataSearchError.getErrorText();
        SearchError modelSearchError = SearchErrorFactory.makeSearchError(searchErrorSource, searchErrorText);
        return modelSearchError;
    }
}

