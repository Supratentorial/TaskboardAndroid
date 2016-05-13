package org.monash.taskboardandroid.datalayer;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.monash.taskboardandroid.R;

/**
 * Created by Blake on 13/05/2016.
 */
public class TaskListAdapter extends CursorAdapter {

    private LayoutInflater inflater;

    public TaskListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView patientNameTextView = (TextView)view.findViewById(R.id.patient_name);
        if(cursor.moveToFirst()) {
            String patientFullName = cursor.getColumnIndex(DatabaseContract)
        }
        patientNameTextView.setText();
    }
}
