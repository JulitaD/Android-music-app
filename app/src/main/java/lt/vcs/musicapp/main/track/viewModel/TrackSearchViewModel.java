package lt.vcs.musicapp.main.track.viewModel;

import static lt.vcs.musicapp.common.Constants.API_KEY;
import static lt.vcs.musicapp.common.Constants.JSON_FORMAT;
import static lt.vcs.musicapp.common.Constants.LOG_TAG;
import static lt.vcs.musicapp.common.Constants.TRACK_NAME;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lt.vcs.musicapp.main.track.model.search.TrackSearchResults;
import lt.vcs.musicapp.main.track.model.search.TracksApiResponse;
import lt.vcs.musicapp.common.network.UserDataService;
import lt.vcs.musicapp.common.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackSearchViewModel extends ViewModel {

    private MutableLiveData<TrackSearchResults> trackResults;

    public LiveData<TrackSearchResults> getTrackSearchResults() {
        if (trackResults == null) {
            trackResults = new MutableLiveData<TrackSearchResults>();
        }
        return trackResults;
    }

    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);

    public void fetchTrackSearchResults() {

        Call<TracksApiResponse> call = service.getTrackSearch(TRACK_NAME, API_KEY, JSON_FORMAT);

        Callback<TracksApiResponse> callback = new Callback<TracksApiResponse>() {

            @Override
            public void onResponse(Call<TracksApiResponse> call, Response<TracksApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
                trackResults.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<TracksApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);
    }
}
