package com.techschool.fadiabusaleh.dailydoes;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    public View getView(int aI, View aView, ViewGroup aViewGroup){
        View resultView;
        LayoutInflater layoutInflater;

        Log.d( TAG, "getview : " + String.valueOf( aI));

        if (aView == null){
            Log.d( TAG, "getview : " + String.valueOf( aI) + " created !!!");
            layoutInflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
            resultView = layoutInflater.inflate( android.R.layout.simple_list_item_1, null);
        } else {
            resultView = aView;
        }

        return resultView;
    }

}
