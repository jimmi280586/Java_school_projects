package billys.car;

public abstract class CarState implements CarConstants {

	public abstract void pressButton(Car car);

	public String getStatus() {
		return this.getClass().getSimpleName();
	}

}
