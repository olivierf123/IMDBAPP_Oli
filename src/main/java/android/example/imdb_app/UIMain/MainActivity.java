package android.example.imdb_app.UIMain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.example.imdb_app.R;
import android.example.imdb_app.UIMain.episodes.EpisodesGraph;
import android.example.imdb_app.UIMain.movies.TvMovies;
import android.example.imdb_app.UIMain.tvshows.TvShows;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //TODO #1 Mettre le API key dans une classe séparer et mettre le variable APIKEY dans le lien
    //https://abhiandroid.com/programming/json#:~:text=Example%201%20of%20Simple%20JSON%20Parsing%20In%20Android%20Studio%3A,-Below%20is%20the&text=Firstly%20we%20create%20two%20TextView,it%20in%20the%20TextView's.&text=Step%201%3A%20Create%20a%20new,xml%20(or)%20main.
    //TODO #1 Rajouter le RatingBar et lautre textview jai rajouter dans class Movie et adapter etc...
    //TODO #2 Ramplcer la ArrayList par un JSON file que je vais importer du API
    //TODO quand jai fin avec TvMovies, faire les autres activitys.
    //TODO #5 ADD DES MINI MENUS POUR RESEARCH PAR RELEASE DATE?
    //TODO ADD YOUTUBE TRAILER BOUTTON AVEC UN INTENT QUI OUVRE YOUTUBE


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CardViews
        CardView cardView_home = (CardView) findViewById(R.id.cardview_home);
        CardView cardview_episodes = (CardView) findViewById(R.id.cardview_episodes);
        CardView cardview_tvshows = (CardView) findViewById(R.id.cardview_tvshows);
        CardView cardview_movies = (CardView) findViewById(R.id.cardview_movies);

        cardView_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cardview_episodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), EpisodesGraph.class);
                v.getContext().startActivity(intent);
            }
        });

        cardview_movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), TvMovies.class);
                v.getContext().startActivity(intent);
            }
        });

        cardview_tvshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), TvShows.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}

//TODO Layout faire que les boutons sont plus petit, changer couleurs, icons etc... Layout pris de https://www.youtube.com/watch?v=YKssd_9x8Eg