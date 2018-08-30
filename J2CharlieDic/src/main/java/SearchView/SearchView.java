package SearchView;

import ViewEntities.ViewSearchError.ViewSearchError;
import ViewEntities.ViewSearchResult.ViewSearchResult;
import java.util.List;

public interface SearchView {

    void showSearchResults(List<ViewSearchResult> viewSearchResultList);
    void showSearchErrors(List<ViewSearchError> viewSearchErrorList);
}
