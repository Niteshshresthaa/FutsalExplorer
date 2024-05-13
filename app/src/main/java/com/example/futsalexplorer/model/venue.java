package com.example.futsalexplorer.model;

public class venue {

    private String futsal_name;
    private String futsal_description;

    private String image;

    public venue(String futsal_name, String futsal_description, String image) {
        this.futsal_name = futsal_name;
        this.futsal_description = futsal_description;
        this.image = image;
    }

    public String getFutsal_name() {
        return futsal_name;
    }

    public void setFutsal_name(String futsal_name) {
        this.futsal_name = futsal_name;
    }

    public String getFutsal_description() {
        return futsal_description;
    }

    public void setFutsal_description(String futsal_description) {
        this.futsal_description = futsal_description;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
