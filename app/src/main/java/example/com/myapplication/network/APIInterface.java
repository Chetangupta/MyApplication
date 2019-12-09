package example.com.myapplication.network;

import java.util.List;

import example.com.myapplication.model.Article;
import example.com.myapplication.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chetangupta on 12/8/2019.
 */

public interface APIInterface {
    @GET("7.json")
    Call<Result> getArticle(@Query("api-key") String apiKey);
}
