package com.techschool.fadiabusaleh.dailydoes;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private static final String TAG = "TasksAdapter";


    private ArrayList<Task> data;
    private Context mContext;

    Button remove;

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
        return data.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int aI, View aView, ViewGroup aViewGroup) {
        View listItem = aView;
        DatabaseReference db;
        db = FirebaseDatabase.getInstance().getReference();

        if (listItem == null)
            listItem = LayoutInflater.from( mContext ).inflate( R.layout.row_item, aViewGroup, false );

          final int pos = aI;

        TextView catg = (TextView) listItem.findViewById( R.id.tk_catg );
        TextView titl = (TextView) listItem.findViewById( R.id.tk_title );
        CheckBox chk = (CheckBox) listItem.findViewById( R.id.tk_done );
        TextView date = (TextView) listItem.findViewById( R.id.tk_date );
        final Task tk = data.get( aI );
        titl.setText( tk.getSbjct() );
        if (tk.stats == 0) {
            chk.setChecked( false );
        } else chk.setChecked( true );
        catg.setText( tk.getCategory() );
        remove = (Button) listItem.findViewById( R.id.tk_delete );
        remove.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbb;
                dbb = FirebaseDatabase.getInstance().getReference();
                FireBaseHelper helper = new FireBaseHelper( dbb );
                helper.DeleteD( pos );
                notifyDataSetChanged();
            }
        } );
        return listItem;

    }
}