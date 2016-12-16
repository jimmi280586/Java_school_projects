package billys.car;

public class CarHeadlightsAfterForward extends CarState {

	@Override
	public void pressButton(Car car) {
		car.setState(OFF);
	}
	
	@Override
	public String getStatus() {
		return "Shining headlights!";
	}

}
