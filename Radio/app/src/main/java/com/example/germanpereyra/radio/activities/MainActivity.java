package com.example.germanpereyra.radio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.germanpereyra.radio.fragments.DetailFragment;
import com.example.germanpereyra.radio.fragments.MainFragment;
import com.example.germanpereyra.radio.R;
import com.example.germanpereyra.radio.model.Station;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.mainActivity = this;

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance("a", "b");
            fm.beginTransaction().add(R.id.container_main, mainFragment).commit();
        }
    }

    public void loadDetailScreen(Station selectedStation) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, new DetailFragment())
                .addToBackStack(null)
                .commit();
    }
}
