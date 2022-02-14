package lt.vcs.musicapp.main.artist.model.search;

import com.google.gson.annotations.SerializedName;

import lt.vcs.musicapp.main.artist.model.details.Artists;

public class GeoApiResponse {


    private Artists topartists;

    public GeoApiResponse(Artists topArtists) {
        this.topartists = topArtists;
    }

    public Artists getGeoTopArtists() {
        return topartists;
    }

    public void setGeoTopArtists(Artists topArtists) {
        this.topartists = topArtists;
    }

    @Override
    public String toString() {
        return "GeoApiResponse{" +
                "geoTopArtists=" + topartists +
                '}';
    }
}
