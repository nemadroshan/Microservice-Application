package com.micropro.moviecatlogservice.resorce;

import com.micropro.moviecatlogservice.model.CatlogItem;
import com.micropro.moviecatlogservice.model.Movie;
import com.micropro.moviecatlogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogResoure {
    @Autowired
    private RestTemplate restTemplate;


    //@Autowired
    //private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatlogItem> getAllCatlog(@PathVariable("userId") String userId) {
        //getting list of ratings
        UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/user/foo" + userId, UserRating.class);


        return ratings.getUserRating().stream().map(rating -> {
                    //geting movie object for each movie id nd ratting
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    /*
                    Movie movie = webClientBuilder.build().
                            get().
                            uri("http://localhost:8082/movies/"+ rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class).
                             block();
                    */
                    return new CatlogItem(movie.getMovieName(),movie.getMovieOverView(), rating.getRating());
                }
        ).collect(Collectors.toList());
    }
}
