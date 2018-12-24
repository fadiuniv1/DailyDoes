package com.techschool.fadiabusaleh.dailydoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTask extends Activity {
    Spinner catg;
    EditText title;
    EditText txt;
    CheckBox done;
    RatingBar important;
    Button save;
    Task tk;
    DatabaseReference db;
    FireBaseHelper helper;
    ListView lv;
    TaskAdapter adapterTk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        lv = findViewById(R.id.listview);


        catg = (Spinner) findViewById(R.id.category);
        title = (EditText) findViewById(R.id.title);
        txt = (EditText) findViewById(R.id.text);
        done = (CheckBox) findViewById(R.id.done);
        important = (RatingBar) findViewById(R.id.important);
        save = (Button) findViewById(R.id.saveTask);
//SETUP FIREBASE
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FireBaseHelper(db);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        catg.setAdapter(adapter);
        final Intent intent;
        intent = new Intent(this, MainActivity.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                String cate = catg.getSelectedItem().toString();
                String titl = title.getText().toString();
                String text = txt.getText().toString();
                int dn;
                if (done.isChecked())
                    dn = 1;
                else dn = 0;
                double star = important.getNumStars();


                //SET DATA
                Task s = new Task();
                s.setCategory(cate);
                s.setSbjct(titl);
                s.setTxt(text);
                s.setStats(dn);
                s.setImportant(star);

                //SIMPLE VALIDATION
                if (titl != null && titl.length() > 0) {
                    //THEN SAVE
                    helper.save(s);
                    finish();

                } else {
                    Toast.makeText(AddTask.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }




}
