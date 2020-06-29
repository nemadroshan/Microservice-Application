package com.micropro.moviecatlogservice.model;

public class Movie {
    private String movieId;
    private String movieName;
    private String movieOverView;

    public String getMovieOverView() {
        return movieOverView;
    }

    public void setMovieOverView(String movieOverView) {
        this.movieOverView = movieOverView;
    }

    public Movie() {
        System.out.println("Movie :: No Param contructor");
    }

    public Movie(String movieId, String movieName, String movieOverview) {
        System.out.println("Movie :: 2param contructor executed");
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieOverView= movieOverview;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
