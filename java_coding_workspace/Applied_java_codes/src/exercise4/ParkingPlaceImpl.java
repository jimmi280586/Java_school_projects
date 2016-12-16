package exercise4;


public class ParkingPlaceImpl implements IParkingPlace 
{
	private static int MAX;
	private static int noOfCars;
	private static boolean changed;
	
	public ParkingPlaceImpl(int MAX) 
	{
		this.MAX = MAX;
		this.noOfCars = 0;
		this.changed = true;
	}
	
	public synchronized void arrive()
	{
		while(isFull())
		{
			try{
				wait();
			}
			catch (InterruptedException e) {};
			
		}
		noOfCars++;
		changed = true;
		notifyAll();
	}

	public synchronized void leave()
	{
		noOfCars--;
		changed = true;
		notifyAll();
	}
	
	public synchronized int freePlaces()
	{
		while(!changed)
		{
			try{
				wait();
			}
			catch (InterruptedException e){};
		}
		changed = false;
		return (MAX - noOfCars);
	}
	
	private boolean isFull()
	{
		while(noOfCars == MAX)
		{
			return true;
		}
		return false;
	}
}
