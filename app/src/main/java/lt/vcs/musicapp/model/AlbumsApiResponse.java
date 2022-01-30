package lt.vcs.musicapp.model;

public class AlbumsApiResponse {

    private AlbumSearchResults results;

    public AlbumsApiResponse(AlbumSearchResults results) {
        this.results = results;
    }

    public AlbumSearchResults getResults() {
        return results;
    }

    public void setResults(AlbumSearchResults results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "AlbumsApiResponse{" +
                "results=" + results +
                '}';
    }
}
