package lt.vcs.musicapp.main.track.model.details;

import java.util.List;

import lt.vcs.musicapp.main.artist.model.details.Image;

public class TrackMatch {

    private String name;
    private String artist;
    private List<Image> image;

    public TrackMatch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", image=" + image +
                '}';
    }
}
