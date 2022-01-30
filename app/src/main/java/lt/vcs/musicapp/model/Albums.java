package lt.vcs.musicapp.model;

import java.util.List;

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
