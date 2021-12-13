package kg.geektech.android3.data.remote;

import java.util.List;

import kg.geektech.android3.App;
import kg.geektech.android3.data.model.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiClient {

    public void getFilms(FilmsCallBack filmsCallBack){
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if(response.isSuccessful() && response.body()!=null){
                   filmsCallBack.success(response.body());
                }
                else {
                    filmsCallBack.failure(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                filmsCallBack.failure(t.getLocalizedMessage());

            }
        });
    }
}
