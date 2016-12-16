package door.state;

public class TestDoor {
    
    public TestDoor() {
    }
    
    public static void main(String[] args) {
        Door d = new Door();
        System.out.println("Start up, the door is "+d.status()); //Closed
        d.click();
        System.out.println("Has clicked, the door is "+d.status()); //Opening
        d.click();
        System.out.println("Has clicked, the door is "+d.status()); //Closing
        d.complete();
        System.out.println("Copleted, the door is "+d.status()); //Closed
        d.click();
        System.out.println("Has clicked, the door is "+d.status()); //Opening
        d.complete();
        System.out.println("Copleted, the door is "+d.status()); //Open
        d.click();
        System.out.println("Has clicked, the door is "+d.status()); //StayOpen
        d.click();
        System.out.println("Has clicked, the door is "+d.status()); //Closing
        d.complete();
        System.out.println("Copleted, the door is "+d.status()); //Closed
        d.timeout();
        System.out.println("timeout at a illegal time, the door is still "+d.status()); //still closed
    }
    
}
