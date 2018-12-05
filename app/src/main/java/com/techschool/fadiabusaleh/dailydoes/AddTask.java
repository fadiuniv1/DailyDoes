package com.techschool.fadiabusaleh.dailydoes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class AddTask extends Activity {
    Spinner catg;
    EditText title;
    EditText txt;
    CheckBox done;
    RatingBar important;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        catg = (Spinner)findViewById(R.id.category);
        title = (EditText)findViewById(R.id.title);
        txt = (EditText)findViewById(R.id.text);
        done = (CheckBox)findViewById(R.id.done);
        important = (RatingBar)findViewById(R.id.important);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        catg.setAdapter(adapter);
    }
}
