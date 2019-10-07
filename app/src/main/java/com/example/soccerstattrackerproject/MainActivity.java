package com.example.soccerstattrackerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button addButton, viewDataButton, updateButton, deleteButton;
    TextView out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //I edited this
        myDB = new DatabaseHelper(this);

        addData();
        viewData();
        updateData();
        deleteData();
    }

    public void addData(){
        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // add the data using the information gathered in the text views;
                        boolean inserted = myDB.insertData("Tommy","1","1","2","3");
                        if (inserted){
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewData(){
        viewDataButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDB.getAllData();
                        String ID = "";
                        String Name = "";
                        String Pos = "";
                        String Min = "";
                        String Goals = "";
                        String Assists = "";
                        if (res.getCount()==0){
                            showMessage("Error", "No Data Found");
                            return;
                        }
                        else{
                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()){
                                //buffer.append("ID :"+res.getString(0)+"\n");
                                //buffer.append("Name :"+res.getString(1)+"\n");
                                //buffer.append("Pos :"+res.getString(2)+"\n");
                                //buffer.append("Min :"+res.getString(3)+"\n\n");
                                // the data is stored in their corresponding Strings.
                                // note only the last value is stored so it needs to be transfer to a arraylist and sorted.
                                ID = res.getString(0);
                                Name = res.getString(1);
                                Pos = res.getString(2);
                                Min = res.getString(3);
                                Goals = res.getString(4);
                                Assists = res.getString(5);
                            }
                            // the data is printed in a Text View but can be passed to a different view to and displayed properly there.
                            out.setText(  ID + "   " + Name + "  " + Pos + "   " + Min + "   " + Goals + "   " + Assists);
                            //showMessage("Data",buffer.toString());
                        }
                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void updateData(){
        updateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // changes the data in at said id to the new data
                        boolean updated = myDB.updateData("","","","","","");
                        if (updated){
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Data NOT Updated", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

    public void deleteData(){
        deleteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // deletes the data at said id location
                        Integer rowsDeleted = myDB.deleteData("");
                        if (rowsDeleted > 0){
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Data NOT Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}