package com.example.germanpereyra.interactivestory.ui;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.germanpereyra.interactivestory.R;
import com.example.germanpereyra.interactivestory.model.Page;
import com.example.germanpereyra.interactivestory.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();
    private Story story = new Story();
    private String username;
    private TextView storyTextView;
    private ImageView storyImageView;
    private Button storyButtonChoice1;
    private Button storyButtonChoice2;
    private Stack<Integer> pageStack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyButtonChoice1 = (Button) findViewById(R.id.choiceFirstButton);
        storyButtonChoice2 = (Button) findViewById(R.id.choiceTwoButton);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        storyImageView = (ImageView) findViewById(R.id.storyImageView);

        Intent intent = this.getIntent();
        this.username = intent.getStringExtra(getString(R.string.key_name));
        loadPage(0);
    }

    private void loadPage(int pageId) {
        final Page page = this.story.getPage(pageId);
        pageStack.push(pageId);
        this.storyImageView.setImageDrawable(ContextCompat.getDrawable(this, page.getImageId()));

        String storyText = String.format(getString(page.getTextId()), this.username);
        this.storyTextView.setText(storyText);
        if (page.getFinalPage()) {
            this.storyButtonChoice1.setVisibility(View.INVISIBLE);
            this.storyButtonChoice2.setText(R.string.play_again);
            this.storyButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(0);
                }
            });
        } else {
            loadButtons(page);
        }
    }

    private void loadButtons(final Page page) {

        this.storyButtonChoice1.setText(getString(page.getChoice1().getTextId()));
        this.storyButtonChoice1.setVisibility(View.VISIBLE);
        this.storyButtonChoice2.setText(getString(page.getChoice2().getTextId()));

        this.storyButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextStep = page.getChoice1().getNextPage();
                loadPage(nextStep);
            }
        });

        this.storyButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextStep = page.getChoice2().getNextPage();
                loadPage(nextStep);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()) {
            super.onBackPressed();
        } else {
            loadPage(pageStack.pop());
        }

    }
}
