package lt.vcs.musicapp.model;

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
