package com.example.germanpereyra.radio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.germanpereyra.radio.R;
import com.example.germanpereyra.radio.activities.MainActivity;
import com.example.germanpereyra.radio.holders.StationViewHolder;
import com.example.germanpereyra.radio.model.Station;

import java.util.ArrayList;

/**
 * Created by germanpereyra on 21/Jul/16.
 */
public class StationAdapter extends RecyclerView.Adapter<StationViewHolder> {

    private ArrayList<Station> stations;

    public StationAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StationViewHolder stationViewHolder, int i) {
        final Station station = stations.get(i);
        stationViewHolder.updateUI(station);

        stationViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(station.getStationTitle());
                MainActivity.getMainActivity().loadDetailScreen(station);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View stationCard = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_station, viewGroup, false);
        return new StationViewHolder(stationCard);
    }
}
