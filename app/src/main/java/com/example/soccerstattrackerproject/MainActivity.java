package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView playerListView;
    private ArrayAdapter adapter;
    private String[] playerNames;
    private int MUB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerNames = new String[]{"A", "B"};
        playerListView = findViewById(R.id.playerListView);
//        adapter = new ArrayAdapter<String>(this, R.id.playerListView, playerNames);
    }
}
