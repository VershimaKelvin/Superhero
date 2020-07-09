package com.barefooted.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Profile {

    @SerializedName("results")
    private
    ArrayList<Results> results;

    public ArrayList<Results> getResults() {
        return results;
    }



}
