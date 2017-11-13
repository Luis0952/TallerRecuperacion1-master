package com.taller.tallerrecuperacion.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taller.tallerrecuperacion.Utilities.Constants;

/**
 * Created by Luis Eduardo on 13/11/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper{


    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_COMIDA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_COMIDA);

        onCreate(db);
    }
}
