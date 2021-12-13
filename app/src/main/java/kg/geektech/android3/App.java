package kg.geektech.android3;

import android.app.Application;

import kg.geektech.android3.data.remote.FilmsApi;
import kg.geektech.android3.data.remote.FilmsApiClient;
import kg.geektech.android3.data.remote.RetroFitClient;

public class App extends Application {

    private RetroFitClient retroFitClient=new RetroFitClient();;
    public static FilmsApi api;
    public static FilmsApiClient client=new FilmsApiClient();

    @Override
    public void onCreate() {
        super.onCreate();
        api=retroFitClient.provideFilmsApi();
    }
}
