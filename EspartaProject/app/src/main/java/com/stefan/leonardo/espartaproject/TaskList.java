package com.stefan.leonardo.espartaproject;


import android.widget.ArrayAdapter;

import java.util.ArrayList;

class TaskList {

    public ArrayList<Task> list;

    public TaskList(){
        list=new ArrayList<>();
    }

    public ArrayList<Task> pendingList(){
        ArrayList<Task> result = new ArrayList<Task>();
        for (Task task: list) {
            if(task.isDone){
                result.add(task);
            }
        }
        return result;
    }
    public ArrayList<Task> doneList(){
        ArrayList<Task> result = new ArrayList<Task>();
        for (Task task: list) {
            if(task.isDone){
                result.add(task);
            }
        }
        return result;
    }
    void adapterSet(ArrayAdapter<String> adapter, boolean Cond){
        adapter.clear();
        if(Cond) {
            for (Task task : this.doneList()) {
                adapter.add(task.id + " - " + task.taskName);
            }
        }else {
            for (Task task : this.pendingList()) {
                adapter.add(task.id + " - " + task.taskName);
            }
        }
    }


    public boolean removeId(int id){
        for (Task task: this.list){
            if (task.id==id){
                this.list.remove(task);
                return true;
            }
        }
        return false;
    }
    public boolean changeStatus(int id){
        for (Task task: this.list){
            if (task.id==id){
                if (task.isDone==true) task.isDone=false;
                else task.isDone=true;
                return true;
            }
        }
        return false;
    }


}
