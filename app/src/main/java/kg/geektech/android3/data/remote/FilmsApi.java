package kg.geektech.android3.data.remote;

import java.util.List;

import kg.geektech.android3.data.model.Film;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {
    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilm(@Path("id") String id);
}
