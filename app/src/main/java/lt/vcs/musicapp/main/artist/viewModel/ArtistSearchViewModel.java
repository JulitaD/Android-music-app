package lt.vcs.musicapp.main.artist.viewModel;

import static lt.vcs.musicapp.common.Constants.API_KEY;
import static lt.vcs.musicapp.common.Constants.ARTIST_NAME;
import static lt.vcs.musicapp.common.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.common.Constants.LOG_TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lt.vcs.musicapp.main.artist.model.search.ArtistSearchResults;
import lt.vcs.musicapp.main.artist.model.search.ArtistsApiResponse;
import lt.vcs.musicapp.common.network.UserDataService;
import lt.vcs.musicapp.common.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistSearchViewModel extends ViewModel {

    private MutableLiveData<ArtistSearchResults> artistResults;

    public LiveData<ArtistSearchResults> getArtistSearchResults() {
        if (artistResults == null) {
            artistResults = new MutableLiveData<ArtistSearchResults>();
        }
        return artistResults;
    }

    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void fetchArtistSearchResults(String artistName) {

        Call<ArtistsApiResponse> call = service.getArtistSearch(artistName, API_KEY, JSON_FORMAT);

        Callback<ArtistsApiResponse> callback = new Callback<ArtistsApiResponse>() {

            @Override
            public void onResponse(Call<ArtistsApiResponse> call, Response<ArtistsApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
                artistResults.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ArtistsApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }
}
