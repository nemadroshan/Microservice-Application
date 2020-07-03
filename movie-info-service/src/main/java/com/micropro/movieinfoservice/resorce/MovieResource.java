package com.micropro.movieinfoservice.resorce;

import com.micropro.movieinfoservice.model.Movie;
import com.micropro.movieinfoservice.model.MovieSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @Value("${api.key}")
    private String api_key;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + api_key, MovieSummary.class);
        return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
    }
}
