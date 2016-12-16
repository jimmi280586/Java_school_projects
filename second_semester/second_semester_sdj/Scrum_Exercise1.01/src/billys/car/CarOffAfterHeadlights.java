package billys.car;

public class CarOffAfterHeadlights extends CarState {

	public void pressButton(Car car) {
		car.setState(null);
	}

	public String getStatus() {
		return "Off!";
	}
}
