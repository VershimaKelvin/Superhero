package com.barefooted.model;

import com.google.gson.annotations.SerializedName;

public class Biography {

    @SerializedName("full-name")
    private String full_name;

    @SerializedName("place-of-birth")
    private String place_of_birth;

    @SerializedName("first-appearance")
    private String first_appearance;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("alignment")
    private String alignment;

    public String getFull_name() {
        return full_name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAlignment() {
        return alignment;
    }
}
