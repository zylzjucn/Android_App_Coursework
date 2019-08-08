package com.student.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    private static final String TAG = "Fragment1";

    private FloatingActionButton addstudent;
    private Button btnNavLists;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        addstudent = (FloatingActionButton) view.findViewById(R.id.addstudent);
        btnNavLists = (Button) view.findViewById(R.id.btnNavLists);
        Log.d(TAG, "onCreatedView: started.");

        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to add student", Toast.LENGTH_SHORT).show();

                ((SecondActivity)getActivity()).setViewPager(1);
            }
        });

        btnNavLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to lists", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
