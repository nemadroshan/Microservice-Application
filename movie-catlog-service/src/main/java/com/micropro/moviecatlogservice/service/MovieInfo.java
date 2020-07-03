package com.micropro.moviecatlogservice.service;

import com.micropro.moviecatlogservice.model.CatlogItem;
import com.micropro.moviecatlogservice.model.Movie;
import com.micropro.moviecatlogservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackCaltogItem",
            commandProperties = {@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")}

            , threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )


    public CatlogItem getCatlogItem(Rating rating) {
        //geting movie object for each movie id nd ratting
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

        return new CatlogItem(movie.getMovieName(), movie.getMovieOverView(), rating.getRating());
    }


    public CatlogItem getFallBackCaltogItem(Rating rating) {
        return new CatlogItem("No Movie Name Found", " ", 0);
    }
}
