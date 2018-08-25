package UseCases.SearchTerm;

import UseCases.ErrorHandler;
import UseCases.Repository;

public class SearchTermModule {

    private static SearchTermModule instance;
    private SearchTermUseCase searchTermUseCase;

    private SearchTermModule() {}

    public static SearchTermModule getInstance() {
        if (instance == null)
            instance = new SearchTermModule();
        return instance;
    }

    public SearchTermUseCase getSearchTermUseCase(Repository repository, ErrorHandler errorHandler) {
        searchTermUseCase = new SearchTermUseCaseImpl(repository, errorHandler);
        return  searchTermUseCase;
    }
}
