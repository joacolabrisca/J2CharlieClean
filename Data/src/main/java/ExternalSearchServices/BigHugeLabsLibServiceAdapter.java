package ExternalSearchServices;

import SearchService.SearchService;
import SearchService.ServiceNotReachableException;

class BigHugeLabsLibServiceAdapter implements ExternalSearchService {

    private SearchService searchService;
    private final String source = "BIG HUGE LABS";

    BigHugeLabsLibServiceAdapter(SearchService searchService) {
        this.searchService = searchService;
    }

    public String searchTerm(String term) throws ServiceNotReachableException {
        String searchResult = searchService.searchTerm(term);
        return searchResult;
    }

    public String getSource() {
       return source;
    }
}
