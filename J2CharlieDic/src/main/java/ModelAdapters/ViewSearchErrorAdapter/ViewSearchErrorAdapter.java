package ModelAdapters.ViewSearchErrorAdapter;

import Entities.SearchError.SearchError;
import ViewEntities.ViewSearchError.ViewSearchError;

public interface ViewSearchErrorAdapter {

    ViewSearchError adaptFromModelSearchError(SearchError searchError);
}
