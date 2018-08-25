package SearchService;

import retrofit2.Response;

public interface SearchServiceStringConverter {

    StringBuilder responseToString(Response<String> wikiResult);
}
