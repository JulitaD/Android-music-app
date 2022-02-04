package lt.vcs.musicapp.main.album.model.search;

import static lt.vcs.musicapp.Constants.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.album.viewModel.AlbumSearchViewModel;
import lt.vcs.musicapp.main.album.viewModel.AlbumsAdapter;

public class AlbumSearchActivity extends AppCompatActivity {

    AlbumSearchViewModel viewModel = null;
    RecyclerView recyclerView;
    AlbumsAdapter albumsAdapter;
    List<Album> albumList = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_search);

        Intent intent = getIntent();

        viewModel = new ViewModelProvider(this).get(AlbumSearchViewModel.class);

        viewModel.fetchAlbumSearchResults();
        setUpObservers();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(AlbumSearchActivity.this));
        recyclerView.setAdapter(albumsAdapter);

    }

    private void setUpObservers() {

        viewModel.getAlbumSearchResults().observe(this, new Observer<AlbumSearchResults>() {
                    @Override
                    public void onChanged(AlbumSearchResults albumSearchResults) {
                        Log.i(LOG_TAG, "Activity onResponse: " + albumSearchResults);
                        albumsAdapter = new AlbumsAdapter(albumSearchResults.getAlbummatches().getAlbum(), getApplication());
                        recyclerView.setAdapter(albumsAdapter);
                    }
                }
        );

    }
}