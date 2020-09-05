package com.etido.gadsleaderboardapp.Model;

import com.google.gson.annotations.SerializedName;

public class LearningHoursModel {
    @SerializedName ("name")
    private String name;
    @SerializedName ("hours")
    private int hours;
    @SerializedName ("country")
    private String country;
    @SerializedName ("badgeUrl")
    private String badgeUrl;


    public LearningHoursModel(String name, Integer hours,
                              String country, String badgeUrl  ){
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String mName) {
        name = mName;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer mHours) {
        hours = mHours;
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
