package lt.vcs.musicapp.repository;

import static lt.vcs.musicapp.Constants.API_KEY;
import static lt.vcs.musicapp.Constants.LOG_TAG;

import android.util.Log;

import lt.vcs.musicapp.model.ArtistApiResponse;
import lt.vcs.musicapp.network.UserDataService;
import lt.vcs.musicapp.network.UserServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    public void getArtistInfoResults() {

        UserDataService service =
                UserServiceClient.getUserInstance().create(UserDataService.class);

        Call<ArtistApiResponse> call = service.getArtistInfoResults("cher", API_KEY);

        Callback<ArtistApiResponse> callback = new Callback<ArtistApiResponse>() {

            @Override
            public void onResponse(Call<ArtistApiResponse> call, Response<ArtistApiResponse> response) {
                Log.i(LOG_TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<ArtistApiResponse> call, Throwable t) {
                Log.i(LOG_TAG, "Failed to retrieve data" + t.getMessage());
                call.cancel();
            }
        };

        call.enqueue(callback);

    }
}
