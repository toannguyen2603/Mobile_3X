package CaoQuyetChien.lap3_18520526.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import CaoQuyetChien.lap3_18520526.Model.Article;
import CaoQuyetChien.lap3_18520526.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{


    View view;
    Context context;
    ArrayList<Article> articleArrayList;

    public NewsAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.part_news,parent, false);

        return new NewsAdapter.ViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return articleArrayList != null ? articleArrayList.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        Article article = articleArrayList.get(position);
        holder.textTitleNews.setText(article.getTitle());
        holder.textViewDescription.setText(article.getDescription());
        Picasso.get().load(article.getUrlToImage()).into(holder.imageNews);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitleNews, textViewDescription;
        ImageView imageNews;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageNews = view.findViewById(R.id.imageViewNews);
            textTitleNews = view.findViewById(R.id.textViewTitle);
            textViewDescription = view.findViewById(R.id.textViewDescription);
        }
    }
}
