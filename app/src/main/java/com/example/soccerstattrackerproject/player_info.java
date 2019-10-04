package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class player_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        String[] pData = getIntent().getStringArrayExtra("pData");
        TextView tv = findViewById(R.id.nametv);
        String text = "Name: " + pData[0];
        tv.setText(text);
    }
}
