package com.example.germanpereyra.recipies.ui.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.manager.DataManager;
import com.example.germanpereyra.recipies.model.Recipe;
import com.example.germanpereyra.recipies.ui.adapters.HorizontalRecipeListAdapter;
import com.example.germanpereyra.recipies.ui.sharedInterfaces.OnRecipeSelectedListener;

public class HorizontalRecipiesListFragment extends Fragment implements OnRecipeSelectedListener {

    public static final String ARG_KIND_OF_RECIPIES = "KindOfRecipiesArgument";

    //DATA
    private String mKindOfRecipies;
    private OnRecipeSelectedListener mListener;

    //UI
    private RecyclerView recyclerView;
    private HorizontalRecipeListAdapter adapter;
    private TextView mTitle;

    public HorizontalRecipiesListFragment() {}

    public static HorizontalRecipiesListFragment newInstance(String kindOfRecipies) {
        HorizontalRecipiesListFragment fragment = new HorizontalRecipiesListFragment();
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecipeSelectedListener) {
            mListener = (OnRecipeSelectedListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnRecipeSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_horizontal_recipies_list, container, false);

        mTitle = (TextView) v.findViewById(R.id.fragment_horizontal_recipies_list_title);
        if (mKindOfRecipies != null) {
            mTitle.setText(mKindOfRecipies.toUpperCase());
        }

        recyclerView = (RecyclerView) v.findViewById(R.id.horizontalRecipesListRecicleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new HorizontalRecipeListAdapter(DataManager.getInstance().getRecipiesByKind(mKindOfRecipies), this);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void openRecipeDetail(Recipe recipe) {
        mListener.openRecipeDetail(recipe);
    }
}
