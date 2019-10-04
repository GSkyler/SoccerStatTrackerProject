package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView playerListView;
    private ArrayAdapter adapter;

    private Team team;
//    private ArrayList<String> playerNames;

    private String[] playerNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        playerNames = new String[]{"A", "B"};
        team = new Team();
        playerListView = findViewById(R.id.playerListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, team.getPlayerNames());
        playerListView.setAdapter(adapter);

        playerNames = new String[]{"A", "B"};
        playerListView = findViewById(R.id.playerListView);
//        adapter = new ArrayAdapter<String>(this, R.id.playerListView, playerNames);

    }
}
