package ModelAdapters.DataSearchResultAdapter;

public class DataSearchResultAdapterModule {

    private static DataSearchResultAdapterModule instance;
    private DataSearchResultAdapter dataSearchResultAdapter;

    private DataSearchResultAdapterModule() {
        dataSearchResultAdapter = new DataSearchResultAdapterImpl();
    }

    public static DataSearchResultAdapterModule getInstance() {
        if (instance == null)
            instance = new DataSearchResultAdapterModule();
        return instance;
    }

    public DataSearchResultAdapter getDataSearchResultAdapter() {
        return dataSearchResultAdapter;
    }
}
