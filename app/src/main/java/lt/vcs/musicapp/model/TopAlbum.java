package lt.vcs.musicapp.model;

import java.util.List;

public class TopAlbum {

    private String name;
    private Artist artist;
    private List<Image> image;

    public TopAlbum(String name, Artist artist, List<Image> image) {
        this.name = name;
        this.artist = artist;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TopAlbum{" +
                "name='" + name + '\'' +
                ", artist=" + artist +
                ", image=" + image +
                '}';
    }
}
