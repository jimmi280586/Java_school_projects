package billys.car;

public class CarHeadlightsAfterBackward extends CarState {

	@Override
	public void pressButton(Car car) {
		car.setState(OFF);
	}
	
	@Override
	public String getStatus() {
		return "Shining headlights!";
	}

}
