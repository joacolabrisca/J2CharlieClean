package SearchView;

import UseCases.SearchTerm.SearchTermUseCase;
import ModelAdapters.ViewSearchResultAdapter.ViewSearchResultAdapterModule;
import ModelAdapters.ViewSearchErrorAdapter.ViewSearchErrorAdapterModule;

public class SearchViewModule {

    private static SearchViewModule Instance;

    public static SearchViewModule getInstance() {
        if(Instance == null)
            Instance = new SearchViewModule();
        return Instance;
    }

    private SearchViewModule() {}

    public void openDictionaryFrame(SearchTermUseCase searchTermUseCase) {
        SearchView searchView = new SearchView(
                searchTermUseCase,
                ViewSearchResultAdapterModule.getInstance().getViewSearchResultAdapter(),
                ViewSearchErrorAdapterModule.getInstance().getViewSearchErrorAdapter());
    }
}
