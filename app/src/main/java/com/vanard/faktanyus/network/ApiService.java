package com.vanard.faktanyus.network;

import com.vanard.faktanyus.models.openweather.OpenWeatherResponse;
import com.vanard.faktanyus.models.rapidapi.DateFactResponse;
import com.vanard.faktanyus.models.rapidapi.YearFactResponse;
import com.vanard.faktanyus.ui.main.artists.FavoriteArtistsResponse;
import com.vanard.faktanyus.ui.main.artists.FaktaArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("fact/artists")
    Call<FavoriteArtistsResponse> getArtistFavorite();

    @GET("{month}/{day}/date")
    @Headers({"x-rapidapi-host: numbersapi.p.rapidapi.com", "x-rapidapi-key: c474020896msh685205d6da8cbd8p1359fdjsn915617a2042f"})
    Call<DateFactResponse> getDateFact(@Path("month") String str, @Path("day") String str2, @Query("fragment") String str3, @Query("json") String str4);

    @GET("fact/artist/{idArtist}")
    Call<FaktaArtistResponse> getFaktaArtist(@Path("idArtist") int i);

    @GET("weather")
    Call<OpenWeatherResponse> getWeather(@Query("q") String str, @Query("appid") String str2);

    @GET("{year}/year")
    @Headers({"x-rapidapi-host: numbersapi.p.rapidapi.com", "x-rapidapi-key: c474020896msh685205d6da8cbd8p1359fdjsn915617a2042f"})
    Call<YearFactResponse> getYearFact(@Path("year") String str, @Query("fragment") String str2, @Query("json") String str3);
}
