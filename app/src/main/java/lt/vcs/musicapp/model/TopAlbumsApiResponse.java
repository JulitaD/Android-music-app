package lt.vcs.musicapp.model;

public class TopAlbumsApiResponse {

    private TopAlbums topalbums;

    public TopAlbumsApiResponse(TopAlbums topalbums) {
        this.topalbums = topalbums;
    }

    public TopAlbums getTopalbums() {
        return topalbums;
    }

    public void setTopalbums(TopAlbums topalbums) {
        this.topalbums = topalbums;
    }

    @Override
    public String toString() {
        return "TopAlbumsApiResponse{" +
                "topAlbums=" + topalbums +
                '}';
    }
}
