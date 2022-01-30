package lt.vcs.musicapp.model;

public class ArtistImage {

    private String text; // #text?
    private String size;

    public ArtistImage(String text, String size) {
        this.text = text;
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArtistImage{" +
                "text='" + text + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
