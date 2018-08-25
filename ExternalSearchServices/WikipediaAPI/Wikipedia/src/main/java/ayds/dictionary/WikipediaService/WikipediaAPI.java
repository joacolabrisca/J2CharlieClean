package ayds.dictionary.WikipediaService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// https://www.mediawiki.org/wiki/API:Main_page/es
public interface WikipediaAPI {

    @GET("api.php?format=xml&action=query&prop=extracts&exlimit=1&explaintext&exintro")
    Call<String> getTerm(@Query("titles") String term);

}
