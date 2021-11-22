package com.example.underground40.Model;

import java.io.Serializable;
import java.util.Calendar;

public class ToDoChatLayout implements Serializable {
    private  long id;
    private String name;
    private Calendar dueDate;
    private String picture;





    public ToDoChatLayout(final String name){
        this(name, null);
    }

    public ToDoChatLayout( final String name, final Calendar dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public ToDoChatLayout() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
