package Controller;

import ModelAdapters.ViewSearchErrorAdapter.ViewSearchErrorAdapter;
import ModelAdapters.ViewSearchErrorAdapter.ViewSearchErrorAdapterModule;
import ModelAdapters.ViewSearchResultAdapter.ViewSearchResultAdapter;
import ModelAdapters.ViewSearchResultAdapter.ViewSearchResultAdapterModule;
import UseCases.ErrorHandler;
import UseCases.Repository;
import UseCases.SearchTerm.SearchTermModule;
import UseCases.SearchTerm.SearchTermUseCase;

public class ViewControllerModule {

    private static ViewControllerModule Instance;

    public static ViewControllerModule getInstance() {
        if(Instance == null)
            Instance = new ViewControllerModule();
        return Instance;
    }

    private ViewControllerModule() {}

    public ViewController getViewController(Repository repository, ErrorHandler errorHandler) {
        ViewController viewController = new ViewControllerImpl(
                getSearchTermUseCase(repository, errorHandler),
                getViewSearchResultAdapter(),
                getViewSearchErrorAdapter()
        );
        return viewController;
    }

    private SearchTermUseCase getSearchTermUseCase(Repository repository, ErrorHandler errorHandler) {
        SearchTermUseCase searchTermUseCase = SearchTermModule.getInstance().getSearchTermUseCase(repository, errorHandler);
        return searchTermUseCase;
    }

    private ViewSearchResultAdapter getViewSearchResultAdapter() {
        ViewSearchResultAdapter viewSearchResultAdapter = ViewSearchResultAdapterModule.getInstance().getViewSearchResultAdapter();
        return viewSearchResultAdapter;
    }

    private ViewSearchErrorAdapter getViewSearchErrorAdapter() {
        ViewSearchErrorAdapter viewSearchErrorAdapter = ViewSearchErrorAdapterModule.getInstance().getViewSearchErrorAdapter();
        return viewSearchErrorAdapter;
    }
}
