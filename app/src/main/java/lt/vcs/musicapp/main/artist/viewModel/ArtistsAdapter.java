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

import java.util.List;

import lt.vcs.musicapp.ClickListener;
import lt.vcs.musicapp.R;
import lt.vcs.musicapp.main.artist.model.details.Artist;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {

    List<Artist> artistList;
    Context context;
    public static ClickListener clickListener;

    public ArtistsAdapter(List<Artist> list, Context context) {
        this.artistList = list;
        this.context = context;
    }

    public void addList(List<Artist> list) {
        this.artistList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_artists, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ViewHolder holder, int position) {
        holder.artistNameTextView.setText(artistList.get(position).getName());
        Glide.with(context)
                .load(artistList.get(position).getImage().get(3).getText())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView artistNameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistNameTextView = itemView.findViewById(R.id.artistNameTextView);
            imageView = itemView.findViewById(R.id.artistImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ArtistsAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener
                                               clickListener) {
        ArtistsAdapter.clickListener = clickListener;
    }
}

