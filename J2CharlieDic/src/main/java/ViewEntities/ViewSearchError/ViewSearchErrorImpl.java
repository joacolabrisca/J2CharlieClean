package ViewEntities.ViewSearchError;

class ViewSearchErrorImpl implements ViewSearchError {

    private String searchErrorSource;
    private String searchErrorText;

    ViewSearchErrorImpl(String searchErrorSource, String searchErrorText) {
        this.searchErrorSource = searchErrorSource;
        this.searchErrorText = searchErrorText;
    }

    public void SetErrorSource(String searchErrorSource) {
        this.searchErrorSource = searchErrorSource;
    }

    public void setErrorText(String searchErrorText) {
        this.searchErrorText = searchErrorText;
    }

    public String getErrorSource() {
        return searchErrorSource;
    }

    public String getErrorText() {
        return searchErrorText;
    }
}
