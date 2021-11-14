package xyz.microservicestarter.movieinfoservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDbSummary {

    private String id;
    private String title;
    @JsonProperty("release_date")
    private String releaseDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getReleaseYear() {
        return Integer.parseInt(releaseDate.split("-")[0]);
    }

}
