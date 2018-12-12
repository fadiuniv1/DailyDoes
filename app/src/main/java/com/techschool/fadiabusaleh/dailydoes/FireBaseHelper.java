
package com.techschool.fadiabusaleh.dailydoes;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FireBaseHelper {

    DatabaseReference db;
    Boolean saved = null;
    ArrayList<Task> taskArrayList = new ArrayList<>();

    public FireBaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //WRITE
    public Boolean save(Task task) {
        if (task == null) {
            saved = false;
        } else {
            try {
                db.child("Tasks").push().setValue(task);
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
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return taskArrayList;
    }

    private void fetchData(DataSnapshot dataSnapshot) {
        taskArrayList.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Task name = ds.getValue(Task.class);
            taskArrayList.add(name);
        }
    }
}