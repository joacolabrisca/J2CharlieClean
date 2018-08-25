package UseCases.SearchTerm;

import Entities.SearchError.SearchError;
import java.util.List;

public interface SearchErrorListener {

    void searchError(List<SearchError> searchErrorList);
}
