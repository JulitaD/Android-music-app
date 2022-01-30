package lt.vcs.musicapp;

import static lt.vcs.musicapp.Constants.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import lt.vcs.musicapp.repository.RemoteRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RemoteRepository remoteRepository = new RemoteRepository();
        remoteRepository.getArtistInfoResults();

    }
}