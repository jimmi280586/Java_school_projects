
public class Cpu
{
	private String brand;
	private String model;
	private double ClockFrequency;
	private int cores;
	
	public Cpu(String brand, String model, double clockFrequency, int cores) 
	{
	
		this.brand = brand;
		this.model = model;
		this.ClockFrequency = clockFrequency;
		this.cores = cores;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getClockFrequency() {
		return ClockFrequency;
	}

	public int getCores() {
		return cores;
	}

	@Override
	public String toString() {
		 return this.brand + ", "
				 + this.model + ", "
				 + this.ClockFrequency + ", "
				 + this.cores;
	}
	
	
}
