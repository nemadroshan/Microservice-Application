package com.micropro.moviecatlogservice.resorce;

import com.micropro.moviecatlogservice.model.CatlogItem;
import com.micropro.moviecatlogservice.model.Movie;
import com.micropro.moviecatlogservice.model.Rating;
import com.micropro.moviecatlogservice.model.UserRating;
import com.micropro.moviecatlogservice.service.MovieInfo;
import com.micropro.moviecatlogservice.service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogResoure {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;

    //@Autowired
    //private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatlogItem> getAllCatlog(@PathVariable("userId") String userId) {
        //getting list of ratings
        UserRating ratings = userRatingInfo.getForRatings(userId);


        return ratings.getUserRating().stream().map(rating -> getCatlogItem(rating)).collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "getFallBackCaltogItem")
    public CatlogItem getCatlogItem(Rating rating) {
        //geting movie object for each movie id nd ratting
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

        return new CatlogItem(movie.getMovieName(), movie.getMovieOverView(), rating.getRating());
    }


    public CatlogItem getFallBackCaltogItem(Rating rating) {
        return new CatlogItem("No Movie Name Found", " ", 0);
    }

    @HystrixCommand(fallbackMethod = "userRatingFallBackMethod")
    public UserRating getForRatings(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://rating-data-service/ratingsdata/user/" + userId, UserRating.class);
    }

    public UserRating userRatingFallBackMethod(@PathVariable("userId") String userId) {
        UserRating rating = new UserRating();
        List ratings = Arrays.asList(new Rating(" ", 0));
        return rating;
    }

    public List<CatlogItem> getFallBackCaltog(@PathVariable("userId") String userId) {
        return Arrays.asList(new CatlogItem("no movie", "no desc", 0));
    }
}
