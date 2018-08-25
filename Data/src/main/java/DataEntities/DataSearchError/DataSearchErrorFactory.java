package DataEntities.DataSearchError;

public class DataSearchErrorFactory {

    public static DataSearchError makeDataSearchError(String searchErrorSource, String searchErrorText) {

        DataSearchError searchError = new DataSearchErrorImpl(searchErrorSource, searchErrorText);
        return searchError;
    }
}
