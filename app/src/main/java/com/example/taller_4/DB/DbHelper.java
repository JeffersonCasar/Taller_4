package com.example.taller_4.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public String  DATABASE_TABLE="alumnos";
    private static final String DATABASE_NAME = "lista";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                                                            "nombre TEXT NOT NULL,"+
                                                                            "apellido TEXT,"+
                                                                            "codigo INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE"+
                DATABASE_TABLE);
                onCreate(sqLiteDatabase);
    }


}
