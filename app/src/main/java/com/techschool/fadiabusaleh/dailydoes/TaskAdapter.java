package com.techschool.fadiabusaleh.dailydoes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class TaskAdapter<T> extends BaseAdapter {
    private static final String TAG = "TasksAdapter";


    private ArrayList<Task> data;
    private Context mContext;
    TaskAdapter<Task> taskAdapter =
            new TaskAdapter<Task>(mContext,data);

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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
