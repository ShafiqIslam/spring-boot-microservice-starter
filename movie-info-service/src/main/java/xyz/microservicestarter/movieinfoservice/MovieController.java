package xyz.microservicestarter.movieinfoservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @RequestMapping("/{movieId}")
    public Movie get(@PathVariable int movieId) {
        return new Movie(movieId, "Terminator 2", 1998);
    }
}
