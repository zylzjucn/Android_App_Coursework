package com.student.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NameAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] names;
    String[] studentID;
    String[] major;

    public NameAdapter(Context c, String[] i, String[] p, String[] d) {
        names = i;
        studentID = p;
        major = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView studentIDTextView = (TextView) v.findViewById(R.id.studentIDTextView);
        TextView majorTextView = (TextView) v.findViewById(R.id.majorTextView);

        String name = names[i];
        String sID = studentID[i];
        String maj = major[i];

        nameTextView.setText(name);
        studentIDTextView.setText(sID);
        majorTextView.setText(maj);
        return v;
    }
}
