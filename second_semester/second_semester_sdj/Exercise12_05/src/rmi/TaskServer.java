package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList {

  private static final long serialVersionUID = 724887908984646040L;
  private TaskList tasks;


  public TaskServer() throws RemoteException {
    super();
    tasks = new TaskList();
  }


  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.createRegistry(1099);
      RemoteTaskList rmiServer = new TaskServer();
      Naming.rebind("taskServer", rmiServer);
      System.out.println("Starting server");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  /*
   * NOTE: Exercise isn't finished,
   * as I can't figure out a way to respond to all connected clients
   * without implementing a design pattern (which is the topic of our next lesson...)
   */
  @Override
  public void add(String task, RemoteTaskClient sender) throws RemoteException {
    tasks.addTask(task);
    System.out.println("Added task: " + task);
    sender.notifyOfAddedTask(task);
  }


  @Override
  public void remove() throws RemoteException {
    String removedTask = tasks.getAndRemoveNextTask();
    System.out.println("Removed task: " + removedTask);
  }


  @Override
  public int size() throws RemoteException {
    return tasks.size();
  }
}
