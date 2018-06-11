package com.threadhomework.mohsen.recyclerview;

public class Shortcut {

    private String name ;
    private String path ;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Shortcut(String name, String path , int image) {
        this.name = name;
        this.path = path;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
