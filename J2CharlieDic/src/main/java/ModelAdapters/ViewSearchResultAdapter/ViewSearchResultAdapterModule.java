package ModelAdapters.ViewSearchResultAdapter;

public class ViewSearchResultAdapterModule {

    private static ViewSearchResultAdapterModule instance;
    private ViewSearchResultAdapter viewSearchResultAdapter;

    private ViewSearchResultAdapterModule() {
        viewSearchResultAdapter = new ViewSearchResultAdapterImpl();
    }

    public static ViewSearchResultAdapterModule getInstance() {
        if (instance == null)
            instance = new ViewSearchResultAdapterModule();
        return instance;
    }

    public ViewSearchResultAdapter getViewSearchResultAdapter() {
        return viewSearchResultAdapter;
    }
}
