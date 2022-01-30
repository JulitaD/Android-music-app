package lt.vcs.musicapp.model;

import java.util.List;

public class Artists {

    private List<Artist> artist;

    public Artists(List<Artist> artist) {
        this.artist = artist;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "artist=" + artist +
                '}';
    }
}
