package lt.vcs.musicapp.model;

public class TrackSearchResults {

    private Tracks trackmatches;

    public TrackSearchResults(Tracks trackmatches) {
        this.trackmatches = trackmatches;
    }

    public Tracks getTrackmatches() {
        return trackmatches;
    }

    public void setTrackmatches(Tracks trackmatches) {
        this.trackmatches = trackmatches;
    }

    @Override
    public String toString() {
        return "TracksApiResponse{" +
                "trackmatches=" + trackmatches +
                '}';
    }
}
