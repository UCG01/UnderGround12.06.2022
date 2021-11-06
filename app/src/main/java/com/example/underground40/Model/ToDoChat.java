package com.example.underground40.Model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ToDoChat implements Serializable {
    private  long id;
    private String name;
    private Calendar dueDate;
    private Date time;
    private String msg;





    public ToDoChat(final String name){
        this(name, (Date) null,(String));
    }

    public ToDoChat( final String name, final Calendar dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public ToDoChat(String name, Date time,String text) {
        this.name = text;
        this.time =time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMSG() {
        return msg;
    }

    public void setMSG(String name) {
        this.msg = msg;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public  long getId(){
        return  id;
    }

    public void setId(final long id){
        this.id=id;
    }
}
