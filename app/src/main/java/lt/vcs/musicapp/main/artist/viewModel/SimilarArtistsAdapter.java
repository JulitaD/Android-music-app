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

public class SimilarArtistsAdapter extends RecyclerView.Adapter<SimilarArtistsAdapter.ViewHolder> {

    List<Artist> similarArtistsList;
    Context context;
    public static ClickListener clickListener;

    public SimilarArtistsAdapter(List<Artist> list, Context context) {
        this.similarArtistsList = list;
        this.context = context;
    }

    public void addSimilarArtistsList(List<Artist> list) {
        this.similarArtistsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimilarArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_similar_artists, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarArtistsAdapter.ViewHolder holder, int position) {
        holder.artistNameTextView.setText(similarArtistsList.get(position).getName());
        Glide.with(context)
                .load(similarArtistsList.get(position).getImage().get(3).getText())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return similarArtistsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView artistNameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistNameTextView = itemView.findViewById(R.id.similarArtistNameTextView);
            imageView = itemView.findViewById(R.id.similarArtistImageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SimilarArtistsAdapter.clickListener.onItemClick(getAbsoluteAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        SimilarArtistsAdapter.clickListener = clickListener;
    }
}
