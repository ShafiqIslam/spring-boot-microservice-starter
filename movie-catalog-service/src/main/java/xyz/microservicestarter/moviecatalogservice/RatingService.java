package xyz.microservicestarter.moviecatalogservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackGetRatings",
            threadPoolKey = "getRatingsPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    Rating[] getRatings(int userId) {
        return restTemplate.getForObject("http://rating-service/ratings/user/" + userId, Rating[].class);
    }

    Rating[] fallbackGetRatings(int userId) {
        return List.of(new Rating()).toArray(Rating[]::new);
    }
}
