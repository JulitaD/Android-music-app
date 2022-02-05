package lt.vcs.musicapp.main.artist.model.details;

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

import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.ClickListener;
import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.model.details.TopAlbum;
import lt.vcs.musicapp.main.album.model.details.TopAlbums;
import lt.vcs.musicapp.main.artist.viewModel.ArtistDetailsViewModel;
import lt.vcs.musicapp.main.artist.viewModel.SimilarArtistsAdapter;
import lt.vcs.musicapp.main.artist.viewModel.TopAlbumsAdapter;

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
    TextView artistName;
    ImageView artistImage;
    TextView artistBiography;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        Intent intent = getIntent();

        viewModel = new ViewModelProvider(this).get(ArtistDetailsViewModel.class);
        linearLayoutManagerTopAlbums = new LinearLayoutManager(ArtistDetailsActivity.this, linearLayoutManagerTopAlbums.HORIZONTAL, false);
        linearLayoutManagerSimilarArtists = new LinearLayoutManager(ArtistDetailsActivity.this, linearLayoutManagerSimilarArtists.HORIZONTAL, false);

        viewModel.fetchArtistInfo();
        viewModel.fetchTopAlbums();
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


//        clickAlbumItemFromList();
//        clickArtistItemFromList();
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
                    }
                }
        );
    }

    private void setUpUI() {
        artistName = findViewById(R.id.artistNameTextView);
        artistImage = findViewById(R.id.artistImageView);
        artistBiography = findViewById(R.id.biographyContentTextView);
    }

    private void clickArtistItemFromList() {
        similarArtistsAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String message = similarArtistList.get(position).toString();
                Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void clickAlbumItemFromList() {
        topAlbumsAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String message = topAlbumList.get(position).toString();
                Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
            }
        });
    }
}