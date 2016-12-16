package exercise4;


public class main2Parking
{
	public static void main(String[] args) 
	{
		IParkingPlace parkingPlace = new ParkingPlaceImpl(5);
		Thread displayThread = new DisplayThread(parkingPlace);
		displayThread.start();
		
		for (int i = 1; i < 100; i++)
		{
			new CarThread(parkingPlace, i).start();
			System.out.println("Car " + i + " started");
			try {
				Thread.sleep(4000, 5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
