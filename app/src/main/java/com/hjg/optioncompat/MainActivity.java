package com.hjg.optioncompat;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TEXT = "text";
    public static final String IMAGE = "image";
    private TextView text;
    private ImageView image;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        image = findViewById(R.id.image);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                        new Pair(text, MainActivity.TEXT),
                        new Pair(image, MainActivity.IMAGE)
                );
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });

        recyclerview = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);//添加布局样式
        recyclerview.setItemAnimator(new DefaultItemAnimator());//添加数据和删除数据的动画效果
        List list = new ArrayList();
        list.add("1243123123213");
        list.add("1243123123213");
        list.add("1243123123213");
        list.add("1243123123213");
        list.add("1243123123213");
        list.add("1243123123213");
        list.add("1243123123213");
        list.add("1243123123213");
        MyAdapter adapter = new MyAdapter(list, MainActivity.this);
        recyclerview.setAdapter(adapter);
    }
}
