package com.student.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment2 extends Fragment {
    private static final String TAG = "Fragment2";

    DatabaseHelper mDatabaseHelper;
    private Button btnEnter, btnCancel;
    private EditText name, ID, major;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        Log.d(TAG, "onCreatedView: started.");

        name = (EditText)view.findViewById(R.id.name);
        ID = (EditText)view.findViewById(R.id.studentid);
        major = (EditText)view.findViewById(R.id.major);
        btnEnter = (Button)view.findViewById(R.id.enter);
        btnCancel = (Button)view.findViewById(R.id.cancel);
        mDatabaseHelper = new DatabaseHelper(getActivity());

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry1 = name.getText().toString();
                String newEntry2 = ID.getText().toString();
                String newEntry3 = major.getText().toString();
                if(name.length() > 0 && ID.length() > 0 && major.length() > 0) {
                    AddData(newEntry1, newEntry2, newEntry3);
                    name.setText("");
                    ID.setText("");
                    major.setText("");
                } else {
                    Toast.makeText(getActivity(), "Input Can Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Back to Home Page", Toast.LENGTH_SHORT).show();

                ((SecondActivity)getActivity()).setViewPager(0);
            }
        });


        return view;
    }

    public void AddData(String newEntry1, String newEntry2, String newEntry3) {
        boolean insertData = mDatabaseHelper.addData(newEntry1, newEntry2, newEntry3);
        if (insertData) {
            Toast.makeText(getActivity(), "Data Successfully Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}