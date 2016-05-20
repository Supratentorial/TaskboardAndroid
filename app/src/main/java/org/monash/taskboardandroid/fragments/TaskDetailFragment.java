package org.monash.taskboardandroid.fragments;

import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.monash.taskboardandroid.AppConstants;
import org.monash.taskboardandroid.R;
import org.monash.taskboardandroid.TaskContentProvider;
import org.monash.taskboardandroid.datalayer.DatabaseContract;


public class TaskDetailFragment extends Fragment {

    public static final String TAG = "TaskDetailFragment";

    public TaskDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_task_detail, container, false);
        TextView patientNameTextView = (TextView)view.findViewById(R.id.patient_name);
        TextView taskDescriptionTextView = (TextView)view.findViewById(R.id.task_description);
        TextView locationTextView = (TextView)view.findViewById(R.id.patient_location);
        Bundle bundle = this.getArguments();
        Long taskId = bundle.getLong(AppConstants.Id);
        ContentResolver contentResolver = this.getActivity().getContentResolver();
        String selectionClause = DatabaseContract.COLUMN_NAME_TASK_ID + "=?";
        String[] selectionArgs = { taskId.toString() };
        Cursor cursor = contentResolver.query(TaskContentProvider.CONTENT_URI_TASKS,null, selectionClause, selectionArgs, null);
        Log.d(TAG, DatabaseUtils.dumpCursorToString(cursor));
        if(cursor!= null) {
            cursor.moveToFirst();
            String patientLastName = cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_PATIENT_LAST_NAME));
            String patientFirstName = cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_PATIENT_FIRST_NAME));
            String patientFullName = patientLastName + ", " + patientFirstName;
            patientNameTextView.setText(patientFullName);
            taskDescriptionTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.COLUMN_NAME_TASK_DESCRIPTION)));
        }
        return view;
    }

}
