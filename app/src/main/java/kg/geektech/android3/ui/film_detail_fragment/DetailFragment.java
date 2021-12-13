package kg.geektech.android3.ui.film_detail_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.android3.App;
import kg.geektech.android3.data.model.Film;
import kg.geektech.android3.databinding.FragmentDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDetailBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle =getArguments();
        assert bundle != null;
        String id=bundle.getString("keyId");

        App.api.getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if(response.isSuccessful() && response.body()!=null){

                    binding.title.setText(response.body().getTitle());
                    binding.oriTitle.setText(response.body().getOriginalTitle());
                    binding.description.setText(response.body().getDescription());
                    binding.release.setText(response.body().getReleaseDate());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
            }
        });


    }
}