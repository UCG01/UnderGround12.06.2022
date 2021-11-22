package com.example.underground40.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.underground40.Model.ToDoChat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ChatDatabase extends SQLiteOpenHelper {
    public  static ChatDatabase INSTANCE = null;

    private static final String DB_NAME = "Chat";
    public static  int Version = 22;
    public static  String TABLE_NAME = "test";

    private static final String ID_COLUMN = "ID";
    private static final String NAME_COLUMN = "name";
    private static final String TIME = "dueDate";
    private static final String TEXT = "msg";
    private static final String  SEND = "send";
    private static final String  GET = "get";

    static Date time;

    private ChatDatabase(final Context context) {
        super(context, DB_NAME,null, Version);
    }
    public  static ChatDatabase getInstance(final  Context context){
        if(INSTANCE == null){
            INSTANCE = new ChatDatabase(context);
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = " CREATE TABLE "+ TABLE_NAME + " ( " + ID_COLUMN+ " INTEGER PRIMARY KEY, "+ NAME_COLUMN+ " TEXT NOT NULL, "+ TIME+ " TEXT DEFAULT NULL,"+ TEXT+ " TEXT DEFAULT NULL,"+ SEND+ " boolean DEFAULT null,"+ GET+ " boolean DEFAULT null)";
        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      String dropTable = "DROP TABLE IF EXISTS "+ TABLE_NAME;
      sqLiteDatabase.execSQL(dropTable);

      onCreate(sqLiteDatabase);
    }


    public ToDoChat createToDo(final ToDoChat todo){
        SQLiteDatabase database = this.getWritableDatabase();

Calendar calendar = Calendar.getInstance();
System.out.println("TEDT5: "+calendar);


        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, todo.getName());
        values.put(TIME,todo.getTime() );
        values.put(TEXT,todo.getMSG());
        values.put(SEND,todo.getsend());
        values.put(GET,todo.getget());

    long newID = database.insert(TABLE_NAME, null , values);


    return  readTodo(newID);
    }

    private ToDoChat readTodo(final long id) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query
                (TABLE_NAME, new String[]{ID_COLUMN, NAME_COLUMN, TIME,TEXT,SEND,GET}, ID_COLUMN + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        ToDoChat todo = null;


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            todo = new ToDoChat(cursor.getString(cursor.getColumnIndex(NAME_COLUMN)));

            todo.setId(cursor.getLong(cursor.getColumnIndex(ID_COLUMN)));
            Calendar calendar = null;

        }
todo.setMSG(cursor.getString(cursor.getColumnIndex(TEXT)));
        todo.setTime(cursor.getString(cursor.getColumnIndex(TIME)));
return  todo;

    }

    public List<ToDoChat> readALLToDos(){
        List<ToDoChat> toDos = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        System.out.println("TABLE1: "+TABLE_NAME);
         Cursor cursor = database.rawQuery("SELECT * FROM "+ TABLE_NAME, null);

         if (cursor.moveToFirst()){
             do{
                 ToDoChat toDo = readTodo(cursor.getLong(cursor.getColumnIndex(ID_COLUMN)));
                 if(toDo != null){
                     toDos.add(toDo);

                 }
             }while (cursor.moveToNext());
         }


         return toDos;
    }

    public ToDoChat updateToDo(final ToDoChat toDo){
        SQLiteDatabase database = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        //values.put(NAME_COLUMN, toDo.getDueDate()== null ? null :toDo.getDueDate().getTimeInMillis()/1000  );

        database.update(TABLE_NAME, values, ID_COLUMN + " = ?", new String[]{String.valueOf(toDo.getId())});



        return this.readTodo(toDo.getId());
    }

    public  void deleteToDo(final  ToDoChat toDo){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, ID_COLUMN+ " = ?", new String[]{String.valueOf(toDo.getId())});

    }
    public void deleteALLToDOS(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM "+ TABLE_NAME);


    }

    public void setTableName(String TBname){
        TABLE_NAME = TBname;
    }

}
