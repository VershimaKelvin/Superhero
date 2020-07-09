package com.barefooted.model;

import com.google.gson.annotations.SerializedName;

public class Connection {

    @SerializedName("group-affiliation")
    private String group_affiliation;

    @SerializedName("relatives")
    private String relatives;

    public String getGroup_affiliation() {
        return group_affiliation;
    }

    public String getRelatives() {
        return relatives;
    }
}
