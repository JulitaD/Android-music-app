package lt.vcs.musicapp.main;

import static lt.vcs.musicapp.common.Constants.PUT_ALBUM_NAME;
import static lt.vcs.musicapp.common.Constants.PUT_ARTIST_NAME;
import static lt.vcs.musicapp.common.Constants.PUT_TRACK_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.view.AlbumSearchActivity;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.model.details.Artists;
import lt.vcs.musicapp.main.artist.view.ArtistDetailsActivity;
import lt.vcs.musicapp.main.artist.view.ArtistSearchActivity;
import lt.vcs.musicapp.main.artist.view.TopAlbumsAdapter;
import lt.vcs.musicapp.main.artist.view.TopArtistsAdapter;
import lt.vcs.musicapp.main.artist.viewModel.ArtistDetailsViewModel;
import lt.vcs.musicapp.main.track.view.TrackSearchActivity;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel = null;
    RecyclerView topArtistsRecyclerView;
    TopArtistsAdapter topArtistsAdapter;
    List<Artist> topArtists = Collections.emptyList();
    LinearLayoutManager linearLayoutManagerTopArtists;

    private String artistName;
    private String albumName;
    private String trackName;
    private Button artistsButton;
    private Button albumsButton;
    private Button tracksButton;
    private TextView artistSearchEditText;
    private TextView albumSearchEditText;
    private TextView trackSearchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        linearLayoutManagerTopArtists = new LinearLayoutManager(MainActivity.this, linearLayoutManagerTopArtists.HORIZONTAL, false);
        viewModel.fetchTopArtists();
        setUpObservers();
        setUpUI();

        topArtistsRecyclerView = findViewById(R.id.topArtistsRecycleView);
        topArtistsRecyclerView.setLayoutManager(linearLayoutManagerTopArtists);
        topArtistsAdapter = new TopArtistsAdapter(topArtists, getApplication());
        topArtistsRecyclerView.setAdapter(topArtistsAdapter);

        searchArtist();
        searchAlbum();
        searchTrack();

        setUpAlbumButton();
        setUpArtistButton();
        setUpTrackButton();

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

    }

    private void setUpObservers() {

        viewModel.getTopArtists().observe(this, new Observer<Artists>() {
            @Override
            public void onChanged(Artists artists) {
                topArtists = artists.getArtist();
                topArtistsAdapter.addTopArtistsList(topArtists);
            }
        });
    }

    private void searchArtist() {
        artistSearchEditText = findViewById(R.id.searchArtistEditText);

        artistSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                artistName = s.toString();
            }
        });
    }

    private void searchAlbum() {
        albumSearchEditText = findViewById(R.id.searchAlbumEditText);

        albumSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                albumName = s.toString();
            }
        });
    }

    private void searchTrack() {
        trackSearchEditText = findViewById(R.id.searchTrackEditText);

        trackSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                trackName = s.toString();
            }
        });
    }

    private void setUpUI() {
        artistsButton = findViewById(R.id.artistSearchButton);
        albumsButton = findViewById(R.id.albumSearchButton);
        tracksButton = findViewById(R.id.trackSearchButton);
    }

    private void setUpArtistButton() {
        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtistSearchActivity.class);
                intent.putExtra(PUT_ARTIST_NAME, artistName);
                startActivity(intent);
            }
        });
    }

    private void setUpAlbumButton() {
        albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlbumSearchActivity.class);
                intent.putExtra(PUT_ALBUM_NAME, albumName);
                startActivity(intent);
            }
        });
    }

    private void setUpTrackButton() {
        tracksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrackSearchActivity.class);
                intent.putExtra(PUT_TRACK_NAME, trackName);
                startActivity(intent);
            }
        });
    }
}