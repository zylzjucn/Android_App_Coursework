package com.student.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView studentID;
    private TextView major;
    private Button back;
    private Button delete;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        back = (Button) findViewById(R.id.btnback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });

        name = (TextView)findViewById(R.id.namedetail);
        studentID = (TextView)findViewById((R.id.IDdetail));
        major = (TextView)findViewById(R.id.majordetail);
        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        final String nameval = intent.getStringExtra("Student Name");
        final String studentIDval = intent.getStringExtra("Student ID");
        final String majorval = intent.getStringExtra("Major");
        name.setText(nameval);
        studentID.setText(studentIDval);
        major.setText(majorval);

        delete = (Button) findViewById(R.id.btndelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHelper deleteDialog = new DialogHelper(nameval, studentIDval, majorval);
                deleteDialog.show(getSupportFragmentManager(), "Delete dialog");

            }
        });





    }
}
