package lt.vcs.musicapp.main.track.model.details;

import java.util.List;

public class Tracks {

    private List<Track> track;

    public Tracks(List<Track> track) {
        this.track = track;
    }

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "track=" + track +
                '}';
    }
}
