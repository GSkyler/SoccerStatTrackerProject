package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        tv = findViewById(R.id.positiontv);
        text = "Position: " + pData[1];
        tv.setText(text);
        tv = findViewById(R.id.goalstv);
        text = "Goals: " + pData[2];
        tv.setText(text);
        tv = findViewById(R.id.assiststv);
        text = "Assists: " + pData[3];
        tv.setText(text);
        tv = findViewById(R.id.minutestv);
        text = "Minutes: " + pData[4];
        tv.setText(text);
    }

    public void backToPlayerList(View view){
        Intent intent = new Intent(player_info.this, MainActivity.class);
        startActivity(intent);
    }

}
