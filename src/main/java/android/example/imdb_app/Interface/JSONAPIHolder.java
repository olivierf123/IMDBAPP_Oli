package android.example.imdb_app.Interface;

import android.example.imdb_app.API_KEY;
import android.example.imdb_app.Data.Episode;
import android.example.imdb_app.Data.Movie;
import android.example.imdb_app.Data.TvShow;
import android.example.imdb_app.Data.TvShowID;
import android.example.imdb_app.Data_TvShowInfo.InfoAll;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONAPIHolder {

    String BASE_URL = "https://imdb-api.com/";

    // API key = k_gt01q9td
    // API key #2 = k_b41c4awq
    // APi key #3 = k_rxy5cwdv

    // Get TV Movies API Call

    @GET("en/API/Top250Movies/k_b41c4awq" )
    Call<Movie> getTvMovies();

    // Get TV Shows API Call

    @GET("en/API/Top250TVs/k_b41c4awq/" )
    Call<TvShow> getTvShow();

    // Get Episode API Call

    @GET("en/API/SearchSeries/k_b41c4awq/{id}")
    Call<TvShowID> getTvShowID(@Path("id") String id);

    //Get all the infos
    @GET("en/API/Title/k_b41c4awq/{id}")
    Call<InfoAll> getTvShowInfo(@Path("id") String tvshowID);

    //Get season episodes
    @GET("en/API/SeasonEpisodes/k_b41c4awq/{id}/{season_number}")
    Call<Episode> getEpisodes(@Path("id") String id, @Path("season_number") String seasonNumber);

}
