package com.example.underground40.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.underground40.Model.ToDo;
import com.example.underground40.Model.ToDoChatLayout;
import com.example.underground40.R;

import java.util.Calendar;
import java.util.List;


public class ToDoOverviewListAdapter extends ArrayAdapter<ToDoChatLayout> {


    public ToDoOverviewListAdapter(final Context context, final List<ToDoChatLayout> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(final int position, final View converterView, final ViewGroup parent) {
        ToDoChatLayout currentToDo = getItem(position);

        View view = converterView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.todo_overview_listitem, parent, false);
        }

        ((TextView) view.findViewById(R.id.name)).setText(currentToDo.getName());
        System.out.println("TEst "+currentToDo.getName());
        TextView dueData = (TextView) view.findViewById(R.id.dueDate);

        if (currentToDo.getDueDate() == null) {
            dueData.setVisibility((View.GONE));
        }else{
            dueData.setVisibility(View.VISIBLE);
            dueData.setText(String.valueOf(currentToDo.getDueDate().get(Calendar.YEAR)));


        }

        return view;

    }


}