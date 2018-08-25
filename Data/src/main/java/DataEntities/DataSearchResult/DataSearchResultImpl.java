package DataEntities.DataSearchResult;

class DataSearchResultImpl implements DataSearchResult {

    private String searchResultTerm;
    private String searchResultText;
    private String searchResultSource;

    DataSearchResultImpl(String searchResultTerm, String searchResultText, String searchResultSource) {
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
