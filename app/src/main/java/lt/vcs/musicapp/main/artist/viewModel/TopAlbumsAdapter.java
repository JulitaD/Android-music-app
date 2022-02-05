package lt.vcs.musicapp.main.artist.viewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import lt.vcs.musicapp.ClickListener;
import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.album.model.details.TopAlbum;

public class TopAlbumsAdapter extends RecyclerView.Adapter<TopAlbumsAdapter.ViewHolder> {

    List<TopAlbum> topAlbumsList;
    Context context;
    public static ClickListener clickListener;

    public TopAlbumsAdapter(List<TopAlbum> list, Context context) {
        this.topAlbumsList = list;
        this.context = context;
    }

    public void addTopAlbumsList(List<TopAlbum> list) {
        this.topAlbumsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopAlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_top_albums, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopAlbumsAdapter.ViewHolder holder, int position) {
        holder.albumNameTextView.setText(topAlbumsList.get(position).getName());
        Glide.with(context)
                .load(topAlbumsList.get(position).getImage().get(3).getText())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return topAlbumsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView albumNameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumNameTextView = itemView.findViewById(R.id.topAlbumNameTextView);
            imageView = itemView.findViewById(R.id.topAlbumImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TopAlbumsAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener
                                               clickListener) {
        ArtistsAdapter.clickListener = clickListener;
    }
}
