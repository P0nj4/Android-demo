package com.example.germanpereyra.flaborfit;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView exerciseTitleView = (TextView)findViewById(R.id.excerciseTitle);
        ImageView exerciseImage = (ImageView)findViewById(R.id.excerciseImage);
        LinearLayout mainBG = (LinearLayout)findViewById(R.id.mainBG);

        String exerciseText = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);
        System.out.println(exerciseText);

        if (exerciseText.equalsIgnoreCase(MainActivity.EXERCISE_WEIGHT)) {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#2ca5f5"));
        } else if (exerciseText.equalsIgnoreCase(MainActivity.EXERCISE_YOGA)) {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#916bcd"));
        } else if (exerciseText.equalsIgnoreCase(MainActivity.EXERCISE_CARDIO)) {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#52ad56"));
        }
    }
}
