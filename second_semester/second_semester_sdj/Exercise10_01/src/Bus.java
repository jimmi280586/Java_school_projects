import java.util.Observable;

public class Bus extends Observable {
  private String info;

  public Bus() {
    this.info = "eXpress " + hashCode() % 100;
  }

  public void passengerGettingIn(BusPassenger p) {
    addObserver(p);
    setChanged();
    notifyObservers("Enter:" + p);
  }

  public void passengerGettingOut(BusPassenger p) {
    deleteObserver(p);
    setChanged();
    notifyObservers("Leave:" + p);
  }

  public String getInfo() {
    return info;
  }

  public String toString() {
    return info;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Bus)) {
      return false;
    }
    Bus b = (Bus) obj;
    return info.equals(b.info);
  }
}
