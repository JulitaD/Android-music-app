package lt.vcs.musicapp.main.artist.view;

import static lt.vcs.musicapp.common.Constants.PUT_ALBUM_NAME;
import static lt.vcs.musicapp.common.Constants.PUT_ARTIST_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.common.ClickListener;
import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.model.details.TopAlbum;
import lt.vcs.musicapp.main.album.model.details.TopAlbums;
import lt.vcs.musicapp.main.album.view.AlbumDetailsActivity;
import lt.vcs.musicapp.main.album.view.AlbumSearchActivity;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.viewModel.ArtistDetailsViewModel;

public class ArtistDetailsActivity extends AppCompatActivity {

    ArtistDetailsViewModel viewModel = null;
    RecyclerView topAlbumsRecyclerView;
    RecyclerView similarArtistsRecyclerView;
    TopAlbumsAdapter topAlbumsAdapter;
    SimilarArtistsAdapter similarArtistsAdapter;
    List<Artist> similarArtistList = Collections.emptyList();
    List<TopAlbum> topAlbumList = Collections.emptyList();
    LinearLayoutManager linearLayoutManagerTopAlbums;
    LinearLayoutManager linearLayoutManagerSimilarArtists;
    TextView artistNameTextView;
    ImageView artistImageImageView;
    TextView artistBiographyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        Intent intent = getIntent();
        String artistName = intent.getStringExtra(PUT_ARTIST_NAME);

        viewModel = new ViewModelProvider(this).get(ArtistDetailsViewModel.class);
        linearLayoutManagerTopAlbums = new LinearLayoutManager(ArtistDetailsActivity.this, linearLayoutManagerTopAlbums.HORIZONTAL, false);
        linearLayoutManagerSimilarArtists = new LinearLayoutManager(ArtistDetailsActivity.this, linearLayoutManagerSimilarArtists.HORIZONTAL, false);

        viewModel.fetchArtistInfo(artistName);
        viewModel.fetchTopAlbums(artistName);
        setUpObservers();
        setUpUI();

        topAlbumsRecyclerView = findViewById(R.id.topAlbumsRecycleView);
        topAlbumsRecyclerView.setLayoutManager(linearLayoutManagerTopAlbums);
        topAlbumsAdapter = new TopAlbumsAdapter(topAlbumList, getApplication());
        topAlbumsRecyclerView.setAdapter(topAlbumsAdapter);

        similarArtistsRecyclerView = findViewById(R.id.similarArtistsRecycleView);
        similarArtistsRecyclerView.setLayoutManager(linearLayoutManagerSimilarArtists);
        similarArtistsAdapter = new SimilarArtistsAdapter(similarArtistList, getApplication());
        similarArtistsRecyclerView.setAdapter(similarArtistsAdapter);


        clickAlbumItemFromList();
        clickArtistItemFromList();
    }

    private void setUpObservers() {

        viewModel.getTopAlbums().observe(this, new Observer<TopAlbums>() {
                    @Override
                    public void onChanged(TopAlbums topAlbums) {
                        topAlbumList = topAlbums.getTopAlbumsList();
                        topAlbumsAdapter.addTopAlbumsList(topAlbumList);
                    }
                }
        );
        viewModel.getArtist().observe(this, new Observer<Artist>() {
                    @Override
                    public void onChanged(Artist artist) {
                        similarArtistList = artist.getSimilar().getArtist();
                        similarArtistsAdapter.addSimilarArtistsList(similarArtistList);
                        artistNameTextView.setText(String.valueOf(artist.getName()));
                        artistBiographyTextView.setText(String.valueOf(artist.getBio().getContent()));
                        Glide.with(ArtistDetailsActivity.this)
                                .load(artist.getImage().get(3).getText());
                    }
                }
        );
    }

    private void setUpUI() {
        artistNameTextView = findViewById(R.id.artistNameTextView);
        artistImageImageView = findViewById(R.id.artistImageView);
        artistBiographyTextView = findViewById(R.id.biographyContentTextView);
    }

    private void clickArtistItemFromList() {
        similarArtistsAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(ArtistDetailsActivity.this, ArtistDetailsActivity.class);
                intent.putExtra(PUT_ARTIST_NAME, similarArtistList.get(position).getName());
                startActivity(intent);
            }
        });
    }

    private void clickAlbumItemFromList() {
        topAlbumsAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(ArtistDetailsActivity.this, AlbumDetailsActivity.class);
                intent.putExtra(PUT_ARTIST_NAME, topAlbumList.get(position).getArtist().getName());
                intent.putExtra(PUT_ALBUM_NAME, topAlbumList.get(position).getName());
                startActivity(intent);
            }
        });
    }
}