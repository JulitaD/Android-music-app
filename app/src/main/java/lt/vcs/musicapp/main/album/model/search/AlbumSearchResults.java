package lt.vcs.musicapp.main.album.model.search;

import lt.vcs.musicapp.main.album.model.details.Albums;

public class AlbumSearchResults {

    private Albums albummatches;

    public AlbumSearchResults(Albums albummatches) {
        this.albummatches = albummatches;
    }

    public Albums getAlbummatches() {
        return albummatches;
    }

    public void setAlbummatches(Albums albummatches) {
        this.albummatches = albummatches;
    }

    @Override
    public String toString() {
        return "AlbumSearchResults{" +
                "albummatches=" + albummatches +
                '}';
    }
}
