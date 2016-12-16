package main;

import java.time.LocalDateTime;

import utility.collection.LinkedQueue;
import utility.collection.QueueAdt;

public class Log {

  private boolean printout;
  private QueueAdt<String> logs;

  public Log(boolean printout) {
    this.printout = printout;
    this.logs = new LinkedQueue<String>();
  }

  public void add(String log) {
    if (printout) {
      System.out.println("Added log: " + log);
    }
    
    String timestamp = LocalDateTime.now().toString();
    log = timestamp + " >> " + log;
    logs.enqueue(log);
  }

  public QueueAdt<String> getAll() {
    
    return logs; // Totally a problem since object reference is now shared
  }

}
