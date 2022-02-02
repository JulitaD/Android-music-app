package lt.vcs.musicapp.main.artist.model.details;

import java.util.List;

import lt.vcs.musicapp.main.artist.model.details.Artist;

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
