package lt.vcs.musicapp.main.artist.model.details;

public class Biography {

    private String content;

    public Biography(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Biography{" +
                "content='" + content + '\'' +
                '}';
    }
}
