
public class Computer 
{
	private String brand;
	private String model;
	private Cpu cpu;
	
	public Computer(String brand, String model) 
	{
		
		this.brand = brand;
		this.model = model;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}
	
	public String getCpuBrand(){
		return this.cpu.getBrand();
	}
	
	public String toString()
	{
		 // Only print the cpu if it exists
		if (this.cpu != null)
		{
		return this.brand + ", "
		+ this.model + ", "
		+ this.cpu.toString();
		}
		return this.brand + ", "
		+ this.model;
	}
}
