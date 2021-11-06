package com.example.underground40.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.underground40.Model.ToDo;
import com.example.underground40.R;


public class TodoDeatilActivity extends AppCompatActivity {

    public static final String TODO_KEY = "TODO";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_deatil);

        ToDo toDo = (ToDo) getIntent().getSerializableExtra(TODO_KEY);

        Log.e("todo id", String.valueOf(toDo.getId()));
        Log.e("todo name",toDo.getName());
    }
}