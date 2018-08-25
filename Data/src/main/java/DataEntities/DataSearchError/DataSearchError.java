package DataEntities.DataSearchError;

public interface DataSearchError {

    void SetErrorSource(String searchErrorSource);
    void setErrorText(String searchErrorText);
    String getErrorSource();
    String getErrorText();
}
