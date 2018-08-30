package SearchView;

import Controller.ViewController;

public class SearchViewModule {

    private static SearchViewModule Instance;

    public static SearchViewModule getInstance() {
        if(Instance == null)
            Instance = new SearchViewModule();
        return Instance;
    }

    private SearchViewModule() {}

    public SearchView openDictionaryFrame(ViewController viewController) {
        SearchView searchView = new SearchViewImpl(viewController);
        return searchView;
    }
}
