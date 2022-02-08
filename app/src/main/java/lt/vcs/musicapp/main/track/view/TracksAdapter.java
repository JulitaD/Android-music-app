package lt.vcs.musicapp.main.track.view;

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
import lt.vcs.musicapp.main.track.model.details.TrackMatch;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    List<TrackMatch> trackList;
    Context context;

    public TracksAdapter(List<TrackMatch> list, Context context) {
        this.trackList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TracksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_tracks, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TracksAdapter.ViewHolder holder, int position) {
        holder.trackNameTextView.setText(trackList.get(position).getName());
        holder.artistNameTextView.setText(trackList.get(position).getArtist());
        Glide.with(context)
                .load(trackList.get(position).getImage().get(3).getText())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView trackNameTextView;
        TextView artistNameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trackNameTextView = itemView.findViewById(R.id.trackSearchNameTextView);
            artistNameTextView = itemView.findViewById(R.id.trackSearchArtistNameTextView);
            imageView = itemView.findViewById(R.id.trackSearchImageView);
        }
    }
}

