package example.com.myapplication.activity;

import android.util.Log;

import java.util.List;

import example.com.myapplication.model.Article;
import example.com.myapplication.model.Result;
import example.com.myapplication.network.APIClient;
import example.com.myapplication.network.APIInterface;
import example.com.myapplication.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements IHomeViewPresenter.IMainPresenter {
    public IHomeViewPresenter.IMainView iMainView;

    public HomePresenter(IHomeViewPresenter.IMainView iMainView) {
        this.iMainView = iMainView;
    }

    @Override
    public void getArticleData() {
        iMainView.showProgress();
        APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);

        Call<Result> call = apiService.getArticle(Constants.API_KEY);
        Log.d("url",call.request().url().toString());
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d("url",response.raw().request().url().toString());
                List<Article> articleList = response.body().getArticleList();
                iMainView.hideProgress();
                if(articleList.size()>0){
                    iMainView.showData(articleList);
                }
                else{
                    iMainView.showNoData();
                }


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                // Log error here since request failed
                 Log.d("error",t.getMessage());
                 iMainView.hideProgress();
                iMainView.showConnectionError();
            }
        });

    }


}
