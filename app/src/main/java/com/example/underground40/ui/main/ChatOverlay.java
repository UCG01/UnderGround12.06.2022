package com.example.underground40.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.underground40.DataBase.ChatDatabase;
import com.example.underground40.DataBase.TodoDatabase;
import com.example.underground40.Model.ToDo;
import com.example.underground40.Model.ToDoChat;
import com.example.underground40.Model.ToDoChatLayout;
import com.example.underground40.R;
import com.example.underground40.adapter.ToDoOverviewListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.List;

public class ChatOverlay extends Fragment implements View.OnClickListener {

    private ListView listView;
    private List<ToDo> dataSource;
    private ToDoOverviewListAdapter adapter;
public FloatingActionButton add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


       View view = inflater.inflate(R.layout.chatoverlay_layout, container,false);



        this.listView = view.findViewById(R.id.chats);

        add = (FloatingActionButton) view.findViewById(R.id.addbtn);
        add.setOnClickListener((View.OnClickListener) this);


        this.dataSource = TodoDatabase.getInstance(getContext()).readALLToDos();

        this.adapter= new ToDoOverviewListAdapter(getContext(), dataSource);
        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object element = adapterView.getAdapter().getItem(i);

                if(element instanceof ToDo) {
                    ToDo toDo = (ToDo) element;
                    ChatDatabase.TABLE_NAME= toDo.getName();
                    ChatDatabase.Version = ChatDatabase.Version+1;
                    Intent intent = new Intent(getActivity(), Chat.class);
                    intent.putExtra(Chat.TODO_KEY,toDo);
                    startActivity(intent);

                }
            }
        }));





        return view;

    }




    private void refreshListView() {
        dataSource.clear();
        dataSource.addAll(TodoDatabase.getInstance(getContext()).readALLToDos());

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

        if(view==add) {
            System.out.println("Create123");
            TodoDatabase database = TodoDatabase.getInstance(getContext());

            database.createToDo(new ToDo("Leo"));

            database.createToDo(  new ToDo( "Tammo", Calendar.getInstance()));




            refreshListView();


        }else{
            System.out.println("ERROR123");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object element = adapterView.getAdapter().getItem(i);

        if(element instanceof ToDoChatLayout) {

            System.out.println("OPEN");
            ToDoChatLayout toDo = (ToDoChatLayout) element;
            ChatDatabase.TABLE_NAME= toDo.getName();

            Intent intent = new Intent(getActivity(), Chat.class);
            intent.putExtra(Chat.TODO_KEY, toDo);
            intent.putExtra("name", toDo.getName());

            startActivity(intent);

        }
    }

}

