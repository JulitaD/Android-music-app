package lt.vcs.musicapp.model;

import java.util.List;

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
