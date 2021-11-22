package com.example.underground40.Model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ToDoChat implements Serializable {
    private  long id;
    private String name;
    private Calendar dueDate;
    private String time;
    private String msg;
    private boolean send;
    private boolean get;





    public ToDoChat(final String name){
        this(name, null);
    }


    public ToDoChat( final String name, final String time) {
        this.name = name;
        this.time = time;
    }

    public ToDoChat(String name, String time,String msg,boolean send,boolean get) {
        this.msg = msg;
        this.name = name;
        this.time =time;

        this.send = send;
        this.get = get;

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

    public void setMSG(String msg) {
        this.msg = msg;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean getget() {
        return get;
    }

    public void setget(boolean get) {
        this.get = get;
    }
    public boolean getsend() {
        return send;
    }

    public void setsend(boolean send) {
        this.send = send;
    }

    public  long getId(){
        return  id;
    }

    public void setId(final long id){
        this.id=id;
    }
}
