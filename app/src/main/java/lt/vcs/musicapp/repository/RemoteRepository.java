package lt.vcs.musicapp.repository;

import static lt.vcs.musicapp.Constants.API_KEY;
import static lt.vcs.musicapp.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.Constants.LOG_TAG;

import android.util.Log;

import lt.vcs.musicapp.model.AlbumApiResponse;
import lt.vcs.musicapp.model.AlbumsApiResponse;
import lt.vcs.musicapp.model.ArtistApiResponse;
import lt.vcs.musicapp.model.ArtistsApiResponse;
import lt.vcs.musicapp.network.UserDataService;
import lt.vcs.musicapp.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void getArtistInfoResults() {

        Call<ArtistApiResponse> call = service.getArtistInfoResults("Cher", API_KEY, JSON_FORMAT);

        Callback<ArtistApiResponse> callback = new Callback<ArtistApiResponse>() {

            @Override
            public void onResponse(Call<ArtistApiResponse> call, Response<ArtistApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<ArtistApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);

    }

    public void getArtistSearchResults() {

        Call<ArtistsApiResponse> call = service.getArtistSearchResults("Cher", API_KEY, JSON_FORMAT);

        Callback<ArtistsApiResponse> callback = new Callback<ArtistsApiResponse>() {

            @Override
            public void onResponse(Call<ArtistsApiResponse> call, Response<ArtistsApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<ArtistsApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }

    public void getAlbumInfoResults() {

        Call<AlbumApiResponse> call = service.getAlbumInfoResults("Cher", "Believe", API_KEY, JSON_FORMAT);

        Callback<AlbumApiResponse> callback = new Callback<AlbumApiResponse>() {

            @Override
            public void onResponse(Call<AlbumApiResponse> call, Response<AlbumApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<AlbumApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }

    public void getAlbumSearchResults() {

        Call<AlbumsApiResponse> call = service.getAlbumSearchResults("Believe", API_KEY, JSON_FORMAT);

        Callback<AlbumsApiResponse> callback = new Callback<AlbumsApiResponse>() {

            @Override
            public void onResponse(Call<AlbumsApiResponse> call, Response<AlbumsApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
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
