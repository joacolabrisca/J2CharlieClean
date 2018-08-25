package Entities.SearchError;

public interface SearchError {

    void SetErrorSource(String searchErrorSource);
    void setErrorText(String searchErrorText);
    String getErrorSource();
    String getErrorText();
}
