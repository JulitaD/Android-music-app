package lt.vcs.musicapp.main.album.model.details;

import lt.vcs.musicapp.main.album.model.details.Album;

public class AlbumApiResponse {

    private Album album;

    public AlbumApiResponse(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "AlbumApiResponse{" +
                "album=" + album +
                '}';
    }
}
