package com.example.liudan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView grid;
    private GridRecyclerAdapter adapter;
    private List<Integer> goodsList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (RecyclerView) findViewById(R.id.grid);
        GridLayoutManager gridManager = new GridLayoutManager(this,3);// 创建一个线性布局管理器
        grid.setLayoutManager(gridManager);// 设置布局管理器

        goodsList.add(R.mipmap.weixin);
        goodsList.add(R.mipmap.weixin);
        goodsList.add(R.mipmap.weixin);
        adapter = new GridRecyclerAdapter(this, goodsList);
        grid.setAdapter(adapter);

    }
}
