package ViewEntities.ViewSearchResult;

public interface ViewSearchResult {

    void setSearchResultTerm(String term);
    void setSearchResultText(String text);
    void setSearchResultSource(String source);
    String getSearchResultText();
    String getSearchResultSource();
    String getSearchResultTerm();
}
