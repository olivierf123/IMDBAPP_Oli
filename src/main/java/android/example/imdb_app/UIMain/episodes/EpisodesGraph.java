package android.example.imdb_app.UIMain.episodes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.imdb_app.Data.Result;
import android.example.imdb_app.Data.TvShowID;
import android.example.imdb_app.Interface.JSONAPIHolder;
import android.example.imdb_app.R;
import android.example.imdb_app.UIMain.Seasons.Seasons;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EpisodesGraph extends AppCompatActivity {
    private static final String TAG = "EpisodesGraph";

    JSONAPIHolder JSONApiHolderEpisodes;

    public ArrayList<Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes_graph);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://imdb-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONApiHolderEpisodes = retrofit.create(JSONAPIHolder.class);

        SearchView searchViewEpisodes = findViewById(R.id.searchViewSeries);

        searchViewEpisodes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getTVSeries(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

    private void initRecyclerViewEpisodes() {
        RecyclerView recyclerViewEpisodes = findViewById(R.id.seriesRecyclerView);
        EpisodesAdapter episodesAdapter = new EpisodesAdapter(this, results);
        recyclerViewEpisodes.setAdapter(episodesAdapter);
        recyclerViewEpisodes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getTVSeries(String seriesName) {

        Call<TvShowID> call = JSONApiHolderEpisodes.getTvShowID(seriesName);

        call.enqueue(new Callback<TvShowID>() {
            @Override
            public void onResponse(Call<TvShowID> call, Response<TvShowID> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "ResponseCode: " + response.code());
                    return;
                }

                TvShowID  getTvShowID = response.body();

                results = getTvShowID.getResults();
                initRecyclerViewEpisodes();

            }

            @Override
            public void onFailure(Call<TvShowID> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.e(TAG, "onFailure: ");
                } else {
                }
                Log.d(TAG, "Code: " + t.getMessage());
            }
        });

    }
}

