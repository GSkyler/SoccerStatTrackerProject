package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView playerListView;
    private ArrayAdapter adapter;
    private TextView IDK;

    private Team team;
    DatabaseHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDb = new DatabaseHelper(this);
        IDK = findViewById(R.id.textView);
        team = new Team();
        playerListView = findViewById(R.id.playerListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, team.getPlayerNames());
        playerListView.setAdapter(adapter);

    }

    public void ADDtoDb(View View){
        boolean Good = MyDb.insertData("Skyler", "7.5", "Goal", "1", "1");
        if(Good == true){
            IDK.setText("TRUE");
        }
        else{
            IDK.setText("NOT TRUE");
        }

    }
}


