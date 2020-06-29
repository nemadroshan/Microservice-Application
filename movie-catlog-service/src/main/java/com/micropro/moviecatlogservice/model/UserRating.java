package com.micropro.moviecatlogservice.model;

import java.util.List;

public class UserRating {
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
}
