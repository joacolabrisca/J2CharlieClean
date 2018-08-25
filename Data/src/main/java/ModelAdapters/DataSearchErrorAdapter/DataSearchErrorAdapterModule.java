package ModelAdapters.DataSearchErrorAdapter;

public class DataSearchErrorAdapterModule {


    private static DataSearchErrorAdapterModule instance;
    private DataSearchErrorAdapter dataSearchErrorAdapter;

    private DataSearchErrorAdapterModule() {
        dataSearchErrorAdapter = new DataSearchErrorAdapterImpl();
    }

    public static DataSearchErrorAdapterModule getInstance() {
        if (instance == null)
            instance = new DataSearchErrorAdapterModule();
        return instance;
    }

    public DataSearchErrorAdapter getDataSearchResultAdapter() {
        return dataSearchErrorAdapter;
    }
}
