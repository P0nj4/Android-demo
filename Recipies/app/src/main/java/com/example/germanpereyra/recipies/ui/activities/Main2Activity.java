package com.example.germanpereyra.recipies.ui.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.germanpereyra.recipies.R;
import com.example.germanpereyra.recipies.manager.DataManager;
import com.example.germanpereyra.recipies.ui.adapters.HorizontalRecipeListAdapter;
import com.example.germanpereyra.recipies.ui.fragments.HorizontalRecipiesListFragment;
import com.example.germanpereyra.recipies.ui.fragments.VerticalRecipesListFragment;

import java.util.concurrent.atomic.AtomicInteger;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerTest);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter adapter = new myAdapter(this);
        recyclerView.setAdapter(adapter);
    }


}

class myAdapter extends RecyclerView.Adapter<myAdapter.HolderView> {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    private Main2Activity activity;

    public myAdapter(Main2Activity activity) {
        this.activity = activity;
    }

    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item, parent, false);
        return new HolderView(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(HolderView holder, int position) {
        int boardId = generateViewId();
        // switch the id of the board to be unique
        View board = holder.itemView.findViewById(R.id.framelayouttest);
        board.setId(boardId);

        if (position == 0) {
            setupNewestRecipesContent(boardId);
            holder.itemView.setBackgroundColor(Color.parseColor("#F1A730"));
        } else {

            //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) board.getLayoutParams();
            //params.height = 330;
            //board.setLayoutParams(params);

            setupTrendingRecipesContent(boardId);
            holder.itemView.setBackgroundColor(Color.parseColor("#51D05D"));

        }
    }


    private void setupNewestRecipesContent(int id) {
        HorizontalRecipiesListFragment horizontalRecipiesListFragment = HorizontalRecipiesListFragment.newInstance(DataManager.NEWEST);
        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, horizontalRecipiesListFragment);
        fragmentTransaction.commit();
    }

    private void setupTrendingRecipesContent(int id) {
        VerticalRecipesListFragment verticalRecipesListFragment = VerticalRecipesListFragment.newInstance(DataManager.TRENDING);
        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, verticalRecipesListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class HolderView extends RecyclerView.ViewHolder {

        public HolderView(View itemView, Context context) {
            super(itemView);
        }
    }
}