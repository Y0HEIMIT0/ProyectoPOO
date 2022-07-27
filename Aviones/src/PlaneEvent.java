import javafx.event.Event;
import javafx.event.EventType;

public class PlaneEvent extends Event {


    public static final EventType<PlaneEvent> PLANE_APROACHING = new EventType<>(Event.ANY, "PLANE_APROACHING");
    public static final EventType<PlaneEvent> PLANE_LEAVING = new EventType<>(Event.ANY, "PLANE_LEAVING");
//    public static final EventType<PlaneEvent> PLANE_APROACHING = new EventType<>(Event.ANY, "PLANE_CRAsHING");

    public PlaneEvent(EventType<? extends Event> eventType, Plane plane) {
        super(eventType);
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }

    private Plane plane;
}
