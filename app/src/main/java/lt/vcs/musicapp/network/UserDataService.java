package lt.vcs.musicapp.network;

import lt.vcs.musicapp.main.album.model.details.AlbumApiResponse;
import lt.vcs.musicapp.main.album.model.search.AlbumsApiResponse;
import lt.vcs.musicapp.main.artist.model.details.ArtistApiResponse;
import lt.vcs.musicapp.main.artist.model.search.ArtistsApiResponse;
import lt.vcs.musicapp.main.album.model.search.TopAlbumsApiResponse;
import lt.vcs.musicapp.main.track.model.search.TracksApiResponse;
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
