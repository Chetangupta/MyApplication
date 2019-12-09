package example.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import example.com.myapplication.R;
import example.com.myapplication.model.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.CustomViewHolder> {

    private List<Article> dataList;
    private Context context;

    public ArticleAdapter(Context context, List<Article> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtArticleHeading,txtArticleDescription,txtDate,txtSource;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtArticleDescription = mView.findViewById(R.id.tv_description);
            txtArticleHeading = mView.findViewById(R.id.tv_article_heading);
            txtDate=mView.findViewById(R.id.tv_date);
            txtSource=mView.findViewById(R.id.tv_source);
            coverImage=mView.findViewById(R.id.img_view);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.article_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
       holder.txtArticleHeading.setText(dataList.get(position).getTitle());
       holder.txtArticleDescription.setText(dataList.get(position).get_abstract());
       holder.txtSource.setText(dataList.get(position).getSource());
       holder.txtDate.setText(dataList.get(position).getPublishedDate());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
