package lt.vcs.musicapp;

import static lt.vcs.musicapp.Constants.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.main.album.viewModel.AlbumsAdapter;
import lt.vcs.musicapp.main.artist.viewModel.ArtistsAdapter;
import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.album.model.search.AlbumSearchResults;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.model.search.ArtistSearchResults;
import lt.vcs.musicapp.main.album.model.details.TopAlbums;
import lt.vcs.musicapp.main.track.model.search.TrackSearchResults;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel = null;
    RecyclerView recyclerView;
    ArtistsAdapter artistsAdapter;
    AlbumsAdapter albumsAdapter;
    List<Artist> artistList = Collections.emptyList();
    List<Album> albumList = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

//        viewModel.fetchArtistInfo();
//        viewModel.fetchArtistSearchResults();
//        viewModel.fetchAlbumInfo();
        viewModel.fetchAlbumSearchResults();
//        viewModel.fetchTopAlbums();
//        viewModel.fetchTrackSearchResults();
        setUpObservers();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(artistsAdapter);

    }

    private void setUpObservers() {

        viewModel.getArtist().observe(this, new Observer<Artist>() {
                    @Override
                    public void onChanged(Artist artist) {
                        Log.i(LOG_TAG, "Activity onResponse: " + artist);
                    }
                }
        );
        viewModel.getArtistSearchResults().observe(this, new Observer<ArtistSearchResults>() {
            @Override
            public void onChanged(ArtistSearchResults artistSearchResults) {
                Log.i(LOG_TAG, "Activity onResponse: " + artistSearchResults);
                artistsAdapter = new ArtistsAdapter(artistSearchResults.getArtistmatches().getArtist(), getApplication());
                recyclerView.setAdapter(artistsAdapter);
            }
        });
        viewModel.getAlbum().observe(this, new Observer<Album>() {
                    @Override
                    public void onChanged(Album album) {
                        Log.i(LOG_TAG, "Activity onResponse: " + album);
                    }
                }
        );
        viewModel.getAlbumSearchResults().observe(this, new Observer<AlbumSearchResults>() {
                    @Override
                    public void onChanged(AlbumSearchResults albumSearchResults) {
                        Log.i(LOG_TAG, "Activity onResponse: " + albumSearchResults);
                        albumsAdapter = new AlbumsAdapter(albumSearchResults.getAlbummatches().getAlbum(), getApplication());
                        recyclerView.setAdapter(albumsAdapter);
                    }
                }
        );
        viewModel.getTopAlbums().observe(this, new Observer<TopAlbums>() {
            @Override
            public void onChanged(TopAlbums topAlbums) {
                Log.i(LOG_TAG, "Activity onResponse: " + topAlbums);
            }
        });
        viewModel.getTrackResults().observe(this, new Observer<TrackSearchResults>() {
            @Override
            public void onChanged(TrackSearchResults trackSearchResults) {
                Log.i(LOG_TAG, "Activity onResponse: " + trackSearchResults);
            }
        });

    }
}