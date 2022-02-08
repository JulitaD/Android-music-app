package lt.vcs.musicapp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.view.AlbumSearchActivity;
import lt.vcs.musicapp.main.artist.view.ArtistSearchActivity;
import lt.vcs.musicapp.main.track.view.TrackSearchActivity;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel = null;
    //    RecyclerView recyclerView;
//    ArtistsAdapter artistsAdapter;
//    AlbumsAdapter albumsAdapter;
//    List<Artist> artistList = Collections.emptyList();
//    List<Album> albumList = Collections.emptyList();
    private Button artistsButton;
    private Button albumsButton;
    private Button tracksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistsButton = findViewById(R.id.artistSearchButton);
        albumsButton = findViewById(R.id.albumSearchButton);
        tracksButton = findViewById(R.id.trackSearchButton);

        setUpAlbumButton();
        setUpArtistButton();
        setUpTrackButton();

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

//        viewModel.fetchArtistInfo();
//        viewModel.fetchArtistSearchResults();
//        viewModel.fetchAlbumInfo();
//        viewModel.fetchAlbumSearchResults();
//        viewModel.fetchTopAlbums();
//        viewModel.fetchTrackSearchResults();
//        setUpObservers();

//        recyclerView = findViewById(R.id.recycleView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        recyclerView.setAdapter(artistsAdapter);

    }

//    private void setUpObservers() {
//
//        viewModel.getArtist().observe(this, new Observer<Artist>() {
//                    @Override
//                    public void onChanged(Artist artist) {
//                        Log.i(LOG_TAG, "Activity onResponse: " + artist);
//                    }
//                }
//        );
//        viewModel.getArtistSearchResults().observe(this, new Observer<ArtistSearchResults>() {
//            @Override
//            public void onChanged(ArtistSearchResults artistSearchResults) {
//                Log.i(LOG_TAG, "Activity onResponse: " + artistSearchResults);
//                artistsAdapter = new ArtistsAdapter(artistSearchResults.getArtistmatches().getArtist(), getApplication());
//                recyclerView.setAdapter(artistsAdapter);
//            }
//        });
//        viewModel.getAlbum().observe(this, new Observer<Album>() {
//                    @Override
//                    public void onChanged(Album album) {
//                        Log.i(LOG_TAG, "Activity onResponse: " + album);
//                    }
//                }
//        );
//        viewModel.getAlbumSearchResults().observe(this, new Observer<AlbumSearchResults>() {
//                    @Override
//                    public void onChanged(AlbumSearchResults albumSearchResults) {
//                        Log.i(LOG_TAG, "Activity onResponse: " + albumSearchResults);
//                        albumsAdapter = new AlbumsAdapter(albumSearchResults.getAlbummatches().getAlbum(), getApplication());
//                        recyclerView.setAdapter(albumsAdapter);
//                    }
//                }
//        );
//        viewModel.getTopAlbums().observe(this, new Observer<TopAlbums>() {
//            @Override
//            public void onChanged(TopAlbums topAlbums) {
//                Log.i(LOG_TAG, "Activity onResponse: " + topAlbums);
//            }
//        });
//        viewModel.getTrackResults().observe(this, new Observer<TrackSearchResults>() {
//            @Override
//            public void onChanged(TrackSearchResults trackSearchResults) {
//                Log.i(LOG_TAG, "Activity onResponse: " + trackSearchResults);
//            }
//        });
//
//    }

        private void setUpArtistButton() {
        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtistSearchActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setUpAlbumButton() {
        albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlbumSearchActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setUpTrackButton() {
        tracksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrackSearchActivity.class);
                startActivity(intent);
            }
        });
    }
}