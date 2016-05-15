package org.monash.taskboardandroid.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.monash.taskboardandroid.AppConstants;
import org.monash.taskboardandroid.R;


public class TaskDetailFragment extends Fragment {

    public static final String TAG = "TaskDetailFragment";

    public TaskDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        Long patientId = bundle.getLong(AppConstants.PatientId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_task_detail, container, false);
        TextView patientNameTextView = (TextView)view.findViewById(R.id.patient_name);


        return view;
    }

}
