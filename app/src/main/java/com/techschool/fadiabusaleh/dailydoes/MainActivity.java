package com.techschool.fadiabusaleh.dailydoes;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    DatabaseReference Add = database.getReference("Added");
    TaskAdapter taskadapter;
    ListView Tasklist;
    TextView txv2,txv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tasklist = (ListView) findViewById(R.id.tasks);
        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);

         txv = (TextView) findViewById(R.id.textView);
         txv2 = (TextView) findViewById(R.id.textView2);

        Task tk = new Task("Homework", "Programming HW", "write your HW fast", "20/10/2019", 1,0);
        FirebaseDatabase.getInstance().getReference().child("Tasks").setValue(tk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadData();
            }
        });
    }

    private void ReadData() {
        FirebaseDatabase.getInstance().getReference().child("Tasks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Task task = dataSnapshot.getValue(Task.class);
                txv.setText(task.txt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "LoadTask:onCancelled", databaseError.toException());

            }
        });
    }

}