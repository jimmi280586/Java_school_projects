
public class Controler {

	public static void main(String[] args)
	{

		// Make an array that will hold 3 Computer objects
		Computer[] computers = new Computer[3];
		
		// Set the three items in the array
		computers[0] = new Computer("Apple", "iMac");
		computers[1] = new Computer("HP", "Desktop");
		computers[2] = new Laptop("Dell", "Latitude", 15);
		
		// Print all the array elements
		// Using the foreach loop
		for (Computer computer : computers)
		{
		
			// Print out the toString() for each object in the array
			System.out.println(computer.toString());
		}
		
		// Give a new CPU to the Laptop
		computers[1].setCpu(new Cpu("AMD", "Athlon", 2.7, 4));
		computers[2].setCpu(new Cpu("Intel", "i5", 2.5, 2));
		
		// Find the total number of cores in all the computers
		// and the average clock speed
		// Just use a normal loop
		int numberOfComputersWithCPU = 0;
		int totalNumberOfCores = 0;
		double totalClockSpeed = 0;
		
		for (int i = 0; i < computers.length; i++)
		{
			if (computers[i].getCpu() != null)
		{
				numberOfComputersWithCPU += 1;
				totalNumberOfCores += computers[i].getCpu().getCores();
				totalClockSpeed += computers[i].getCpu().getClockFrequency();
		}
		}
		
			System.out.println("Number of cores total: " + totalNumberOfCores);
			System.out.println("Average clock speed: " + (totalClockSpeed / numberOfComputersWithCPU));
		
			// Print the Screen size of all Laptops
			for (int i = 0; i < computers.length; i++)
			{
				if (computers[i] instanceof Laptop)
			{
					
					System.out.println("Screen size for laptop: "
							+ ((Laptop) computers[i]).getScreenSize());
		}
		}
		

	}

}
