package UseCases;

import Entities.SearchError.SearchError;
import java.util.List;

public interface ErrorHandler {

    void addError(String source, Exception exception);
    List<SearchError> getSearchErrors();
    void clearErrors();
}
