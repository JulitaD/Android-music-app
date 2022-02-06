package lt.vcs.musicapp.main.album.viewModel;

import static lt.vcs.musicapp.Constants.API_KEY;
import static lt.vcs.musicapp.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.Constants.LOG_TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.album.model.details.AlbumApiResponse;
import lt.vcs.musicapp.network.UserDataService;
import lt.vcs.musicapp.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumDetailsViewModel extends ViewModel {

    private MutableLiveData<Album> album;

    public LiveData<Album> getAlbum() {
        if (album == null) {
            album = new MutableLiveData<Album>();
        }
        return album;
    }

    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void fetchAlbumInfo(String artistName, String albumName) {

        Call<AlbumApiResponse> call = service.getAlbumInfo(artistName, albumName, API_KEY, JSON_FORMAT);

        Callback<AlbumApiResponse> callback = new Callback<AlbumApiResponse>() {

            @Override
            public void onResponse(Call<AlbumApiResponse> call, Response<AlbumApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
                album.postValue(response.body().getAlbum());
            }

            @Override
            public void onFailure(Call<AlbumApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }
}

