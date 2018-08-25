package Entities.SearchResult;

public interface SearchResult {

    void setSearchResultTerm(String term);
    void setSearchResultText(String text);
    void setSearchResultSource(String source);
    String getSearchResultText();
    String getSearchResultSource();
    String getSearchResultTerm();
}
