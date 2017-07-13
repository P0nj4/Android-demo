package com.example.germanpereyra.recipies.ui.activities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.manager.DataManager;
import com.example.germanpereyra.recipies.model.Recipe;
import com.example.germanpereyra.recipies.ui.fragments.HorizontalRecipiesListFragment;
import com.example.germanpereyra.recipies.ui.sharedInterfaces.OnRecipeSelectedListener;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements OnRecipeSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalRecipiesListFragment horizontalRecipiesListFragment = HorizontalRecipiesListFragment.newInstance(DataManager.NEWEST);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.horizontalScrollFragment, horizontalRecipiesListFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void openRecipeDetail(Recipe recipe) {
        Toast.makeText(this, recipe.getName() + " PRESSED", Toast.LENGTH_SHORT).show();
    }
}
