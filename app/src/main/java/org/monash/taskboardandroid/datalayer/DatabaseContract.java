package org.monash.taskboardandroid.datalayer;

/**
 * Created by Blake on 12/05/2016.
 */
public class DatabaseContract {

    public DatabaseContract(){}

    public static final String DATABASE_NAME = "taskboard.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME_TASKS = "Tasks";


    public static final String COLUMN_NAME_PATIENT_ID = "patient_id";
    public static final String COLUMN_NAME_PATIENT_URN = "patient_urn";
    public static final String COLUMN_NAME_PATIENT_LAST_NAME = "patient_last_name";
    public static final String COLUMN_NAME_PATIENT_FIRST_NAME = "patient_first_name";
    public static final String COLUMN_NAME_WARD = "ward";
    public static final String COLUMN_NAME_BED = "bed";
    public static final String COLUMN_NAME_STATUS = "status";
    public static final String COLUMN_NAME_TASK_ID = "_id";
    public static final String COLUMN_NAME_TASK_DESCRIPTION = "description";
    public static final String COLUMN_NAME_TASK_BACKGROUND = "background";

}
