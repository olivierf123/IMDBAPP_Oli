package android.example.imdb_app.UIMain.tvshows;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.imdb_app.API_KEY;
import android.example.imdb_app.Data.Item;
import android.example.imdb_app.Data.TvShow;
import android.example.imdb_app.Interface.JSONAPIHolder;
import android.example.imdb_app.R;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvShows extends AppCompatActivity {

    private static final String TAG = "TvShows";
    
    private ArrayList<Item> tvshows;
    private TvshowAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String BASE_URL = "https://imdb-api.com/";

    private static String JSON_URL_250_TV_SHOWS = "https://imdb-api.com/en/API/Top250TVs/" + API_KEY.getAPI_KEY();

    JSONAPIHolder jsonapiHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);

        tvshows = new ArrayList<>();
        //Initializing RecyclerView and Layout to the recyclerview

        mRecyclerView= findViewById(R.id.tvshowsRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TvshowAdapter(tvshows);
        mRecyclerView.setAdapter(mAdapter);


        // RetroFit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonapiHolder = retrofit.create(JSONAPIHolder.class);

        setTvShows();

    }


    public void setTvShows(){

        Call<TvShow> call = jsonapiHolder.getTvShow();

        call.enqueue(new Callback<TvShow>() {
            @Override
            public void onResponse(Call<TvShow> call, Response<TvShow> response) {
                tvshows = response.body().getItems();
                mAdapter.setTvShowList(tvshows);
            }

            @Override
            public void onFailure(Call<TvShow> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.e(TAG, "onFailure: ");
                }

                Log.d(TAG, "Code: " + t.getMessage());
            }
            
        });




    }


}