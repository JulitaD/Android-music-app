package lt.vcs.musicapp.UI.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lt.vcs.musicapp.R;
import lt.vcs.musicapp.model.Artist;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder> {

    List<Artist> artistList;
    Context context;

    public ArtistsAdapter(List<Artist> list, Context context) {
        this.artistList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ViewHolder holder, int position) {
        holder.artistNameTextView.setText(artistList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView artistNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistNameTextView = itemView.findViewById(R.id.artistNameTextView);
        }
    }
}

