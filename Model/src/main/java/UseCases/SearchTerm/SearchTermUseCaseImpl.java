package UseCases.SearchTerm;

import Entities.SearchError.SearchError;
import Entities.SearchResult.SearchResult;
import UseCases.ErrorHandler;
import UseCases.Repository;
import java.util.List;

class SearchTermUseCaseImpl implements SearchTermUseCase {

    private Repository repository;
    private ErrorHandler errorHandler;
    private SearchTermListener searchTermListener;
    private SearchErrorListener searchErrorListener;

    SearchTermUseCaseImpl(Repository repository, ErrorHandler errorHandler) {
        this.repository = repository;
        this.errorHandler = errorHandler;
    }

    public void searchTerm(String term) {
        notifySearchListener(getSearchResults(term));
        notifyErrorListener(getSearchErrors());
        clearSearchErrors();
    }

    private List<SearchResult> getSearchResults(String term) {
        return repository.searchTerm(term);
    }

    private List<SearchError> getSearchErrors() {
        return errorHandler.getSearchErrors();
    }

    private void clearSearchErrors() {
        errorHandler.clearErrors();
    }

    private void notifySearchListener(List<SearchResult> SearchResultList) {
        searchTermListener.searchCompleted(SearchResultList);
    }

    private void notifyErrorListener(List<SearchError> searchErrorList) {
        searchErrorListener.searchError(searchErrorList);
    }

    public void setSearchListener(SearchTermListener searchTermListener) {
        this.searchTermListener = searchTermListener;
    }

    public void setSearchErrorListener(SearchErrorListener searchErrorListener) {
        this.searchErrorListener = searchErrorListener;
    }
}
