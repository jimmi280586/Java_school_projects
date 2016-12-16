package rmi;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class TaskClient implements Serializable {

  private static final long serialVersionUID = -9154321877613063471L;

  private RemoteTaskList server;

  public TaskClient() throws RemoteException {
    super();
    try {
      server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/taskServer");
      logTasks();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void logTasks() {
    String task;
    Scanner userInput = new Scanner(System.in);
    while (true) {
      try {
        System.out.println("Choose: ");
        System.out.println("Input: create a new task");
        System.out.println("Remove: remove a task");
        System.out.println("Count: get number of tasks");
        switch (userInput.nextLine().toLowerCase()) {
          case "input":
            System.out.println("Input new task: ");
            task = userInput.nextLine();
            server.add(task);
            break;
          case "remove":
            server.remove();
            break;
          case "count":
            System.out.println(server.size());
            break;
          case "quit":
            System.exit(0);
            break; // Not necessary
          default:
            System.out.println("Not a valid command");
            break;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  public static void main(String[] args) throws RemoteException {
    try {
      TaskClient client = new TaskClient();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
