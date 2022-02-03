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

import lt.vcs.musicapp.main.artist.model.search.ArtistSearchResults;
import lt.vcs.musicapp.main.artist.viewModel.ArtistSearchViewModel;
import lt.vcs.musicapp.main.artist.viewModel.ArtistsAdapter;
import lt.vcs.musicapp.main.track.model.search.TrackSearchResults;
import lt.vcs.musicapp.main.track.viewModel.TrackSearchViewModel;
import lt.vcs.musicapp.main.track.viewModel.TracksAdapter;

public class TrackSearchActivity extends AppCompatActivity {

    TrackSearchViewModel viewModel = null;
    RecyclerView recyclerView;
    TracksAdapter tracksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_search);

        Intent intent = getIntent();

        viewModel = new ViewModelProvider(this).get(TrackSearchViewModel.class);

        viewModel.fetchTrackSearchResults();
        setUpObservers();

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(TrackSearchActivity.this));
        recyclerView.setAdapter(tracksAdapter);
    }

    private void setUpObservers() {

        viewModel.getTrackSearchResults().observe(this, new Observer<TrackSearchResults>() {
                    @Override
                    public void onChanged(TrackSearchResults trackSearchResults) {
                        Log.i(LOG_TAG, "Activity onResponse: " + trackSearchResults);
                        tracksAdapter = new TracksAdapter(trackSearchResults.getTrackmatches().getTrack(), getApplication()); //perkelti i onCreate ir adapteri
                        recyclerView.setAdapter(tracksAdapter);
                    }
                }
        );

    }
}