package lt.vcs.musicapp.model;

import java.util.List;

public class Artist {

    private String name;
    private List<ArtistImage> image;
//    private List<SimilarArtist> similar;
    private Biography bio;

    public Artist(String name, List<ArtistImage> image, Biography bio) {
        this.name = name;
        this.image = image;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtistImage> getImage() {
        return image;
    }

    public void setImage(List<ArtistImage> image) {
        this.image = image;
    }

    public Biography getBio() {
        return bio;
    }

    public void setBio(Biography bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Artist [" +
                "name=" + name +
                ", image:" + image +
                ", bio: " + bio;
    }
}
