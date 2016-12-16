package billys.car;

public class Car implements CarConstants {
	private CarState state = OFF;

	public void pressButton() {
		state.pressButton(this);
	}
	
	public void setState(CarState state) {
		this.state = state;
	}
	
	public String getStatus() {
		return state.getStatus();
	}

}
