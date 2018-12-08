package com.techschool.fadiabusaleh.dailydoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;

public class AddTask extends Activity {
    Spinner catg;
    EditText title;
    EditText txt;
    CheckBox done;
    RatingBar important;
    Button save;
    Task tk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        catg = (Spinner) findViewById(R.id.category);
        title = (EditText) findViewById(R.id.title);
        txt = (EditText) findViewById(R.id.text);
        done = (CheckBox) findViewById(R.id.done);
        important = (RatingBar) findViewById(R.id.important);
        save = (Button) findViewById(R.id.saveTask);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        catg.setAdapter(adapter);
         final Intent intent;
        intent = new Intent(this,MainActivity.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tk = new Task();
                tk.setCategory((String) catg.getSelectedItem());
                tk.setSbjct(title.getText().toString());
                tk.setTxt(txt.getText().toString());
                tk.setImportant((int) important.getNumStars());
                FirebaseDatabase.getInstance().getReference().child("Tasks1").setValue(tk);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();  //Kill the activity from which you will go to next activity

            }
        });

    }


}
