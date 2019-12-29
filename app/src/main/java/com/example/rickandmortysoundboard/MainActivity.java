package com.example.rickandmortysoundboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import models.ButtonModel;

import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ButtonModel> buttons = new ArrayList<>();
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.stop(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stop(this);
    }

    private void initButtons() {
        buttons.add(new ButtonModel(getString(R.string.lick_my_balls), "lick_my_balls.mp3"));
        buttons.add(new ButtonModel(getString(R.string.wubba_lubba_dub_dub), "woo_vu_luvub_dub_dub.wav"));
        buttons.add(new ButtonModel(getString(R.string.get_schwifty), "get_schwifty_in_here.wav"));
        buttons.add(new ButtonModel(getString(R.string.mr_poopybutthole), "mr_poopybutthole.mp3"));
        buttons.add(new ButtonModel(getString(R.string.riggity_wrecked), "riggity_wrecked.wav"));
        buttons.add(new ButtonModel(getString(R.string.tiny_rick), "tiny_rick.wav"));
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(buttons, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
