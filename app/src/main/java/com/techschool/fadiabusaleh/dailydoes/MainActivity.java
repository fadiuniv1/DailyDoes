package com.techschool.fadiabusaleh.dailydoes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.style.UpdateLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference Add = database.getReference("Added");

    FloatingActionButton fab;
    ListView lv;
   public static TaskAdapter adapter;
    DatabaseReference db;
    FireBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        db = database.getReference();
        helper = new FireBaseHelper(db);

        //ADAPTER
        adapter = new TaskAdapter(this, helper.retrieve());
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        FirebaseDatabase.getInstance().getReference().child("Tasks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                lv.setAdapter(adapter);

                Log.w(TAG, "LoadTask:onCancelled", databaseError.toException());
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddTaskActv();
            }
        });


    }



    private void ShowTask(int pos) {
        Intent intent;
        intent = new Intent(getApplicationContext(), TaskView.class);
        intent.getExtras();
        startActivity(intent);
    }

    private void AddTaskActv() {
        Intent intent = new Intent(this, AddTask.class);
        startActivity(intent);
        lv.setAdapter(adapter);
    }
}