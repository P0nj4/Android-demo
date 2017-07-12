package com.example.germanpereyra.recipies.ui.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.manager.DataManager;
import com.example.germanpereyra.recipies.model.Recipe;
import com.example.germanpereyra.recipies.ui.adapters.HorizontalRecipeListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRecipiesListFragment extends Fragment {

    private RecyclerView recyclerView;
    private HorizontalRecipeListAdapter adapter;

    public HorizontalRecipiesListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_horizontal_recipies_list, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.horizontalRecipesListRecicleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new HorizontalRecipeListAdapter(DataManager.getInstance().getRecipies());
        recyclerView.setAdapter(adapter);
        return v;
    }

}
