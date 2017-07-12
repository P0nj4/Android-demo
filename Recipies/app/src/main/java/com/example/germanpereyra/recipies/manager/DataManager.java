package com.example.germanpereyra.recipies.manager;

import com.example.germanpereyra.recipies.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by germanpereyra on 7/11/17.
 */

public class DataManager {

    private static final DataManager ourInstance = new DataManager();

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
    }

    private List<Recipe> mRecipes;

    public List<Recipe> getRecipies() {
        if (mRecipes != null)
                return mRecipes;

        ArrayList recipies = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setName("Special Brownies");
        r1.setImgURL("http://herb.co/wp-content/uploads/2015/12/116_lrg-800x390.jpg");
        recipies.add(r1);

        Recipe r2 = new Recipe();
        r2.setName("Canna Oil");
        r2.setImgURL("http://herb.co/wp-content/uploads/2015/12/885_lrg-800x389.jpg");
        recipies.add(r2);

        Recipe r3 = new Recipe();
        r3.setName("Canna Gummies");
        r3.setImgURL("http://herb.co/wp-content/uploads/2016/01/gummies-800x400.jpg");
        recipies.add(r3);

        Recipe r4 = new Recipe();
        r4.setName("Canabis milk");
        r4.setImgURL("http://herb.co/wp-content/uploads/2015/12/68_lrg-800x391.jpg");
        recipies.add(r4);

        mRecipes = recipies;
        return mRecipes;
    }
}
