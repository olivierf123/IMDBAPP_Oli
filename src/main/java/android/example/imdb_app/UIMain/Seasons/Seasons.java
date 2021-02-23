package android.example.imdb_app.UIMain.Seasons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.imdb_app.Data.Episode;
import android.example.imdb_app.Data.Episode_;
import android.example.imdb_app.Data.Movie;
import android.example.imdb_app.Data.Result;
import android.example.imdb_app.Data_TvShowInfo.InfoAll;
import android.example.imdb_app.Data_TvShowInfo.TvSeriesInfo;
import android.example.imdb_app.Interface.JSONAPIHolder;
import android.example.imdb_app.R;
import android.example.imdb_app.UIMain.EpisodesPerSeason.EpisodesPerSeason;
import android.example.imdb_app.UIMain.Graph;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Seasons extends AppCompatActivity  {

    private String TvshowID;
    JSONAPIHolder jsonapiHolder;
    private int NumberofSeasons;
    ListView seasons_clickable_views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasons);

        TvshowID = getIntent().getExtras().getString("resultTvShow");

       // https://imdb-api.com/en/API/Title/API_KEY/ID/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://imdb-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonapiHolder = retrofit.create(JSONAPIHolder.class);
        seasons_clickable_views = findViewById(R.id.listview_seasons);

        findNumberOfSeasons(TvshowID);

    }

    private void findNumberOfSeasons(String tvShowID) {
        //Retrofit Builder
        Call<InfoAll> call = jsonapiHolder.getTvShowInfo(TvshowID);

        call.enqueue(new Callback<InfoAll>() {
            @Override
            public void onResponse(Call<InfoAll> call, Response<InfoAll> response) {

                NumberofSeasons = response.body().getTvSeriesInfo().getSeasons().size();

                ArrayList<String> seasons_arraylist = new ArrayList<>();
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1, seasons_arraylist);

                seasons_arraylist.add("GRAPH BUTTON");

                //Add a view in the ListView according to the number of seasons
                for (int i=1 ; i< NumberofSeasons+1; i++){
                    seasons_arraylist.add("Season : " + i);
                    seasons_clickable_views.setAdapter(arrayAdapter);
                    seasons_clickable_views.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //If Graph Button is clicked (position=0) then Start the Graph activity
                            if(position ==0){
                                Intent graph_intent = new Intent(getBaseContext(), Graph.class);
                                graph_intent.putExtra("TotalSeasons", String.valueOf(NumberofSeasons));
                                graph_intent.putExtra("tvshowid", String.valueOf(TvshowID));
                                startActivity(graph_intent);

                            //If one of the season button is clicked, opens the EpisodesPerSeason activity
                            } else{
                            Intent intent = new Intent(getBaseContext(), EpisodesPerSeason.class);
                            intent.putExtra("Season_Number", String.valueOf(position));
                            intent.putExtra("tvshowid", String.valueOf(TvshowID));
                            startActivity(intent);
                            }
                        }
                    });
                }

        }
            @Override
            public void onFailure(Call<InfoAll> call, Throwable t) {

            }
        });
    }


}

