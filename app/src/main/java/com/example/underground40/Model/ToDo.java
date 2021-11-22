package com.example.underground40.Model;

import java.io.Serializable;
import java.util.Calendar;

public class ToDo extends ToDoChatLayout implements Serializable {
    private  long id;
    private String name;
    private Calendar dueDate;





    public ToDo(final String name){
        this(name, null);
    }

    public ToDo( final String name, final Calendar dueDate) {


        this.name = name;
        this.dueDate = dueDate;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public  long getId(){
        return  id;
    }

    public void setId(final long id){
        this.id=id;
    }
}
