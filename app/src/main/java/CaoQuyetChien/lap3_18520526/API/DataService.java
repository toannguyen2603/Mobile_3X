package CaoQuyetChien.lap3_18520526.API;

import CaoQuyetChien.lap3_18520526.Model.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("top-headlines?sources=techcrunch&apiKey=d9f20dfc50204b6cac20cccfeef1dbaa")
    Call<News> GetDataNews();

}
