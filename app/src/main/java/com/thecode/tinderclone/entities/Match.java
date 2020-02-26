package com.thecode.tinderclone.entities;

public class Match {

    private int id;
    private String name;
    private int picture;
    private String location;
    private String date;

    public Match(int id, String name, int picture, String location, String date) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
