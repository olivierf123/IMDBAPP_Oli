package android.example.imdb_app.UIMain.movies;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.imdb_app.API_KEY;
import android.example.imdb_app.Data.Item;
import android.example.imdb_app.Data.Movie;
import android.example.imdb_app.Interface.JSONAPIHolder;
import android.example.imdb_app.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvMovies extends AppCompatActivity {
    // TODO OUVRE LE LIEN IMDB QUAND JE CLIQUE SUR LE FILM (EXCPLITIT?IMPLICIT? INTENT)

    private ArrayList<Item> movies_list;
    private MovieAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String BASE_URL = "https://imdb-api.com/";

    JSONAPIHolder jsonapiHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_movies);

        movies_list = new ArrayList<>();
        //Initializing RecyclerView and Layout to the recyclerview
        mRecyclerView= findViewById(R.id.moviesRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MovieAdapter(movies_list);
        mRecyclerView.setAdapter(mAdapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonapiHolder = retrofit.create(JSONAPIHolder.class);


        setMovies();

    }

    //Retrofit Call
    private void setMovies() {
        //Retrofit Builder

        Call<Movie> call = jsonapiHolder.getTvMovies();

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                movies_list = response.body().getItems();
                mAdapter.setMovieList(movies_list);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }


}
