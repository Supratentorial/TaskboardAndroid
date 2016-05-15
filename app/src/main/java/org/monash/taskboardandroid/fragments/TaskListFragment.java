package org.monash.taskboardandroid.fragments;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.monash.taskboardandroid.R;
import org.monash.taskboardandroid.TaskContentProvider;
import org.monash.taskboardandroid.datalayer.TaskListAdapter;


public class TaskListFragment extends Fragment {

    private String TAG = "TaskListFragment";

    public TaskListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        ;
        ContentResolver mResolver = this.getActivity().getContentResolver();
        Cursor taskCursor = mResolver.query(TaskContentProvider.CONTENT_URI_TASKS, null, null, null, null);
        TaskListAdapter taskListAdapter = new TaskListAdapter(getActivity(), taskCursor, 0);
        final ListView mTaskList = (ListView) view.findViewById(R.id.task_list_view);
        mTaskList.setAdapter(taskListAdapter);
        mTaskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TaskDetailFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }

        });
        return view;
    }

}
