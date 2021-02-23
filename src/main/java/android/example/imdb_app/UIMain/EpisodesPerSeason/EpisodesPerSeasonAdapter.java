package android.example.imdb_app.UIMain.EpisodesPerSeason;

import android.example.imdb_app.Data.Episode;
import android.example.imdb_app.Data.Episode_;
import android.example.imdb_app.Data.Item;
import android.example.imdb_app.R;
import android.example.imdb_app.UIMain.movies.MovieAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EpisodesPerSeasonAdapter extends RecyclerView.Adapter<EpisodesPerSeasonAdapter.EpisodesViewHolder> {
    private ArrayList<Episode_> mEpisodesList;

    public EpisodesPerSeasonAdapter(ArrayList<Episode_> mEpisodesList) {
        this.mEpisodesList = mEpisodesList;
    }

    public void setEpisodesList(ArrayList<Episode_> mEpisodesList){
        this.mEpisodesList = mEpisodesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EpisodesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episodes, parent, false);
        EpisodesViewHolder episodesViewHolder = new EpisodesViewHolder(v);

        return episodesViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesPerSeasonAdapter.EpisodesViewHolder holder, int position) {
        Episode_ currentEpisode = mEpisodesList.get(position);

        holder.mEpisodeName.setText(currentEpisode.getTitle());
        holder.mSeasonNumber.setText("Season: " + currentEpisode.getSeasonNumber());
        holder.mEpisodeNumber.setText(" Episode: " + currentEpisode.getEpisodeNumber());
        holder.mEpisodeRating.setText(currentEpisode.getImDbRating() +"/10");

        String imageURL = currentEpisode.getImage();

        //Get image with Picasso Library
        Picasso.get().load(imageURL).resize(200,250).into(holder.mepisodeImage);

    }

    @Override
    public int getItemCount() {
        return mEpisodesList.size();
    }


    public class EpisodesViewHolder extends RecyclerView.ViewHolder {

        TextView mEpisodeName, mEpisodeRating, mSeasonNumber, mEpisodeNumber;
        ImageView mepisodeImage;

        public EpisodesViewHolder(@NonNull View itemView) {
            super(itemView);
            mEpisodeName = itemView.findViewById(R.id.episode_name);
            mSeasonNumber = itemView.findViewById(R.id.textview_season);
            mEpisodeRating = itemView.findViewById(R.id.episode_rating);
            mEpisodeNumber = itemView.findViewById(R.id.textview_episode);
            mepisodeImage = itemView.findViewById(R.id.episode_image);

        }
    }
}
