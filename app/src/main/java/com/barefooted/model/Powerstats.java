package com.barefooted.model;

import com.google.gson.annotations.SerializedName;

public class Powerstats {

    @SerializedName("intelligence")
    private String intelligence;

    @SerializedName("speed")
    private String speed;

    @SerializedName("strength")
    private String strength;

    @SerializedName("durability")
    private String durability;

    @SerializedName("combat")
    private String combat;

    public String getIntelligence() {
        return intelligence;
    }

    public String getDurability() {
        return durability;
    }

    public String getCombat() {
        return combat;
    }

    public String getSpeed() {
        return speed;
    }


    public String getStrength() {
        return strength;
    }

}
