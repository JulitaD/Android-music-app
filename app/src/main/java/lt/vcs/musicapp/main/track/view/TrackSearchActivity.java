package lt.vcs.musicapp.main.track.view;

import static lt.vcs.musicapp.common.Constants.LOG_TAG;
import static lt.vcs.musicapp.common.Constants.PUT_ARTIST_NAME;
import static lt.vcs.musicapp.common.Constants.PUT_TRACK_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.track.model.search.TrackSearchResults;
import lt.vcs.musicapp.main.track.viewModel.TrackSearchViewModel;

public class TrackSearchActivity extends AppCompatActivity {

    TrackSearchViewModel viewModel = null;
    RecyclerView recyclerView;
    TracksAdapter tracksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_search);

        Intent intent = getIntent();
        String trackName = intent.getStringExtra(PUT_TRACK_NAME);

        viewModel = new ViewModelProvider(this).get(TrackSearchViewModel.class);

        viewModel.fetchTrackSearchResults(trackName);
        setUpObservers();

        recyclerView = findViewById(R.id.trackSearchRecycleView);
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