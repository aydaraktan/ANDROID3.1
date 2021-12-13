package kg.geektech.android3.ui.films_fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import kg.geektech.android3.App;
import kg.geektech.android3.R;
import kg.geektech.android3.data.model.Film;
import kg.geektech.android3.data.remote.FilmsCallBack;
import kg.geektech.android3.databinding.FragmentFilmsBinding;
import kg.geektech.android3.interfaces.Lol;


public class FilmsFragment extends Fragment {
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;
    public FilmsFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentFilmsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new FilmsAdapter();
        binding.filmsRecycler.setAdapter(adapter);
        App.client.getFilms(new FilmsCallBack() {
            @Override
            public void success(List<Film> film) {
                adapter.setFilms(film);
            }

            @Override
            public void failure(String msg) {
                Log.e("TAG","failure"+msg);
            }
        });
        adapter.setItemClickListeners(new Lol() {
            @Override
            public void bas(int position) {
                Film film = adapter.getFilm(position);
                Bundle bundle = new Bundle();
                bundle.putString("keyId", film.getId());

                NavController navController=Navigation.findNavController(requireActivity(),R.id.nav_host);
                navController.navigate(R.id.detailFragment,bundle);
            }
        });


    }
}