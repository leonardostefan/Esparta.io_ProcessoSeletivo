package com.stefan.leonardo.espartaproject;



/**
 * Created by Leonardo on 03/12/2017.
 */

public class Task {
    private static int idCounter = 0;
    public int id;
    public String taskName;
//    public string taskDescription;
    public boolean isDone;

    public Task(String Name){
        idCounter++;
        this.id=idCounter;
        this.taskName=Name;
        this.isDone=false;
    }
}


