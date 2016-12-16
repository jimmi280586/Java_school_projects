package door.state;

public interface DoorConstants {
    DoorState CLOSED = new DoorClosed();
    DoorState OPENING = new DoorOpening();
    DoorState OPEN = new DoorOpen();
    DoorState CLOSING = new DoorClosing();
    DoorState STAYOPEN = new DoorStayOpen();
}