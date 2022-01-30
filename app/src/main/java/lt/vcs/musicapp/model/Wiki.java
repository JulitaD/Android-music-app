package lt.vcs.musicapp.model;

public class Wiki {

    private String content;

    public Wiki(String content) {
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
        return "Wiki{" +
                "content='" + content + '\'' +
                '}';
    }
}
