package Entities.SearchResult;

class SearchResultImpl implements SearchResult {

    private String searchResultTerm;
    private String searchResultText;
    private String searchResultSource;

    SearchResultImpl(String searchResultTerm, String searchResultText, String searchResultSource) {
        this.searchResultTerm = searchResultTerm;
        this.searchResultText = searchResultText;
        this.searchResultSource = searchResultSource;
    }

    public String getSearchResultTerm() {
        return searchResultTerm;
    }

    public String getSearchResultText() {
        return searchResultText;
    }

    public String getSearchResultSource() {
        return searchResultSource;
    }

    public void setSearchResultTerm(String searchResultTerm){
        this.searchResultTerm = searchResultTerm;
    }

    public void setSearchResultText(String searchResultText){
        this.searchResultTerm = searchResultText;
    }

    public void setSearchResultSource(String searchResultSource){ this.searchResultSource = searchResultSource; }
}