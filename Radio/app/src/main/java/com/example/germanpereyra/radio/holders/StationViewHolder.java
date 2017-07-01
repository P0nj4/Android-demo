package com.example.germanpereyra.radio.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.germanpereyra.radio.R;
import com.example.germanpereyra.radio.model.Station;

/**
 * Created by germanpereyra on 21/Jul/16.
 */
public class StationViewHolder extends RecyclerView.ViewHolder {

    private ImageView mainImage;
    private TextView titleTextView;

    public StationViewHolder(View itemView) {
        super(itemView);

        mainImage = (ImageView) itemView.findViewById(R.id.main_image);
        titleTextView = (TextView) itemView.findViewById(R.id.main_text);
    }

    public void updateUI(Station station) {
        String uri = station.getImgUri();
        int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);

        titleTextView.setText(station.getStationTitle());

    }
}
