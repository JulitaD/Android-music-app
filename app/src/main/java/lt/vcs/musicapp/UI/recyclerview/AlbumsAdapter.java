package lt.vcs.musicapp.UI.recyclerview;

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
import lt.vcs.musicapp.model.Album;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder>  {

        List<Album> albumList;
        Context context;

public AlbumsAdapter(List<Album> list, Context context) {
        this.albumList = list;
        this.context = context;
        }

@NonNull
@Override
public AlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recyclerview_item, parent, false));
        }

@Override
public void onBindViewHolder(@NonNull AlbumsAdapter.ViewHolder holder, int position) {
        holder.albumNameTextView.setText(albumList.get(position).getName());
        Glide.with(context)
        .load(albumList.get(position).getImage().get(3).getText())
        .into(holder.imageView);

        }

@Override
public int getItemCount() {
        return albumList.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {
    TextView albumNameTextView;
    TextView artistNameTextView;
    ImageView imageView;
//        Button favoriteButton;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        albumNameTextView = itemView.findViewById(R.id.firstNameTextView);
        artistNameTextView = itemView.findViewById(R.id.secondNameTextView);
        imageView = itemView.findViewById(R.id.imageView);
//            favoriteButton = itemView.findViewById(R.id.favoriteButton);
    }
}
}
