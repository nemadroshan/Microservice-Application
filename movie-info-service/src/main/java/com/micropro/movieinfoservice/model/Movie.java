package com.micropro.movieinfoservice.model;

public class Movie {
    private String movieId;
    private String movieName;
    private String movieOverView;

    public Movie(String id, String movieId, String movieOverView) {
        System.out.println("Movie :: 2param contructor executed");
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieOverView=movieOverView;
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

    public String getMovieOverView() {
        return movieOverView;
    }

    public void setMovieOverView(String movieOverView) {
        this.movieOverView = movieOverView;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
