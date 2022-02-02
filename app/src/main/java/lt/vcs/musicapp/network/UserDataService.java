package lt.vcs.musicapp.network;

import lt.vcs.musicapp.main.album.model.AlbumApiResponse;
import lt.vcs.musicapp.main.album.model.AlbumsApiResponse;
import lt.vcs.musicapp.main.artist.model.ArtistApiResponse;
import lt.vcs.musicapp.main.artist.model.ArtistsApiResponse;
import lt.vcs.musicapp.main.album.model.TopAlbumsApiResponse;
import lt.vcs.musicapp.main.track.model.TracksApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
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

    @GET("?method=artist.gettopalbums")
    Call<TopAlbumsApiResponse> getTopAlbums(@Query("artist") String artist_name, @Query("api_key") String api_key, @Query("format") String format);

    @GET("?method=track.search")
    Call<TracksApiResponse> getTrackSearch(@Query("track") String track_name, @Query("api_key") String api_key, @Query("format") String format);
}
