package ViewEntities.ViewSearchError;

public class ViewSearchErrorFactory {

    public static ViewSearchError makeViewSearchError(String searchErrorSource, String searchErrorText) {

        ViewSearchError searchError = new ViewSearchErrorImpl(searchErrorSource, searchErrorText);
        return searchError;
    }

}
