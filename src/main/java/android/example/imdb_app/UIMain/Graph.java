package android.example.imdb_app.UIMain;

import androidx.appcompat.app.AppCompatActivity;

import android.example.imdb_app.Data.Episode;
import android.example.imdb_app.Data.Episode_;
import android.example.imdb_app.Data.TvShowID;
import android.example.imdb_app.Interface.JSONAPIHolder;
import android.example.imdb_app.R;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Graph extends AppCompatActivity{

    JSONAPIHolder jsonapiHolder;
    private ArrayList<Episode_> mAllEpisodesList;
    TextView textview;
    private ArrayList<Episode_> currentArrayList;
    private static final String BASE_URL = "https://imdb-api.com/";
    private String TotalSeasons, ShowID;
    private ArrayList<Entry> yValues;

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //Make linechart
//        mChart = (LineChart) findViewById(R.id.graph_linechart);
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//       yValues = new ArrayList<>();

       //yValues.add(new Entry(0,Float.valueOf(mAllEpisodesList.get(0).getImDbRating())));

//
//        LineDataSet set1= new LineDataSet(yValues, "Data set 1");
//
//        set1.setFillAlpha(110);
//        set1.setColor(Color.RED);
//        set1.setLineWidth(3f);
//        set1.setValueTextSize(3f);
//
//        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//        dataSets.add(set1);
//
//        LineData data = new LineData(dataSets);
//
//        mChart.setData(data);


      //  Number of season for the TV Show
        TotalSeasons = getIntent().getExtras().getString("TotalSeasons");
        ShowID = getIntent().getExtras().getString("tvshowid");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonapiHolder = retrofit.create(JSONAPIHolder.class);

      setGraph(ShowID, TotalSeasons);



    }


    public void setGraph(String id, String totalSeasons){
        //make API call for each season. Add each season's episodes ArrayList in an
        mAllEpisodesList = new ArrayList<>();
        for (int i=1; i< Integer.valueOf(totalSeasons) +1; i++){
            Log.v("testSeasonNumber", String.valueOf(i));
        Call<Episode> call = jsonapiHolder.getEpisodes(id, String.valueOf(i));
        call.enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                // Add all episodes objects to Arraylist mAllEpisodeslist
                 currentArrayList = new ArrayList<>();
                 currentArrayList= response.body().getEpisodes();
                Log.v("test123", currentArrayList.get(0).getTitle());
                for (Episode_ episode : currentArrayList){
                  // Log.v("test123", "current object: Season number: " + episode.getSeasonNumber() + " Episode number: " + episode.getEpisodeNumber());
                    mAllEpisodesList.add(episode);

                }
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {
                Toast.makeText(Graph.this, "API request Failed", Toast.LENGTH_SHORT).show();

            }
        });
        }

    }
    }

