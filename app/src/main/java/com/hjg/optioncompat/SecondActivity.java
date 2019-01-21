package com.hjg.optioncompat;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView text;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text = findViewById(R.id.text);
        image = findViewById(R.id.image);
        ViewCompat.setTransitionName(text, MainActivity.TEXT);
        ViewCompat.setTransitionName(image, MainActivity.IMAGE);

        Toast.makeText(this, "zheshi" + BuildConfig.LOG_DEBUG, Toast.LENGTH_SHORT).show();

    }
}
