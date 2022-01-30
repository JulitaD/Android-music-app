package lt.vcs.musicapp.network;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserDataService {

    @GET("?method=artist.getinfo&artist={artist_name}&api_key={API_KEY}&format=json")
    Call<ArtistResponse> getArtistSearchResults(@Path("artist_name") String artist_name, @Path("API_KEY") String API_KEY);
}
