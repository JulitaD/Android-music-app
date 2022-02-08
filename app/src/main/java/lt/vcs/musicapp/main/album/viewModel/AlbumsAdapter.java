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

import lt.vcs.musicapp.ClickListener;
import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.model.details.Album;
import lt.vcs.musicapp.main.artist.model.details.Artist;
import lt.vcs.musicapp.main.artist.viewModel.ArtistsAdapter;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    List<Album> albumList;
    Context context;
    public static ClickListener clickListener;

    public AlbumsAdapter(List<Album> list, Context context) {
        this.albumList = list;
        this.context = context;
    }

    public void addList(List<Album> list) {
        this.albumList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_albums, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsAdapter.ViewHolder holder, int position) {
        holder.albumNameTextView.setText(albumList.get(position).getName());
        holder.artistNameTextView.setText(albumList.get(position).getArtist());
        Glide.with(context)
                .load(albumList.get(position).getImage().get(3).getText())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView albumNameTextView;
        TextView artistNameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumNameTextView = itemView.findViewById(R.id.albumSearchAlbumNameTextView);
            artistNameTextView = itemView.findViewById(R.id.albumSearchArtistNameTextView);
            imageView = itemView.findViewById(R.id.albumSearchImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            AlbumsAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);

        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        AlbumsAdapter.clickListener = clickListener;
    }
}
