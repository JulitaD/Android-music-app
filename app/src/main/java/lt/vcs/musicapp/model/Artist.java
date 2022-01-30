package lt.vcs.musicapp.model;

import java.util.List;

public class Artist {

    private String name;
    private List<String> image;
    private List<Artist> similar;
    private List<String> bio;

    public Artist(String name, List<String> image, List<Artist> similar, List<String> bio) {
        this.name = name;
        this.image = image;
        this.similar = similar;
        this.bio = bio;
    }

    public Artist(String name, List<String> image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public List<Artist> getSimilar() {
        return similar;
    }

    public void setSimilar(List<Artist> similar) {
        this.similar = similar;
    }

    public List<String> getBio() {
        return bio;
    }

    public void setBio(List<String> bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Artist [" +
                "name=" + name +
                ", image=" + image +
                ", similar=" + similar +
                ", bio=" + bio;
    }
}
