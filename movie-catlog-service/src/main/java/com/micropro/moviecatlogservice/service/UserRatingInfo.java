package com.micropro.moviecatlogservice.service;

import com.micropro.moviecatlogservice.model.Rating;
import com.micropro.moviecatlogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRatingInfo {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userRatingFallBackMethod",
            threadPoolKey = "userRatingPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public UserRating getForRatings(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://rating-data-service/ratingsdata/user/" + userId, UserRating.class);
    }

    public UserRating userRatingFallBackMethod(@PathVariable("userId") String userId) {
        UserRating rating = new UserRating();
        List ratings = Arrays.asList(new Rating("No Movies id", 0));
        return rating;
    }

}
