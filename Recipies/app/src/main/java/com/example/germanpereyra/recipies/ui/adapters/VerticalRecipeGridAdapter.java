package com.example.germanpereyra.recipies.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by germanpereyra on 7/13/17.
 */

public class VerticalRecipeGridAdapter extends BaseAdapter {

    //DATA
    private List<Recipe> recipes;
    private Context context;

    //UI
    private ImageView imageView;
    private TextView textView;

    public VerticalRecipeGridAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //LayoutInflater layoutInflater = LayoutInflater.from(context);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.recipe_grid_item, parent, false);
        }

        this.imageView = (ImageView) convertView.findViewById(R.id.recipe_grid_item_image);
        this.textView = (TextView) convertView.findViewById(R.id.recipe_grid_item_name);

        Recipe recipe = this.recipes.get(position);
        textView.setText(recipe.getName());
        Picasso.with(context)
                .load(recipe.getImgURL())
                .resize(200, 200)
                .centerCrop()
                .into(imageView);

        return convertView;
    }
}
