package example.com.myapplication.activity;

import java.util.List;

import example.com.myapplication.model.Article;

/**
 * Created by chetangupta on 12/8/2019.
 */

public interface IHomeViewPresenter {

    public interface IMainView {
        void showProgress();
        void hideProgress();
        void showConnectionError();
        void showData(List<Article> articleList);
        void showNoData();

    }

    public interface IMainPresenter {
        void getArticleData();
    }


}
