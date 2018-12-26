
package com.techschool.fadiabusaleh.dailydoes;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class FireBaseHelper {

    DatabaseReference db;
    Boolean saved = null;
    ArrayList<Task> taskArrayList = new ArrayList<Task>();
    static ArrayList<String> keyList = new ArrayList();


    public FireBaseHelper(DatabaseReference db) {
        this.db = db;
    }


    //WRITE
    public Boolean save(Task task) {
        if (task == null) {
            saved = false;
        } else {
            try {
                String st = db.child( "Tasks" ).push().getKey();
                db.child( "Tasks" ).child( st ).setValue( task );
                //keyList.add( st );
                saved = true;


            } catch (DatabaseException e) {
                e.printStackTrace();
                saved = false;
            }
        }

        return saved;
    }

    //READ
    public ArrayList<Task> retrieve() {

        db.addChildEventListener( new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                fetchData( dataSnapshot );




            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData( dataSnapshot );
                MainActivity.adapter.notifyDataSetChanged();


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                String s = dataSnapshot.getValue().toString();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );

        return taskArrayList;
    }

    public void DeleteD(int position) {

        String st = keyList.get( position );
        db.child( "Tasks" ).child( st ).removeValue();
        if(keyList.get( position ).equals( st )){
            keyList.remove( position);
        }

    }

    private void fetchData(DataSnapshot dataSnapshot) {
        taskArrayList.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Task tk = ds.getValue( Task.class );
            keyList.add( ds.getKey() );
            taskArrayList.add( tk );
        }
    }

}