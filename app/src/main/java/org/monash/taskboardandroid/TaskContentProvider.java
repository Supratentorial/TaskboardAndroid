package org.monash.taskboardandroid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import org.monash.taskboardandroid.datalayer.DatabaseContract;
import org.monash.taskboardandroid.datalayer.DatabaseHelper;

/**
 * Created by Blake on 11/05/2016.
 */
public class TaskContentProvider extends ContentProvider {

    private static final String TAG = "Provider";
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int TASKS = 1;
    private static final int TASKS_ID = 2;
    private static final String AUTHORITY = "org.monash.taskboardandroid.provider";
    public static final Uri CONTENT_URI_TASKS = Uri.parse("content://" + AUTHORITY + "/tasks");
    private DatabaseHelper dbHelper;

    static {
        uriMatcher.addURI(AUTHORITY, "tasks", TASKS);
        uriMatcher.addURI(AUTHORITY, "tasks/#", TASKS_ID);
    }

    @Override
    //Return true to indicate that the provider has been loaded correctly
    public boolean onCreate() {
        this.dbHelper = new DatabaseHelper(this.getContext());
        return true;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = uriMatcher.match(uri);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long id = 0;
        switch (uriType) {
            case TASKS:
                id = database.insert(DatabaseContract.TABLE_NAME_TASKS, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse("tasks" + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor;
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        int uriType = uriMatcher.match(uri);
        switch (uriType) {
            case TASKS:
                queryBuilder.setTables(DatabaseContract.TABLE_NAME_TASKS);
                break;
            case TASKS_ID:
                queryBuilder.setTables(DatabaseContract.TABLE_NAME_TASKS);
                queryBuilder.appendWhere("_ID = " + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        cursor = queryBuilder.query(database, projection, selection, selectionArgs, null, null, sortOrder);
        Log.d(TAG, DatabaseUtils.dumpCursorToString(cursor));
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

}
