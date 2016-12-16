package rmi;

import java.util.ArrayList;

public class TaskList {
  private ArrayList<String> tasks;
  
  public TaskList() {
    tasks = new ArrayList<String>();
  }
  
  public void addTask(String task) {
    tasks.add(task);
  }
  
  public String getAndRemoveNextTask() {
    if (tasks.isEmpty()) {
      return "List is Empty";
    }
    return tasks.remove(0);
  }
  
  public int size() {
    return tasks.size();
  }

}
