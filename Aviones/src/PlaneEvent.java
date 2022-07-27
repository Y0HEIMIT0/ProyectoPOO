import javafx.event.Event;
import javafx.event.EventType;

public class PlaneEvent extends Event {


    private Plane plane;

    public PlaneEvent(EventType<? extends Event> eventType, Plane plane) {
        super(eventType);
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }
}
