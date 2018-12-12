package com.techschool.fadiabusaleh.dailydoes;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private static final String TAG = "TasksAdapter";


    private ArrayList<Task> data;
    private Context mContext;


    public TaskAdapter(Context aContex, ArrayList<Task> aArrayListTasks) {
        mContext = aContex;
        data = aArrayListTasks;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int aI, View aView, ViewGroup aViewGroup) {
        View listItem = aView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.row_item, aViewGroup, false);


        TextView catg = (TextView) listItem.findViewById(R.id.tk_catg);
        TextView titl = (TextView) listItem.findViewById(R.id.tk_title);
        CheckBox chk = (CheckBox) listItem.findViewById(R.id.tk_done);
        TextView date = (TextView) listItem.findViewById(R.id.tk_date);
        Task tk = data.get(aI);

        titl.setText(tk.getSbjct());
        if (tk.stats == 0) {
            chk.setChecked(false);
        } else chk.setChecked(true);
        catg.setText(tk.getCategory());



        return listItem;

    }

}
