package ModelAdapters.ViewSearchErrorAdapter;

import Entities.SearchError.SearchError;
import ViewEntities.ViewSearchError.ViewSearchError;
import ViewEntities.ViewSearchError.ViewSearchErrorFactory;

class ViewSearchErrorAdapterImpl implements ViewSearchErrorAdapter {

    public ViewSearchError adaptFromModelSearchError(SearchError modelSearchError) {
        String searchErrorSource = modelSearchError.getErrorSource();
        String searchErrorText = modelSearchError.getErrorText();
        ViewSearchError viewSearchError = ViewSearchErrorFactory.makeViewSearchError(searchErrorSource, searchErrorText);
        return viewSearchError;
    }
}
