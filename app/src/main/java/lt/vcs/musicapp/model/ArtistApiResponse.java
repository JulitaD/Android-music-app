package lt.vcs.musicapp.model;

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
        return "User API response [artist=" + artist + "]";
    }
}
