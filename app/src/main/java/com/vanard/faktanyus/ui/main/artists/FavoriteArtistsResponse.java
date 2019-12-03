package com.vanard.faktanyus.ui.main.artists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/* renamed from: com.vanard.faktanyus.ui.main.artists.FavoriteArtistsResponse */
public class FavoriteArtistsResponse {
    @SerializedName("data")
    private List<ArtistItem> data;

    public List<ArtistItem> getData() {
        return this.data;
    }

    public void setData(List<ArtistItem> data2) {
        this.data = data2;
    }
}
