package lt.vcs.musicapp.model;

import java.util.List;

public class TopAlbums {

    private List<TopAlbum> album;

    public TopAlbums(List<TopAlbum> album) {
        this.album = album;
    }

    public List<TopAlbum> getAlbum() {
        return album;
    }

    public void setAlbum(List<TopAlbum> album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "TopAlbums{" +
                "album=" + album +
                '}';
    }
}
