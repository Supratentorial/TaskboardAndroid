package org.monash.taskboardandroid.datalayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Blake on 13/05/2016.
 */
public class DatabaseHelper extends SQLiteAssetHelper {


    public DatabaseHelper(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }
}
