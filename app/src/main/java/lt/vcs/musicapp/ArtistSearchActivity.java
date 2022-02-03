package lt.vcs.musicapp;

import static lt.vcs.musicapp.Constants.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.album.model.search.AlbumSearchResults;
import lt.vcs.musicapp.main.album.viewModel.AlbumSearchViewModel;
import lt.vcs.musicapp.main.album.viewModel.AlbumsAdapter;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.model.search.ArtistSearchResults;
import lt.vcs.musicapp.main.artist.viewModel.ArtistSearchViewModel;
import lt.vcs.musicapp.main.artist.viewModel.ArtistsAdapter;

public class ArtistSearchActivity extends AppCompatActivity {

    ArtistSearchViewModel viewModel = null;
    RecyclerView recyclerView;
    ArtistsAdapter artistsAdapter;
    List<Artist> artistList = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_search);

        Intent intent = getIntent();

        viewModel = new ViewModelProvider(this).get(ArtistSearchViewModel.class);

        viewModel.fetchArtistSearchResults();
        setUpObservers();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(ArtistSearchActivity.this));
        recyclerView.setAdapter(artistsAdapter);

        artistsAdapter = new ArtistsAdapter(artistList, getApplication());
        recyclerView.setAdapter(artistsAdapter);

        clickItemFromList();
    }

    private void setUpObservers() {

        viewModel.getArtistSearchResults().observe(this, new Observer<ArtistSearchResults>() {
                    @Override
                    public void onChanged(ArtistSearchResults artistSearchResults) {
                        Log.i(LOG_TAG, "Activity onResponse: " + artistSearchResults);
                        artistList = artistSearchResults.getArtistmatches().getArtist();

                        artistsAdapter.addList(artistList);
                    }
                }
        );

    }

    private void clickItemFromList() {
        artistsAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String message = artistList.get(position).toString();
                Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
            }
        });

    }
}