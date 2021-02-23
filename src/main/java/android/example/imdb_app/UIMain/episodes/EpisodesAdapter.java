package android.example.imdb_app.UIMain.episodes;

import android.content.Context;
import android.content.Intent;
import android.example.imdb_app.Data.Episode_;
import android.example.imdb_app.Data.Result;
import android.example.imdb_app.R;
import android.example.imdb_app.UIMain.Seasons.Seasons;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder> {
    Context context;
    public ArrayList<Result> results;

    public EpisodesAdapter(Context context, ArrayList<Result> results) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public EpisodesAdapter.EpisodesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.episodes_recyclerview_layout ,parent,false);
        EpisodesViewHolder episodesViewHolder = new EpisodesViewHolder(view);
        return episodesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesViewHolder holder, int position) {


        Glide.with(context)
                .asBitmap()
                .load(results.get(position).getImage())
                .into(holder.imageViewEpisodes);

        holder.titleTextView
                .setText(results.get(position).getTitle());
        holder.descriptionTextView.setText(results.get(position).getDescription());

        //Clicker listener on items (results array)
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Seasons.class);
                intent.putExtra("resultTvShow", results.get(position).getId() );
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }



    public void setEpisodesList(ArrayList<Result> results){
        this.results = results;
        notifyDataSetChanged();
    }


    public class EpisodesViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, descriptionTextView;
        ImageView imageViewEpisodes;
        public EpisodesViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleSeries);
            descriptionTextView = itemView.findViewById(R.id.descriptionSeries);
            imageViewEpisodes = itemView.findViewById(R.id.imageSeries);

        }
    }

}