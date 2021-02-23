package android.example.imdb_app.UIMain.movies;
import android.content.Intent;
import android.example.imdb_app.Data.Item;
import android.example.imdb_app.R;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Item> mMovieList;

    // Pass an ArrayList to the adapter
    public MovieAdapter(ArrayList<Item> mMovieList){
        this.mMovieList = mMovieList;

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(v);

        return movieViewHolder;
    }

    public void setMovieList(ArrayList<Item> mMovieList){
        this.mMovieList = mMovieList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Item currentMovie = mMovieList.get(position);
        String imageURL = currentMovie.getImage();

        //Get image with Picasso Library
        Picasso.get().load(imageURL).resize(200,250).into(holder.mMovie_image);
        //Get ID
        holder.mMovie_rating.setText(currentMovie.getImDbRating() + "/10");
        //Get title
        holder.mMovie_name.setText(currentMovie.getTitle());

        // TODO onclicklistener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.imdb.com/title/" + currentMovie.getId())));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{

        public ImageView mMovie_image;
        public TextView mMovie_rating;
        public TextView mMovie_name;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            mMovie_image = itemView.findViewById(R.id.movie_image);
            mMovie_rating = itemView.findViewById(R.id.movie_rating);
            mMovie_name = itemView.findViewById(R.id.movie_name);

        }



    }
}
