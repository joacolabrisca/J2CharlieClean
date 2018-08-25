package SearchService;

public class SearchServiceModule {

    private static SearchServiceModule instance;
    private SearchService searchService;

    private SearchServiceModule() {
        searchService = new SearchServiceImpl(new SearchServiceStringConverterImpl());
    }

    public static SearchServiceModule getInstance() {
        if(instance == null)
            instance = new SearchServiceModule();
        return instance;
    }

    public SearchService getSearchService() {
        return searchService;
    }
}
