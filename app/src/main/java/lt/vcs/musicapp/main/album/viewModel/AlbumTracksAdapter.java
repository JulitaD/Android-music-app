package lt.vcs.musicapp.main.album.viewModel;

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
import lt.vcs.musicapp.main.track.model.details.Track;

public class AlbumTracksAdapter extends RecyclerView.Adapter<AlbumTracksAdapter.ViewHolder> {

    List<Track> albumTracks;
    Context context;

    public AlbumTracksAdapter (List<Track> list, Context context) {
        this.albumTracks = list;
        this.context = context;
    }

    public void addAlbumTrackList(List<Track> list) {
        this.albumTracks = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumTracksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_album_tracks, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.albumTrackNameTextView.setText(albumTracks.get(position).getName());
        Glide.with(context)
                .load(albumTracks.get(position).getImage().get(3).getText())
                .into(holder.albumTrackImageView);
    }

    @Override
    public int getItemCount() {
        return albumTracks.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView albumTrackNameTextView;
        ImageView albumTrackImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumTrackNameTextView = itemView.findViewById(R.id.albumTrackNameTextView);
            albumTrackImageView = itemView.findViewById(R.id.albumTrackImageView);
        }
    }
}
