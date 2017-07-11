package com.example.germanpereyra.radio.holders;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.germanpereyra.radio.R;
import com.example.germanpereyra.radio.model.Playlist;

/**
 * Created by germanpereyra on 22/Jul/16.
 */
public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    private LinearLayout backgroundLayout;
    private TextView name;
    private TextView description;

    public PlaylistViewHolder(View itemView) {
        super(itemView);

        backgroundLayout = (LinearLayout) itemView.findViewById(R.id.background_playlist_layout);
        name = (TextView) itemView.findViewById(R.id.playlist_name);
        description = (TextView) itemView.findViewById(R.id.playlist_description);
    }

    public void updateUI(Playlist p) {
        int color = Color.parseColor(p.getColor());
        backgroundLayout.setBackgroundColor(color);
        name.setText(p.getName());
        description.setText(p.getDescription());
    }
}
