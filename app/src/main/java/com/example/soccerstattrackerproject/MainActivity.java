package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView playerListView;
    private ArrayAdapter adapter;
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team = new Team();
        playerListView = findViewById(R.id.playerListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, team.getPlayerNames());
        playerListView.setAdapter(adapter);
        playerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int x = 1;
                Intent intent = new Intent(MainActivity.this, player_info.class);
                intent.putExtra("pData", team.getPlayerData(team.getPlayerNames().get(i)));
                startActivity(intent);
            }

        });

    }

    /*switch between xml files
    Intent intent = new Intent(GameActivity.this, MainActivity.class);;
        if(scene == 1)
        {
            intent = new Intent(GameActivity.this, LossActivity2.class);
        }
        else if(scene == 2)
        {
            intent = new Intent(GameActivity.this, LossActivity.class);
        }

        startActivity(intent);
    *.
     */

}
