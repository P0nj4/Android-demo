package com.example.germanpereyra.radio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.germanpereyra.radio.R;
import com.example.germanpereyra.radio.holders.PlaylistViewHolder;
import com.example.germanpereyra.radio.model.Playlist;

import java.util.ArrayList;

/**
 * Created by germanpereyra on 22/Jul/16.
 */
public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private ArrayList<Playlist> data;

    public PlaylistAdapter(ArrayList<Playlist> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        Playlist p = data.get(position);
        holder.updateUI(p);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_playlist, parent, false);
        return new PlaylistViewHolder(card);
    }
}
