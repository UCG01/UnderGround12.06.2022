package com.example.underground40.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import com.example.underground40.Model.ToDoChat;
import com.example.underground40.R;

import java.util.Calendar;
import java.util.List;


public class ChatListAdapter extends ArrayAdapter<ToDoChat> {


    public ChatListAdapter(final Context context, final List<ToDoChat> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(final int position, final View converterView, final ViewGroup parent) {
        ToDoChat currentToDo = getItem(position);
System.out.println("TIME143: "+currentToDo.getTime());
        View view = converterView;

        if (view == null) {

            if (currentToDo.getId() % 2 == 0) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.chat_listitem_other, parent, false);
            } else {
                view = LayoutInflater.from(getContext()).inflate(R.layout.chat_listitem, parent, false);

            }
        }
        ((TextView) view.findViewById(R.id.name)).setText(currentToDo.getName()+"\n"+currentToDo.getMSG());
        System.out.println("TEst5 " + currentToDo.getMSG()+" "+currentToDo.getTime());

        String buffer = String.valueOf(currentToDo.getTime());
        String[] buffersplit = buffer.split(" ");
        



        return view;
    }}