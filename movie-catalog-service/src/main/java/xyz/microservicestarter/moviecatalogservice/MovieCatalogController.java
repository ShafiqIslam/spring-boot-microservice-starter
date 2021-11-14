package xyz.microservicestarter.moviecatalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/{userId}")
    public List<CatalogItem> index(@PathVariable int userId) {
        Rating[] ratings = ratingService.getRatings(userId);

        return Arrays.asList(ratings).stream().map(rating -> {
            Movie movie = movieInfoService.getMovieDetails(rating.getMovieId());
            return new CatalogItem(movie, rating);
        }).collect(Collectors.toList());
    }
}
