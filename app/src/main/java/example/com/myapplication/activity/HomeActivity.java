package example.com.myapplication.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.myapplication.R;
import example.com.myapplication.adapter.ArticleAdapter;
import example.com.myapplication.model.Article;


public class HomeActivity extends AppCompatActivity implements IHomeViewPresenter.IMainView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progress_circular)
    ProgressBar progressBar;
    @BindView(R.id.tv_data)
    TextView tvNoData;
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homePresenter = new HomePresenter(this);
        homePresenter.getArticleData();


    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this,"Connection Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(List<Article> articleList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleAdapter(this,articleList));
    }

    @Override
    public void showNoData() {
       tvNoData.setVisibility(View.VISIBLE);
    }
}
