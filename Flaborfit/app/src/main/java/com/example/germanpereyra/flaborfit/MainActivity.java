package com.example.germanpereyra.flaborfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_TITLE =  "extra.item.title";
    public static final String EXERCISE_WEIGHT =  "weight";
    public static final String EXERCISE_YOGA =  "yoga";
    public static final String EXERCISE_CARDIO =  "cardio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout weightBtn = (RelativeLayout)findViewById(R.id.weightBtn);
        RelativeLayout yogaBtn = (RelativeLayout)findViewById(R.id.YogaBtn);
        RelativeLayout cardioBtn = (RelativeLayout)findViewById(R.id.CardioBtn);

        weightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(EXERCISE_WEIGHT);
            }
        });

        cardioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(EXERCISE_CARDIO);
            }
        });

        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(EXERCISE_YOGA);
            }
        });

    }

    void loadDetailActivity(String exercise) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, exercise);
        startActivity(intent);
    }
}
