package com.etido.gadsleaderboardapp.Model;

import com.google.gson.annotations.SerializedName;

public class SkilliqModel {
    @SerializedName ("name")
    private String name;
    @SerializedName ("score")
    private int score;
    @SerializedName ("country")
    private String country;
    @SerializedName ("badgeUrl")
    private String badgeUrl;


    public SkilliqModel(String name, Integer score,
                              String country, String badgeUrl  ){
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String mName) {
        name = mName;
    }

    public Integer getScore() {
        return score;
    }

    public void setHours(Integer mScore) {
        score = mScore;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String mCountry) {
        country = mCountry;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String mBadgeUrl) {
        badgeUrl = mBadgeUrl;
    }

}
