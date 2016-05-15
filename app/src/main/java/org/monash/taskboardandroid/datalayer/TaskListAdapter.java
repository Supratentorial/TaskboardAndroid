package org.monash.taskboardandroid.datalayer;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.monash.taskboardandroid.R;
import org.w3c.dom.Text;

/**
 * Created by Blake on 13/05/2016.
 */
public class TaskListAdapter extends CursorAdapter {

    private LayoutInflater inflater;
    private String TAG = "TaskListAdapter";

    public TaskListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG, DatabaseUtils.dumpCursorToString(c));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(R.layout.task_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView patientNameTextView = (TextView) view.findViewById(R.id.patient_name);
        TextView patientUrnTextView = (TextView) view.findViewById(R.id.patient_urn);
        TextView patientWardTextView = (TextView) view.findViewById(R.id.patient_ward);
        TextView patientBedTextView = (TextView) view.findViewById(R.id.patient_bed);
        TextView taskDescriptionTextView = (TextView) view.findViewById(R.id.task_description);

        String patientLastName = "";
        String patientFirstName = "";
        String patientFullName = "";
        String patientWard = "";
        String patientBed = "";
        String patientUrn = "";
        String taskDescription = "";

        patientLastName = cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_PATIENT_LAST_NAME));
        patientFirstName = cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_PATIENT_FIRST_NAME));
        patientUrn = " (" + cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_PATIENT_URN)) + ") ";
        patientWard = cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_WARD)) + " ";
        patientBed = "B" + cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_BED));
        taskDescription = cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_TASK_DESCRIPTION));

        patientFullName = patientLastName.toUpperCase() + ", " + patientFirstName;
        patientNameTextView.setText(patientFullName);
        patientUrnTextView.setText(patientUrn);
        patientWardTextView.setText(patientWard);
        patientBedTextView.setText(patientBed);
        taskDescriptionTextView.setText(taskDescription);
    }
}
