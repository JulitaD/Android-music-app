package lt.vcs.musicapp.main;

import static lt.vcs.musicapp.common.Constants.API_KEY;
import static lt.vcs.musicapp.common.Constants.COUNTRY;
import static lt.vcs.musicapp.common.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.common.Constants.LOG_TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lt.vcs.musicapp.common.network.UserDataService;
import lt.vcs.musicapp.common.network.UserServiceClient;
import lt.vcs.musicapp.main.artist.model.details.Artists;
import lt.vcs.musicapp.main.artist.model.search.ChartsApiResponse;
import lt.vcs.musicapp.main.artist.model.search.GeoApiResponse;
import lt.vcs.musicapp.main.track.model.search.TrackSearchResults;
import lt.vcs.musicapp.main.track.model.search.TracksApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Artists> topArtists;
    private MutableLiveData<Artists> geoTopArtists;

    public LiveData<Artists> getTopArtists() {
        if (topArtists == null) {
            topArtists = new MutableLiveData<Artists>();
        }
        return topArtists;
    }

    public LiveData<Artists> getGeoTopArtists() {
        if (geoTopArtists == null) {
            geoTopArtists = new MutableLiveData<Artists>();
        }
        return geoTopArtists;
    }

    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void fetchTopArtists() {
        Call<ChartsApiResponse> call = service.getChartTopArtists(API_KEY, JSON_FORMAT);

        Callback<ChartsApiResponse> callback = new Callback<ChartsApiResponse>() {
            @Override
            public void onResponse(Call<ChartsApiResponse> call, Response<ChartsApiResponse> response) {
                topArtists.postValue(response.body().getTopArtists());
            }

            @Override
            public void onFailure(Call<ChartsApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }

    public void fetchGeoTopArtists() {
        Call<GeoApiResponse> call = service.getGeoTopArtists(COUNTRY, API_KEY, JSON_FORMAT);

        Callback<GeoApiResponse> callback = new Callback<GeoApiResponse>() {
            @Override
            public void onResponse(Call<GeoApiResponse> call, Response<GeoApiResponse> response) {
                geoTopArtists.postValue(response.body().getGeoTopArtists());
                Log.i(LOG_TAG, "GeoApiResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<GeoApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };
        call.enqueue(callback);
    }
}
