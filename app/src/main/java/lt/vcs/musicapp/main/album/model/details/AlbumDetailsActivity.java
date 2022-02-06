package lt.vcs.musicapp.main.album.model.details;

import static lt.vcs.musicapp.Constants.PUT_ALBUM_NAME;
import static lt.vcs.musicapp.Constants.PUT_ARTIST_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.viewModel.AlbumDetailsViewModel;
import lt.vcs.musicapp.main.album.viewModel.AlbumTracksAdapter;
import lt.vcs.musicapp.main.track.model.details.Track;

public class AlbumDetailsActivity extends AppCompatActivity {

    AlbumDetailsViewModel viewModel = null;
    RecyclerView tracksRecyclerView;
    AlbumTracksAdapter albumTracksAdapter;
    List<Track> albumTracks;
    LinearLayoutManager linearLayoutManager;
    TextView albumNameTextView;
    TextView artistNameTextView;
    ImageView albumImageView;
    TextView albumWikiTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        Intent intent = getIntent();
        String albumName = intent.getStringExtra(PUT_ALBUM_NAME);
        String artistName = intent.getStringExtra(PUT_ARTIST_NAME);

        viewModel = new ViewModelProvider(this).get(AlbumDetailsViewModel.class);
        linearLayoutManager = new LinearLayoutManager(AlbumDetailsActivity.this);

        viewModel.fetchAlbumInfo(artistName, albumName);
        setUpObservers();
        setUpUI();

        tracksRecyclerView = findViewById(R.id.songsRecycleView);
        tracksRecyclerView.setLayoutManager(linearLayoutManager);
        albumTracksAdapter = new AlbumTracksAdapter(albumTracks, getApplication());
        tracksRecyclerView.setAdapter(albumTracksAdapter);

    }

    private void setUpObservers() {

        viewModel.getAlbum().observe(this, new Observer<Album>() {
                    @Override
                    public void onChanged(Album album) {
                        albumTracks = album.getTracks().getTrack();
                        albumTracksAdapter.addAlbumTrackList(albumTracks);
                        albumNameTextView.setText(String.valueOf(album.getName()));
                        artistNameTextView.setText(String.valueOf(album.getArtist()));
                        albumWikiTextView.setText(String.valueOf(album.getWiki()));
                        Glide.with(AlbumDetailsActivity.this)
                                .load(album.getImage().get(3).getText());
                    }
                }
        );
    }

    private void setUpUI() {
        albumNameTextView = findViewById(R.id.albumNameTextView);
        artistNameTextView = findViewById(R.id.albumArtistNameTextView);
        albumImageView = findViewById(R.id.albumImageView);
        albumWikiTextView = findViewById(R.id.albumWikiTextView);
    }
}