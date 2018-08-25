package MainModule;

import ErrorHandler.ErrorHandlerModule;
import Repository.RepositoryModule;
import SearchView.SearchViewModule;
import UseCases.ErrorHandler;
import UseCases.Repository;
import UseCases.SearchTerm.SearchTermModule;
import UseCases.SearchTerm.SearchTermUseCase;

class Configuration {

    static void startApplication() {
        SearchTermUseCase searchTermUseCase = getSearchTermUseCase();
        SearchViewModule.getInstance().openDictionaryFrame(searchTermUseCase);
    }

    private static SearchTermUseCase getSearchTermUseCase() {
        Repository repository = getRepository();
        ErrorHandler errorHandler = getErrorHandler();
        SearchTermUseCase searchTermUseCase = SearchTermModule.getInstance().getSearchTermUseCase(repository, errorHandler);
        return searchTermUseCase;
    }

    private static Repository getRepository() {
        Repository repository = RepositoryModule.getInstance().getRepository();
        return repository;
    }

    private static ErrorHandler getErrorHandler() {
        ErrorHandler errorHandler = ErrorHandlerModule.getInstance().getErrorHandler();
        return errorHandler;
    }
}
