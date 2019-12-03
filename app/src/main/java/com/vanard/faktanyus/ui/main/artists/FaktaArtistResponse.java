package com.vanard.faktanyus.ui.main.artists;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.vanard.faktanyus.ui.main.artists.FaktaArtistResponse */
public class FaktaArtistResponse {
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("fact")
    private String fact;

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName2) {
        this.artistName = artistName2;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday2) {
        this.birthday = birthday2;
    }

    public String getFact() {
        return this.fact;
    }

    public void setFact(String fact2) {
        this.fact = fact2;
    }
}
