package DataEntities.DataSearchResult;

public interface DataSearchResult {

    void setSearchResultTerm(String term);
    void setSearchResultText(String text);
    void setSearchResultSource(String source);
    String getSearchResultText();
    String getSearchResultSource();
    String getSearchResultTerm();
}
