package com.example.germanpereyra.radio.fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.germanpereyra.radio.R;
import com.example.germanpereyra.radio.adapters.StationAdapter;
import com.example.germanpereyra.radio.service.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_STATION_TYPE = "station_type";

    private int stationType;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType the radio stations type.
     * @return A new instance of fragment StationsFragment.
     */

    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stations, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));

        StationAdapter stationAdapter;

        if (stationType == STATION_TYPE_FEATURED) {
            stationAdapter = new StationAdapter(DataService.getInstance().getFeacturedStations());
        } else if (stationType == STATION_TYPE_RECENT) {
            stationAdapter = new StationAdapter(DataService.getInstance().getRecentStations());
        } else {
            stationAdapter = new StationAdapter(DataService.getInstance().getPartyStations());
        }
        recyclerView.setAdapter(stationAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        return v;
    }
}

class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {

    private final int spaceBetween;

    public HorizontalSpaceItemDecorator(int spaceBetween) {
        this.spaceBetween = spaceBetween;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = spaceBetween;
    }
}
