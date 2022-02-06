package lt.vcs.musicapp.main.album.model.search;

import static lt.vcs.musicapp.Constants.LOG_TAG;
import static lt.vcs.musicapp.Constants.PUT_ALBUM_NAME;
import static lt.vcs.musicapp.Constants.PUT_ARTIST_NAME;

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

import lt.vcs.musicapp.ClickListener;
import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.album.model.details.AlbumDetailsActivity;
import lt.vcs.musicapp.main.album.viewModel.AlbumSearchViewModel;
import lt.vcs.musicapp.main.album.viewModel.AlbumsAdapter;
import lt.vcs.musicapp.main.artist.model.details.ArtistDetailsActivity;
import lt.vcs.musicapp.main.artist.model.search.ArtistSearchActivity;

public class AlbumSearchActivity extends AppCompatActivity {

    AlbumSearchViewModel viewModel = null;
    RecyclerView recyclerView;
    AlbumsAdapter albumsAdapter;
    List<Album> albumList = Collections.emptyList();
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_search);

        Intent intent = getIntent();

        viewModel = new ViewModelProvider(this).get(AlbumSearchViewModel.class);
        linearLayoutManager = new LinearLayoutManager(AlbumSearchActivity.this);

        viewModel.fetchAlbumSearchResults();
        setUpObservers();

        recyclerView = findViewById(R.id.albumSearchRecycleView);
        recyclerView.setLayoutManager(linearLayoutManager);
        albumsAdapter = new AlbumsAdapter(albumList, getApplication());
        recyclerView.setAdapter(albumsAdapter);

        clickItemFromList(); // nepasispaudzia?
    }

    private void setUpObservers() {

        viewModel.getAlbumSearchResults().observe(this, new Observer<AlbumSearchResults>() {
                    @Override
                    public void onChanged(AlbumSearchResults albumSearchResults) {
                        Log.i(LOG_TAG, "Activity onResponse: " + albumSearchResults);
                        albumList = albumSearchResults.getAlbummatches().getAlbum();
                        albumsAdapter.addList(albumList);
                    }
                }
        );
    }

    private void clickItemFromList() {
        albumsAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(AlbumSearchActivity.this, AlbumDetailsActivity.class);
                intent.putExtra(PUT_ARTIST_NAME, albumList.get(position).getArtist());
                intent.putExtra(PUT_ALBUM_NAME, albumList.get(position).getName());
                startActivity(intent);
            }
        });
    }

}