package lt.vcs.musicapp.main.album.viewModel;

import static lt.vcs.musicapp.Constants.ALBUM_NAME;
import static lt.vcs.musicapp.Constants.API_KEY;
import static lt.vcs.musicapp.Constants.ARTIST_NAME;
import static lt.vcs.musicapp.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.Constants.LOG_TAG;
import static lt.vcs.musicapp.Constants.TRACK_NAME;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.album.model.details.AlbumApiResponse;
import lt.vcs.musicapp.main.album.model.details.TopAlbums;
import lt.vcs.musicapp.main.album.model.search.AlbumSearchResults;
import lt.vcs.musicapp.main.album.model.search.AlbumsApiResponse;
import lt.vcs.musicapp.main.album.model.search.TopAlbumsApiResponse;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.model.details.ArtistApiResponse;
import lt.vcs.musicapp.main.artist.model.search.ArtistSearchResults;
import lt.vcs.musicapp.main.artist.model.search.ArtistsApiResponse;
import lt.vcs.musicapp.main.track.model.search.TrackSearchResults;
import lt.vcs.musicapp.main.track.model.search.TracksApiResponse;
import lt.vcs.musicapp.network.UserDataService;
import lt.vcs.musicapp.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumSearchViewModel extends ViewModel {

    private MutableLiveData<AlbumSearchResults> albumResults;

    public MutableLiveData<AlbumSearchResults> getAlbumSearchResults() {
        if (albumResults == null) {
            albumResults = new MutableLiveData<AlbumSearchResults>();
        }
        return albumResults;
    }

    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void fetchAlbumSearchResults() {

        Call<AlbumsApiResponse> call = service.getAlbumSearch(ALBUM_NAME, API_KEY, JSON_FORMAT);

        Callback<AlbumsApiResponse> callback = new Callback<AlbumsApiResponse>() {

            @Override
            public void onResponse(Call<AlbumsApiResponse> call, Response<AlbumsApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
                albumResults.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<AlbumsApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }

}
