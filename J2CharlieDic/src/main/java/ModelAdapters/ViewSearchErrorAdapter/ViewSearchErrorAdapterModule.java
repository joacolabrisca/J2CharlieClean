package ModelAdapters.ViewSearchErrorAdapter;

public class ViewSearchErrorAdapterModule {

    private static ViewSearchErrorAdapterModule instance;
    private ViewSearchErrorAdapter viewSearchErrorAdapter;

    private ViewSearchErrorAdapterModule() {
        viewSearchErrorAdapter = new ViewSearchErrorAdapterImpl();
    }

    public static ViewSearchErrorAdapterModule getInstance() {
        if (instance == null)
            instance = new ViewSearchErrorAdapterModule();
        return instance;
    }

    public ViewSearchErrorAdapter getViewSearchErrorAdapter() {
        return viewSearchErrorAdapter;
    }
}