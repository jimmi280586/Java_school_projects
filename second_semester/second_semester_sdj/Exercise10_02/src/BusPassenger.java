import java.util.Observable;
import java.util.Observer;

public class BusPassenger implements Observer {
  private String name;
  private Bus bus;
  private boolean newPassenger;

  public BusPassenger(String name) {
    this.name = name;
    this.bus = null;
    this.newPassenger = false;
  }

  public String getName() {
    return name;
  }

  public boolean isNewPassenger() {
    return newPassenger;
  }

  public Bus getBus() {
    return bus;
  }

  public void getIn() {
    if (this.bus != null) {
      getOut();
    }

    this.bus = Bus.getInstance();
    newPassenger = true;
    bus.passengerGettingIn(this);
  }

  public void getOut() {
    newPassenger = false;
    bus.passengerGettingOut(this);
    bus = null;
  }

  public String toString() {
    return name;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof BusPassenger)) {
      return false;
    }
    BusPassenger p = (BusPassenger) obj;
    return name.equals(p.name) && ((bus == null & p.bus == null) || bus.equals(p.bus))
        && newPassenger == p.newPassenger;
  }

  public void showMessage(String message) {
    String reply = "";
    String[] split = message.split(":");
    if (split.length != 2) {
      reply = "I don't understand";
    } else {
      if (split[0].equalsIgnoreCase("Enter")) {
        reply = "Hello ";
      } else {
        reply = "Bye Bye ";
      }
      reply += split[1];
    }
    System.out.println(name + "> " + reply);
  }

  @Override
  public void update(Observable observable, Object arg) {

    showMessage((String) arg);

  }
}
