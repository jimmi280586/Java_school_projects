package exercise4;


public class CarThread extends Thread
{
	private IParkingPlace parkingPlace;
	private int carNo;
	
	public CarThread(IParkingPlace parkingPlace, int carNo)
	{
		this.parkingPlace = parkingPlace;
		this.carNo = carNo;
	}
	
	public void run()
	{
		drive1();
		parkingPlace.arrive();
		park();
		parkingPlace.leave();
		drive2();
	}
	
	private void drive1()
	{
		
			try {
				Thread.sleep(4000, 10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(carNo + " arriving ");	
		
	}
	
	private void park()
	{
		try {
			Thread.sleep(4000, 10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(carNo + " parking ");
	}
	
	private void drive2()
	{
		
			try {
				Thread.sleep(4000, 10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(carNo + " leaving ");	
		
	}
}
