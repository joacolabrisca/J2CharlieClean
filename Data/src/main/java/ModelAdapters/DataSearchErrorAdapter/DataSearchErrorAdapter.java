package ModelAdapters.DataSearchErrorAdapter;

import DataEntities.DataSearchError.DataSearchError;
import Entities.SearchError.SearchError;

public interface DataSearchErrorAdapter {

    SearchError adaptToModelSearchError(DataSearchError dataSearchError);
}
