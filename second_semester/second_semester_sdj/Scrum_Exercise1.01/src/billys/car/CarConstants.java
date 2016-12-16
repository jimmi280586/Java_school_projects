package billys.car;

public interface CarConstants {
	CarState FORWARD = new CarForward();
	CarState BACKWARD = new CarBackward();
	CarState HEADLIGHTS = new CarHeadlightsAfterForward();
	CarState OFF = new CarOffAfterHeadlights();
	CarState OFF_AFTER_FORWARD = new CarOffAfterForward();
	CarState OFF_AFTER_BACKWARD = new CarOffAfterBackward();

}
