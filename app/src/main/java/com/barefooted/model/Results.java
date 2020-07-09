package com.barefooted.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("powerstats")
    private Powerstats powerstats;

    @SerializedName("image")
    private Image image;

    @SerializedName("connections")
    private Connection connections;

    @SerializedName("biography")
    private Biography biography;

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Connection getConnections() {
        return connections;
    }

    public Biography getBiography() {
        return biography;
    }

    public String getId() {
        return id;
    }

    public Powerstats getPowerstats() {
        return powerstats;
    }

}
