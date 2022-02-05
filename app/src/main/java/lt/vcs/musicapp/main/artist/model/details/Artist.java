package lt.vcs.musicapp.main.artist.model.details;

import java.util.List;

public class Artist {

    private String name;
    private List<Image> image;
    private Artists similar;
    private Biography bio;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public Biography getBio() {
        return bio;
    }

    public void setBio(Biography bio) {
        this.bio = bio;
    }

    public Artists getSimilar() {
        return similar;
    }

    public void setSimilar(Artists similar) {
        this.similar = similar;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", similar=" + similar +
                ", biography=" + bio +
                '}';
    }
}

