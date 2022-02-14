package lt.vcs.musicapp.main.artist.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.common.ClickListener;
import lt.vcs.musicapp.main.artist.model.details.Artist;

public class GeoTopArtistsAdapter extends RecyclerView.Adapter<GeoTopArtistsAdapter.ViewHolder> {

    List<Artist> geoTopArtistsList;
    Context context;
    public static ClickListener clickListener;

    public GeoTopArtistsAdapter(List<Artist> list, Context context) {
        this.geoTopArtistsList = list;
        this.context = context;
    }

    public void addGeoTopArtistsList(List<Artist> list) {
        this.geoTopArtistsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GeoTopArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_geo_top_artists, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GeoTopArtistsAdapter.ViewHolder holder, int position) {
        holder.artistNameTextView.setText(geoTopArtistsList.get(position).getName());
        Glide.with(context)
                .load(geoTopArtistsList.get(position).getImage().get(3).getText())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return geoTopArtistsList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView artistNameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistNameTextView = itemView.findViewById(R.id.geoTopArtistNameTextView);
            imageView = itemView.findViewById(R.id.geoTopArtistImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            GeoTopArtistsAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }

    }

    public void setOnItemClickListener(ClickListener clickListener) {
        GeoTopArtistsAdapter.clickListener = clickListener;
    }
}
