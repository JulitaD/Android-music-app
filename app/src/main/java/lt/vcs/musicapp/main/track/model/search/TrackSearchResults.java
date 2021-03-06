package lt.vcs.musicapp.main.track.model.search;

import lt.vcs.musicapp.main.track.model.details.TrackMatches;

public class TrackSearchResults {

    private TrackMatches trackmatches;

    public TrackSearchResults(TrackMatches trackmatches) {
        this.trackmatches = trackmatches;
    }

    public TrackMatches getTrackmatches() {
        return trackmatches;
    }

    public void setTrackmatches(TrackMatches trackmatches) {
        this.trackmatches = trackmatches;
    }

    @Override
    public String toString() {
        return "TracksApiResponse{" +
                "trackmatches=" + trackmatches +
                '}';
    }
}
