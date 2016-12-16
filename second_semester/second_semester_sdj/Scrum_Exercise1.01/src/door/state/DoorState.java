package door.state;

public abstract class DoorState implements DoorConstants {
    
    public abstract void click(Door door);
    
    public void complete(Door door) {
    }
    
    public String status() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.') + 1);
    }
    
    public void timeout(Door door) {
    }
}