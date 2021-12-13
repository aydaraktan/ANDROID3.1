package kg.geektech.android3.data.remote;

import java.util.List;

import kg.geektech.android3.data.model.Film;

public interface FilmsCallBack {

    void success(List<Film> film);
    void failure(String msg);
}
