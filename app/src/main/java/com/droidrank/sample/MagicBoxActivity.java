package com.droidrank.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import data.CellModel;
import data.data_repo.DataRepo;

public class MagicBoxActivity extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_box);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_magic_box);
        int numberOfColumns_or_rows = getIntent().getExtras().getInt(Constants.NUM_OF_ROWS_AND_COLUMNS, 0);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns_or_rows));

        ArrayList<ArrayList<CellModel>> data = new DataRepo().getArrayOfData(numberOfColumns_or_rows);
        adapter = new MyRecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
