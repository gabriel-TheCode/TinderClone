package com.thecode.tinderclone.entities;

public class Like {

    private int id;
    private String name;
    private int picture;


    public Like(int id, String name, int picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
