package com.techschool.fadiabusaleh.dailydoes;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;

public class ListTasks extends ArrayList<Task>{
    public ListTasks(int initialCapacity) {
        super(initialCapacity);
    }
    public  ListTasks(){

    }
    public ListTasks(@NonNull Collection<? extends Task> c) {
        super(c);
    }



}
