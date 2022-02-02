package lt.vcs.musicapp.main.artist.model.details;

import lt.vcs.musicapp.main.artist.model.details.Artist;

public class ArtistApiResponse {

    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "ArtistApiResponse{" +
                "artist=" + artist +
                '}';
    }
}
