package lt.vcs.musicapp.main;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
//
//    private MutableLiveData<Artist> artist;
//    private MutableLiveData<ArtistSearchResults> artistResults;
//    private MutableLiveData<Album> album;
//    private MutableLiveData<AlbumSearchResults> albumResults;
//    private MutableLiveData<TopAlbums> topAlbums;
//    private MutableLiveData<TrackSearchResults> trackResults;
//
//    public LiveData<Artist> getArtist() {
//        if (artist == null) {
//            artist = new MutableLiveData<Artist>();
//        }
//        return artist;
//    }
//
//    public LiveData<ArtistSearchResults> getArtistSearchResults() {
//        if (artistResults == null) {
//            artistResults = new MutableLiveData<ArtistSearchResults>();
//        }
//        return artistResults;
//    }
//
//    public MutableLiveData<Album> getAlbum() {
//        if (album == null) {
//            album = new MutableLiveData<Album>();
//        }
//        return album;
//    }
//
//    public MutableLiveData<AlbumSearchResults> getAlbumSearchResults() {
//        if (albumResults == null) {
//            albumResults = new MutableLiveData<AlbumSearchResults>();
//        }
//        return albumResults;
//    }
//
//    public MutableLiveData<TopAlbums> getTopAlbums() {
//        if (topAlbums == null) {
//            topAlbums = new MutableLiveData<TopAlbums>();
//        }
//        return topAlbums;
//    }
//
//    public MutableLiveData<TrackSearchResults> getTrackResults() {
//        if (trackResults == null) {
//            trackResults = new MutableLiveData<TrackSearchResults>();
//        }
//        return trackResults;
//    }
//
//    UserDataService service = UserServiceClient.getUserInstance().create(UserDataService.class);
//
//    public void fetchArtistInfo() {
//
//        Call<ArtistApiResponse> call = service.getArtistInfo(ARTIST_NAME, API_KEY, JSON_FORMAT);
//
//        Callback<ArtistApiResponse> callback = new Callback<ArtistApiResponse>() {
//
//            @Override
//            public void onResponse(Call<ArtistApiResponse> call, Response<ArtistApiResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
//                artist.postValue(response.body().getArtist());
//            }
//
//            @Override
//            public void onFailure(Call<ArtistApiResponse> call, Throwable t) {
//                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
//                call.cancel();
//            }
//        };
//
//        call.enqueue(callback);
//    }
//
//    public void fetchArtistSearchResults() {
//
//        Call<ArtistsApiResponse> call = service.getArtistSearch(ARTIST_NAME, API_KEY, JSON_FORMAT);
//
//        Callback<ArtistsApiResponse> callback = new Callback<ArtistsApiResponse>() {
//
//            @Override
//            public void onResponse(Call<ArtistsApiResponse> call, Response<ArtistsApiResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
//                artistResults.postValue(response.body().getResults());
//            }
//
//            @Override
//            public void onFailure(Call<ArtistsApiResponse> call, Throwable t) {
//                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
//                call.cancel();
//            }
//        };
//
//        call.enqueue(callback);
//    }
//
//    public void fetchAlbumInfo() {
//
//        Call<AlbumApiResponse> call = service.getAlbumInfo(ARTIST_NAME, ALBUM_NAME, API_KEY, JSON_FORMAT);
//
//        Callback<AlbumApiResponse> callback = new Callback<AlbumApiResponse>() {
//
//            @Override
//            public void onResponse(Call<AlbumApiResponse> call, Response<AlbumApiResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
//                album.postValue(response.body().getAlbum());
//            }
//
//            @Override
//            public void onFailure(Call<AlbumApiResponse> call, Throwable t) {
//                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
//                call.cancel();
//            }
//        };
//
//        call.enqueue(callback);
//    }
//
//    public void fetchAlbumSearchResults() {
//
//        Call<AlbumsApiResponse> call = service.getAlbumSearch(ALBUM_NAME, API_KEY, JSON_FORMAT);
//
//        Callback<AlbumsApiResponse> callback = new Callback<AlbumsApiResponse>() {
//
//            @Override
//            public void onResponse(Call<AlbumsApiResponse> call, Response<AlbumsApiResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
//                albumResults.postValue(response.body().getResults());
//            }
//
//            @Override
//            public void onFailure(Call<AlbumsApiResponse> call, Throwable t) {
//                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
//                call.cancel();
//            }
//        };
//
//        call.enqueue(callback);
//    }
//
//    public void fetchTopAlbums() {
//
//        Call<TopAlbumsApiResponse> call = service.getTopAlbums(ARTIST_NAME, API_KEY, JSON_FORMAT);
//
//        Callback<TopAlbumsApiResponse> callback = new Callback<TopAlbumsApiResponse>() {
//
//            @Override
//            public void onResponse(Call<TopAlbumsApiResponse> call, Response<TopAlbumsApiResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
//                topAlbums.postValue(response.body().getTopalbums());
//            }
//
//            @Override
//            public void onFailure(Call<TopAlbumsApiResponse> call, Throwable t) {
//                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
//                call.cancel();
//            }
//        };
//
//        call.enqueue(callback);
//    }
//
//    public void fetchTrackSearchResults() {
//
//        Call<TracksApiResponse> call = service.getTrackSearch(TRACK_NAME, API_KEY, JSON_FORMAT);
//
//        Callback<TracksApiResponse> callback = new Callback<TracksApiResponse>() {
//
//            @Override
//            public void onResponse(Call<TracksApiResponse> call, Response<TracksApiResponse> response) {
//                Log.i(LOG_TAG, "onResponse: " + response.body());
//                trackResults.postValue(response.body().getResults());
//            }
//
//            @Override
//            public void onFailure(Call<TracksApiResponse> call, Throwable t) {
//                Log.i(LOG_TAG, "Failed to retrieve data: " + t.getMessage());
//                call.cancel();
//            }
//        };
//
//        call.enqueue(callback);
//    }
}