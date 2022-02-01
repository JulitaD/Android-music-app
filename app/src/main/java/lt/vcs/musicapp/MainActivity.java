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

import javax.security.auth.login.LoginException;

import lt.vcs.musicapp.UI.recyclerview.ArtistsAdapter;
import lt.vcs.musicapp.model.Album;
import lt.vcs.musicapp.model.AlbumSearchResults;
import lt.vcs.musicapp.model.Artist;
import lt.vcs.musicapp.model.ArtistApiResponse;
import lt.vcs.musicapp.model.ArtistSearchResults;
import lt.vcs.musicapp.model.TopAlbums;
import lt.vcs.musicapp.model.TrackSearchResults;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel = null;
    RecyclerView recyclerView;
    ArtistsAdapter artistsAdapter;
    List<Artist> artistList = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.fetchArtistInfo();
        viewModel.fetchArtistSearchResults();
        viewModel.fetchAlbumInfo();
        viewModel.fetchAlbumSearchResults();
        viewModel.fetchTopAlbums();
        viewModel.fetchTrackSearchResults();
        setUpObservers();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        artistsAdapter = new ArtistsAdapter(artistList, getApplication());
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