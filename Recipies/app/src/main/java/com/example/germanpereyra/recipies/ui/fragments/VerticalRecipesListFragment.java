package com.example.germanpereyra.recipies.ui.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.manager.DataManager;
import com.example.germanpereyra.recipies.ui.adapters.VerticalRecipeGridAdapter;

public class VerticalRecipesListFragment extends Fragment {

    private static final String ARG_KIND_OF_RECIPIES = "ARG_KIND_OF_RECIPIES";

    //DATA
    private String mKindOfRecipies;

    //UI
    private GridView gridView;
    private TextView mTitle;

    public VerticalRecipesListFragment() {
        // Required empty public constructor
    }

    public static VerticalRecipesListFragment newInstance(String kindOfRecipies) {
        VerticalRecipesListFragment fragment = new VerticalRecipesListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KIND_OF_RECIPIES, kindOfRecipies);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mKindOfRecipies = getArguments().getString(ARG_KIND_OF_RECIPIES, DataManager.ALLRECIPES);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vertical_recipes_list, container, false);

        gridView = (GridView) view.findViewById(R.id.fragment_vertical_recipies_grid);
        mTitle = (TextView) view.findViewById(R.id.fragment_vertical_recipies_list_title);

        VerticalRecipeGridAdapter adapter = new VerticalRecipeGridAdapter(this.getActivity(), DataManager.getInstance().getRecipiesByKind(mKindOfRecipies));
        gridView.setAdapter(adapter);

        mTitle.setText(mKindOfRecipies.toUpperCase());
        return view;
    }

}
