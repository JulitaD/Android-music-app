package lt.vcs.musicapp.network;

import java.util.List;

import lt.vcs.musicapp.model.AlbumApiResponse;
import lt.vcs.musicapp.model.AlbumsApiResponse;
import lt.vcs.musicapp.model.ArtistApiResponse;
import lt.vcs.musicapp.model.ArtistsApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserDataService {

    @GET("?method=artist.getinfo")
    Call<ArtistApiResponse> getArtistInfo(@Query("artist") String artist_name, @Query("api_key") String api_key, @Query("format") String format);

    @GET("?method=artist.search")
    Call<ArtistsApiResponse> getArtistSearch(@Query("artist") String artist_name, @Query("api_key") String api_key, @Query("format") String format);

    @GET("?method=album.getInfo")
    Call<AlbumApiResponse> getAlbumInfo(@Query("artist") String artist_name, @Query("album") String album_name, @Query("api_key") String api_key, @Query("format") String format);

    @GET("?method=album.search")
    Call<AlbumsApiResponse> getAlbumSearch(@Query("album") String album_name, @Query("api_key") String api_key, @Query("format") String format);

}
