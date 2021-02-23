package android.example.imdb_app.UIMain.tvshows;

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

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.tvshowViewHolder> {

    private ArrayList<Item> tvshow_list;

    @NonNull
    @Override
    public tvshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvshow, parent, false);
        tvshowViewHolder tvshowViewHolder = new tvshowViewHolder(v);

        return tvshowViewHolder;

    }

    public TvshowAdapter(ArrayList<Item> tvshow_list){
        this.tvshow_list = tvshow_list;
    }

    @Override
    public void onBindViewHolder(@NonNull tvshowViewHolder holder, int position) {
        Item currentTvShow = tvshow_list.get(position);
        String imageURL = currentTvShow.getImage();

        //Get image with Picasso Library
        Picasso.get().load(imageURL).resize(200,250).into(holder.mTvshowImage);
        //Get ID
        holder.mTvShow_rating.setText(currentTvShow.getImDbRating() + "/10");
        //Get title
        holder.mTvShow_name.setText(currentTvShow.getTitle());

        //Opens imdb webpage on tv shows clicks
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.imdb.com/title/" + currentTvShow.getId())));
            }
        });
    }

    public void setTvShowList(ArrayList<Item> tvshow_list){
        this.tvshow_list = tvshow_list;
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return tvshow_list.size();
    }

    public static class tvshowViewHolder extends RecyclerView.ViewHolder{

        public ImageView mTvshowImage;
        public TextView mTvShow_rating;
        public TextView mTvShow_name;

        public tvshowViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvshowImage = itemView.findViewById(R.id.tvshow_image);
            mTvShow_rating = itemView.findViewById(R.id.tvshow_rating);
            mTvShow_name = itemView.findViewById(R.id.tvshow_name);
        }
    }

}
