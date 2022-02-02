package lt.vcs.musicapp.main.track.model;

public class TracksApiResponse {

    private TrackSearchResults results;

    public TracksApiResponse(TrackSearchResults results) {
        this.results = results;
    }

    public TrackSearchResults getResults() {
        return results;
    }

    public void setResults(TrackSearchResults results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "TracksApiResponse{" +
                "results=" + results +
                '}';
    }
}
