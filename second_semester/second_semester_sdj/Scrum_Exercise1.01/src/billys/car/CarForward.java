package billys.car;

public class CarForward extends CarState {
	
	@Override
	public void pressButton(Car car) {
		car.setState(OFF);
	}
	
	@Override
	public String getStatus() {
		return "Moving forwards!";
	}


}
