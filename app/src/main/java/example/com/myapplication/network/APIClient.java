package example.com.myapplication.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chetangupta on 12/8/2019.
 */

public class APIClient {

    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/viewed/";

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
