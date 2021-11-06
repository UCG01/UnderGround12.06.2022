package com.example.underground40.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.underground40.DataBase.ChatDatabase;
import com.example.underground40.DataBase.TodoDatabase;
import com.example.underground40.Model.ToDo;
import com.example.underground40.Model.ToDoChat;
import com.example.underground40.R;
import com.example.underground40.adapter.ChatListAdapter;
import com.example.underground40.adapter.ToDoOverviewListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.List;

public class Chat  extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    private List<ToDoChat> dataSource;
    private ChatListAdapter adapter;
    public ImageButton add;
    public EditText msg;
    public static final String TODO_KEY = "TODO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);

        Bundle buffer = getIntent().getExtras();
        String name = buffer.getString("name");


        System.out.println("TBNAME1: "+ChatDatabase.TABLE_NAME);





        this.listView = findViewById(R.id.chats);

        add = (ImageButton) findViewById(R.id.send);
        add.setOnClickListener((View.OnClickListener) this);

ChatDatabase.Version=ChatDatabase.Version+1;
        this.dataSource = ChatDatabase.getInstance(this).readALLToDos();

        this.adapter= new ChatListAdapter(this, dataSource);
        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object element = adapterView.getAdapter().getItem(i);

                if(element instanceof ToDo) {



                }
            }
        }));








    }





    private void refreshListView() {
        dataSource.clear();
        dataSource.addAll(ChatDatabase.getInstance(listView.getContext()).readALLToDos());

        adapter.notifyDataSetChanged();
    }


    public void onClick(View view) {

        if(view==add) {
            System.out.println("Create123");

             msg = (EditText) findViewById(R.id.nachricht);
            ChatDatabase database = ChatDatabase.getInstance(view.getContext());

            String text = msg.getEditableText().toString();

            database.createToDo(new ToDoChat("UCG",Calendar.getInstance().getTime(),text));


            refreshListView();
        }else{
            System.out.println("ERROR123");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object element = adapterView.getAdapter().getItem(i);

        if(element instanceof ToDoChat) {


        }
    }

}


