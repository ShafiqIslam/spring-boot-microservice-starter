package xyz.microservicestarter.moviecatalogservice;

public class CatalogItem {
    private Movie movie;
    private Rating rating;

    public CatalogItem(Movie movie, Rating rating) {
        this.movie = movie;
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
