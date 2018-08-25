package SearchService;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// https://words.bighugelabs.com/api.php
public interface WordsBighugelabsAPI {

  @GET("23f426c1ae8eab5b3bf6f49d649f980b/{word}/json")
  Call<String> getTerm(@Path("word") String word);

}