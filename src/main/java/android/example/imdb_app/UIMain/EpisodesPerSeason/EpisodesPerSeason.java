package android.example.imdb_app.UIMain.EpisodesPerSeason;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.imdb_app.Data.Episode;
import android.example.imdb_app.Data.Episode_;
import android.example.imdb_app.Data.Movie;
import android.example.imdb_app.Interface.JSONAPIHolder;
import android.example.imdb_app.R;
import android.example.imdb_app.UIMain.movies.MovieAdapter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EpisodesPerSeason extends AppCompatActivity {

    JSONAPIHolder jsonapiHolder;
    private ArrayList<Episode_> mEpisodesList;
    private EpisodesPerSeasonAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private static final String BASE_URL = "https://imdb-api.com/";
    private String SeasonNumber, ShowID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes_per_season);
        SeasonNumber = getIntent().getStringExtra("Season_Number");
        ShowID = getIntent().getStringExtra("tvshowid");

        mEpisodesList = new ArrayList<>();
        //Initializing RecyclerView and Layout to the recyclerview

        mRecyclerView= findViewById(R.id.episodesReyclerViewer);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EpisodesPerSeasonAdapter(mEpisodesList);
        mRecyclerView.setAdapter(mAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonapiHolder = retrofit.create(JSONAPIHolder.class);


        setEpisodes(ShowID, SeasonNumber);

    }

    public void setEpisodes(String id, String seasonNumber){
        //Retrofit Builder

        Call<Episode> call = jsonapiHolder.getEpisodes(id, seasonNumber);

        call.enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                mEpisodesList = response.body().getEpisodes();
                mAdapter.setEpisodesList(mEpisodesList);
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {

            }
        });


    }





}