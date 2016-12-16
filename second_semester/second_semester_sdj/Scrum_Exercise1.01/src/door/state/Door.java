package door.state;


public class Door implements DoorConstants {
	
	private DoorState state = CLOSED;
    
    public void click() {
        state.click(this);
    }
    
    public void complete() {
        state.complete(this);
    }
    
    public void setState(DoorState state) {
        this.state = state;
        //	setChanged();
    }
    
    public String status() {
        return state.status();
    }
    
    public void timeout() {
        state.timeout(this);
    }
}