package com.micropro.moviecatlogservice.model;

public class CatlogItem {

    private String name;
    private String decs;
    private int rating;

    public CatlogItem(String name, String decs, int rating) {
        System.out.println("3 -param constructor is called");
        this.name = name;
        this.decs = decs;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
