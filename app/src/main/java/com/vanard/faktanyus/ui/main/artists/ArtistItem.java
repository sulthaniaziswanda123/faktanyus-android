package com.vanard.faktanyus.ui.main.artists;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.vanard.faktanyus.ui.main.artists.ArtistItem */
public class ArtistItem {
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("gender")
    private int gender;
    @SerializedName("id")

    /* renamed from: id */
    private int f186id;
    @SerializedName("known_for_department")
    private String known_for_department;
    @SerializedName("name")
    private String name;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("profile_path")
    private String profile_path;

    public double getPopularity() {
        return this.popularity;
    }

    public void setPopularity(double popularity2) {
        this.popularity = popularity2;
    }

    public String getKnown_for_department() {
        return this.known_for_department;
    }

    public void setKnown_for_department(String known_for_department2) {
        this.known_for_department = known_for_department2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getProfile_path() {
        return this.profile_path;
    }

    public void setProfile_path(String profile_path2) {
        this.profile_path = profile_path2;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender2) {
        this.gender = gender2;
    }

    public int getId() {
        return this.f186id;
    }

    public void setId(int id) {
        this.f186id = id;
    }

    public boolean isAdult() {
        return this.adult;
    }

    public void setAdult(boolean adult2) {
        this.adult = adult2;
    }
}
