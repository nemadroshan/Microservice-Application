package com.micropro.ratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> userRating;

    public UserRating() {
        System.out.println("userRating no param constructor");
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

    public void init(String  id){
        this.userId =id;
        this.setUserRating(Arrays.asList(new Rating("100",4)
        , new Rating("200",5)));
    }
}
