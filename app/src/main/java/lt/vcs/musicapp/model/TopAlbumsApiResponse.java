package lt.vcs.musicapp.model;

public class TopAlbumsApiResponse {

    private TopAlbums topAlbums;

    public TopAlbumsApiResponse(TopAlbums topAlbums) {
        this.topAlbums = topAlbums;
    }

    public TopAlbums getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(TopAlbums topAlbums) {
        this.topAlbums = topAlbums;
    }

    @Override
    public String toString() {
        return "TopAlbumsApiResponse{" +
                "topAlbums=" + topAlbums +
                '}';
    }
}
