package door.state;
public class DoorOpen extends DoorState {
    
    public void click(Door door) {
        door.setState(STAYOPEN);
    }
    
    public void timeout(Door door) {
        door.setState(door.CLOSING);
    }
}