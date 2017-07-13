package com.example.germanpereyra.recipies.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.germanpereyra.recipies.model.Recipe;
import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.ui.sharedInterfaces.OnRecipeSelectedListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by germanpereyra on 7/11/17.
 */

public class HorizontalRecipeListAdapter extends RecyclerView.Adapter<HorizontalRecipeListAdapter.HorizontalRecipeListViewHolder> {

    private List<Recipe> recipes;
    private OnRecipeSelectedListener mListener;

    public HorizontalRecipeListAdapter(List<Recipe> recipes, OnRecipeSelectedListener listener) {
        this.recipes = recipes;
        this.mListener = listener;
    }

    @Override
    public HorizontalRecipeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_small, parent, false);
        return new HorizontalRecipeListViewHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(HorizontalRecipeListViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class HorizontalRecipeListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView recipeName;
        private ImageView recipeImage;
        private Context mContext;

        public HorizontalRecipeListViewHolder(View itemView, Context context) {
            super(itemView);
            mContext = context;
            itemView.setOnClickListener(this);
            recipeName = (TextView) itemView.findViewById(R.id.recipe_list_item_small_name);
            recipeImage = (ImageView) itemView.findViewById(R.id.recipe_list_item_small_image);
            recipeImage.setClipToOutline(true);
        }

        public void bind(Recipe recipe) {
            recipeName.setText(recipe.getName());
            Picasso.with(mContext)
                    .load(recipe.getImgURL())
                    .resize(122, 122)
                    .centerCrop()
                    .into(recipeImage);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            int position = getAdapterPosition();
            Recipe recipe = recipes.get(position);
            mListener.openRecipeDetail(recipe);
        }
    }

}
