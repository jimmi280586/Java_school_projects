package door.state;

public class DoorClosed extends DoorState {
    
    public void click(Door door) {
        door.setState(OPENING);
    }
}