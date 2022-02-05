package lt.vcs.musicapp.main.album.model.search;

import lt.vcs.musicapp.main.album.model.details.TopAlbums;

public class TopAlbumsApiResponse {

    private TopAlbums topalbums;

    public TopAlbumsApiResponse(TopAlbums topalbums) {
        this.topalbums = topalbums;
    }

    public TopAlbums getTopAlbums() {
        return topalbums;
    }

    public void setTopAlbums(TopAlbums topalbums) {
        this.topalbums = topalbums;
    }

    @Override
    public String toString() {
        return "TopAlbumsApiResponse{" +
                "topAlbums=" + topalbums +
                '}';
    }
}
