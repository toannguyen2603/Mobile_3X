package CaoQuyetChien.lap3_18520526.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import CaoQuyetChien.lap3_18520526.API.DataService;
import CaoQuyetChien.lap3_18520526.API.Service;
import CaoQuyetChien.lap3_18520526.Adapter.NewsAdapter;
import CaoQuyetChien.lap3_18520526.Model.Article;
import CaoQuyetChien.lap3_18520526.Model.News;
import CaoQuyetChien.lap3_18520526.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News_Fragment extends Fragment {
    View view;
    RecyclerView recyclerViewNews;
    NewsAdapter newsAdapter;
    ArrayList<Article> articles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment, container, false);
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews);

        GetData();
        return view;
    }

    private void GetData() {
//        get service
        DataService dataService = Service.getService();
//        get list data through the service
        Call<News> callback = dataService.GetDataNews();

        callback.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                articles = (ArrayList<Article>) response.body().getArticles();

                Log.d("Newss", String.valueOf(articles));

                newsAdapter = new NewsAdapter(getActivity(), articles);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewNews.setLayoutManager(linearLayoutManager);

                recyclerViewNews.setAdapter(newsAdapter);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}
