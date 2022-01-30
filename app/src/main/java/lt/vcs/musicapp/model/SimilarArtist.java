package lt.vcs.musicapp.model;

import java.util.List;

public class SimilarArtist {

    private List<Artist> artist;

    public SimilarArtist(List<Artist> artist) {
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
        return "SimilarArtist{" +
                "artist=" + artist +
                '}';
    }
}
