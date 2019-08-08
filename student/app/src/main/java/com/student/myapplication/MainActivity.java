package com.student.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] names;
    String[] studentID;
    String[] major;
    DatabaseHelper databaseHelper;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        myListView = (ListView)findViewById(R.id.myListview);
//        names = res.getStringArray(R.array.names);
//        studentID = res.getStringArray(R.array.studentID);
//        major = res.getStringArray(R.array.major);
        databaseHelper = new DatabaseHelper(this);
        readData();

        NameAdapter nameAdapter = new NameAdapter(this, names, studentID, major);
        myListView.setAdapter(nameAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("Student Name", names[i]);
                showDetailActivity.putExtra("Student ID", studentID[i]);
                showDetailActivity.putExtra("Major", major[i]);
                index = i;
                startActivity(showDetailActivity);
            }
        });
    }

    private void readData() {
        Cursor cursor = databaseHelper.getData();
        List<String> col1s = new ArrayList<>();
        List<String> col2s = new ArrayList<>();
        List<String> col3s = new ArrayList<>();
        while (cursor.moveToNext()) {
            col1s.add(cursor.getString(0));
            col2s.add(cursor.getString(1));
            col3s.add(cursor.getString(2));
        }
        names = col1s.toArray(new String[col1s.size()]);
        studentID = col2s.toArray(new String[col2s.size()]);
        major = col3s.toArray(new String[col3s.size()]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                Intent gotoCreateActivity = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(gotoCreateActivity);
        }



        return super.onOptionsItemSelected(item);
    }
}
