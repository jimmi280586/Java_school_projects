
package door.state;

public class DoorStayOpen extends DoorState {
    
    public void click(Door door) {
        door.setState(CLOSING);
    }
}