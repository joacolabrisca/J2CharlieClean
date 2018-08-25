package SearchService;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import java.io.IOException;

class SearchServiceImpl implements SearchService {

    private WordsBighugelabsAPI wikiApiObject;
    private SearchServiceStringConverter searchServiceStringConverter;
    private Retrofit retrofit;
    private final String source = "Big Huge Labs";
    private final String url = "http://words.bighugelabs.com/api/2/";
    private final String SERVICE_NOT_REACHABLE = "Unable to connect to the service";

    public SearchServiceImpl(SearchServiceStringConverter searchServiceStringConverter ) {
        this.searchServiceStringConverter = searchServiceStringConverter;
        initializeRetrofit();
    }

    private void initializeRetrofit () {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        wikiApiObject = retrofit.create(WordsBighugelabsAPI.class);
    }

    public String searchTerm (String term) throws ServiceNotReachableException {
        String searchResult = "";
        Response<String> wikiSearchResult = wikiSearch(term);
        if(termFoundInWiki(wikiSearchResult.body())) {
            StringBuilder extract = searchServiceStringConverter.responseToString(wikiSearchResult);
            if(!Empty(extract.toString()));
                searchResult = extract.toString();
        }
        return searchResult;
    }

    private Response<String> wikiSearch(String term) throws ServiceNotReachableException {
        try {
            return wikiApiObject.getTerm(term).execute();
        } catch(IOException e) {
            throw new ServiceNotReachableException(SERVICE_NOT_REACHABLE);
        }
    }

    private boolean termFoundInWiki(String wikiResult) {
        return wikiResult != null;
    }

    private boolean Empty(String extractString) {
        return extractString.isEmpty();
    }
}
