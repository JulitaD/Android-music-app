package lt.vcs.musicapp.main.artist.viewModel;

import static lt.vcs.musicapp.Constants.API_KEY;
import static lt.vcs.musicapp.Constants.ARTIST_NAME;
import static lt.vcs.musicapp.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.Constants.LOG_TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lt.vcs.musicapp.main.album.model.details.TopAlbums;
import lt.vcs.musicapp.main.album.model.search.TopAlbumsApiResponse;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.model.details.ArtistApiResponse;
import lt.vcs.musicapp.network.UserDataService;
import lt.vcs.musicapp.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistDetailsViewModel extends ViewModel {

    private MutableLiveData<Artist> artist;
    //?
    private MutableLiveData<TopAlbums> topAlbums;

    public LiveData<Artist> getArtist() {
        if (artist == null) {
            artist = new MutableLiveData<Artist>();
        }
        return artist;
    }
    //?
    public  LiveData<TopAlbums> getTopAlbums() {
        if (topAlbums == null) {
            topAlbums = new MutableLiveData<TopAlbums>();
        }
        return topAlbums;
    }


    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void fetchArtistInfo() {

        Call<ArtistApiResponse> call = service.getArtistInfo(ARTIST_NAME, API_KEY, JSON_FORMAT);

        Callback<ArtistApiResponse> callback = new Callback<ArtistApiResponse>() {

            @Override
            public void onResponse(Call<ArtistApiResponse> call, Response<ArtistApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
                artist.postValue(response.body().getArtist());
            }

            @Override
            public void onFailure(Call<ArtistApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }

        public void fetchTopAlbums() {

        Call<TopAlbumsApiResponse> call = service.getTopAlbums(ARTIST_NAME, API_KEY, JSON_FORMAT);

        Callback<TopAlbumsApiResponse> callback = new Callback<TopAlbumsApiResponse>() {

            @Override
            public void onResponse(Call<TopAlbumsApiResponse> call, Response<TopAlbumsApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
                topAlbums.postValue(response.body().getTopAlbums());
            }

            @Override
            public void onFailure(Call<TopAlbumsApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }
}
