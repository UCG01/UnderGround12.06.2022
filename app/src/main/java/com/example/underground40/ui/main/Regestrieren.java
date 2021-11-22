package com.example.underground40.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.underground40.Model.ToDo;
import com.example.underground40.R;

import java.io.FileOutputStream;

public class Regestrieren extends AppCompatActivity {

    public static final String TODO_KEY = "TODO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_layout);

        ToDo toDo = (ToDo) getIntent().getSerializableExtra(TODO_KEY);


    }


    public void saveFile(Context context) {

        String filename = "Zitatdaten.txt";
        String data = "Daten, die in die Datei geschrieben werden sollen.";

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}