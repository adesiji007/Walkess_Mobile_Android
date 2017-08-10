package com.example.adesiji.Walkess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;

/**
 * Created by adesiji on 01/12/2015.
 */
public class Task extends AppCompatActivity {
   // private String taskName = null;
   // private String taskDescription = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_date);
    }
    // auto set to false
    boolean isComplete = false;
    Date dueDate = null;

    // Not all logic is implemented here
    public Task(Date dueDate){
        //this.taskName = taskName;
        //this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    //public String getTaskName(){return taskName; }

   // public String getTaskDescription(){return taskDescription;}

    public Date getDueDate(){
        return dueDate;
    }
}
