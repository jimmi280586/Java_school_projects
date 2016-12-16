package main;

import utility.collection.QueueAdt;


public class Main {

  public static void main(String[] args) {
    Log log = Log.getLog();
    log.add("Heyo");
    QueueAdt<String> logs = log.getAll();

    System.out.println(logs.dequeue());

  }

}
