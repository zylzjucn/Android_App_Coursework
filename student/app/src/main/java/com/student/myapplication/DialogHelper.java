package com.student.myapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class DialogHelper extends DialogFragment{

    private String name;
    private String ID;
    private String major;

    @SuppressLint("ValidFragment")
    public DialogHelper(String name, String ID, String major) {
        this.name = name;
        this.ID = ID;
        this.major = major;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Notice")
                .setMessage("Delete this item?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                        Context context = getActivity().getApplicationContext();
                        if (databaseHelper.delete(name, ID, major)) {
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);

                            String toastText = "Delete Successful";
                            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Delete failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();

    }


}
