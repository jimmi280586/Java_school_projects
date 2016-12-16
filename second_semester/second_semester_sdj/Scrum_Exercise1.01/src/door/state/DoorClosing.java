package door.state;

public class DoorClosing extends DoorState {
    
    public void click(Door door) {
        door.setState(OPENING);
    }
    
    public void complete(Door door) {
        door.setState(door.CLOSED);
    }
}