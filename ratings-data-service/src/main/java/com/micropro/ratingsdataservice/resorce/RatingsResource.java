package com.micropro.ratingsdataservice.resorce;

import com.micropro.ratingsdataservice.model.Rating;
import com.micropro.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("user/{userId}")
    public UserRating getListOfRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("100", 5), new Rating("200", 4)
        );

        UserRating rating = new UserRating();
        rating.init(userId);
        return rating;
    }
}