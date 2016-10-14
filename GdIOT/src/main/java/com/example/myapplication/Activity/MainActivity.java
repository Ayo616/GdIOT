package com.example.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.Adapter.RecycleViewAdapter;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecycleViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        mrecyclerView = (RecyclerView) findViewById(R.id.id_for_recycleview);
        mAdapter = new RecycleViewAdapter();
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setAdapter(mAdapter);
    }


}
