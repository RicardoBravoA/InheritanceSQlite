package com.rba.databasehandler.storage.database;

/**
 * Created by Ricardo Bravo on 5/07/16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.rba.databasehandler.storage.database.util.ConstantDB;

/**
 * Created by Ricardo Bravo on 30/06/16.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private static DatabaseHandler mInstance = null;

    public DatabaseHandler(Context context){
        super(context, ConstantDB.DATABASE_NAME, null, ConstantDB.DATABASE_VERSION);
    }


    public static DatabaseHandler getInstance(Context ctx){
        if (mInstance == null) {
            mInstance = new DatabaseHandler(ctx.getApplicationContext());
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DEMO_TABLE= "CREATE TABLE " + ConstantDB.TABLE_DEMO + "("
                + ConstantDB.KEY_ID + " TEXT, "+ ConstantDB.KEY_VALUE+" TEXT)";
        db.execSQL(CREATE_DEMO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}