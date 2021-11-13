package xyz.microservicestarter.ratingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @GetMapping("/{movieId}")
    public Rating get(@PathVariable("movieId") int movieId) {
        return new Rating(movieId, 5);
    }

    @GetMapping("user/{userId}")
    public List<Rating> getForUser(@PathVariable("userId") int userId) {
        return List.of(
                new Rating(1, 5),
                new Rating(1, 4)
        );
    }
}
