package com.rba.databasehandler.storage.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.rba.databasehandler.model.entity.DemoEntity;
import com.rba.databasehandler.storage.database.util.ConstantDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo Bravo on 5/07/16.
 */

public class DemoDatabase extends DatabaseHandler {

    private DatabaseHandler databaseHelper;

    public DemoDatabase(Context context){
        super(context);
        databaseHelper = getInstance(context);
    }

    public void addDemo(DemoEntity demoEntity){
        String sql = "INSERT INTO "+ ConstantDB.TABLE_DEMO +"("+ ConstantDB.KEY_ID+", "+ ConstantDB.KEY_VALUE+") VALUES (?,?)";
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        statement.clearBindings();
        statement.bindString(1, demoEntity.getId());
        statement.bindString(2, demoEntity.getValue());
        statement.execute();
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<DemoEntity> getDemo(){

        List<DemoEntity> demoEntityList = new ArrayList<>();

        String selectQuery = "SELECT "+ ConstantDB.KEY_ID+", "+ ConstantDB.KEY_VALUE+" FROM " + ConstantDB.TABLE_DEMO;

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        try{
            if (cursor.moveToFirst()) {
                do {
                    DemoEntity demoEntity = new DemoEntity();
                    demoEntity.setId(cursor.getString(0));
                    demoEntity.setValue(cursor.getString(1));
                    demoEntityList.add(demoEntity);
                } while (cursor.moveToNext());
            }
        }finally {
            cursor.close();
        }

        return demoEntityList;
    }

    public void deleteDemo(){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String query = "DELETE FROM "+ ConstantDB.TABLE_DEMO;
        db.execSQL(query);
    }


}
