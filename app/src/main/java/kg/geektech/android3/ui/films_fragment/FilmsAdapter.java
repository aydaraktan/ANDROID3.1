package kg.geektech.android3.ui.films_fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kg.geektech.android3.data.model.Film;
import kg.geektech.android3.databinding.ItemFilmBinding;
import kg.geektech.android3.interfaces.Lol;


public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
    private ItemFilmBinding binding;
    private Lol pol;
    private List<Film> films=new ArrayList<>();

    public void setItemClickListeners(Lol pol2) {
        this.pol = pol2;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public Film getFilm(int position) {
        return films.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public ViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

            itemView.setOnClickListener(v->{
                pol.bas(getAdapterPosition());
            });
        }

        public void onBind(Film film) {
            binding.title.setText(film.getTitle());
            binding.description.setText(film.getDescription());
        }
    }
}
