package lt.vcs.musicapp.main.album.model.details;

import java.util.List;

import lt.vcs.musicapp.main.album.model.details.Album;

public class Albums {

    private List<Album> album;

    public Albums(List<Album> album) {
        this.album = album;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "album=" + album +
                '}';
    }
}
