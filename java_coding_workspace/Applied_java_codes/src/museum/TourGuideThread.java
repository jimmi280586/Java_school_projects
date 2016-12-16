package museum;

public class TourGuideThread extends Thread
{
	private IMuseum museum;
	private int numberInGroup;
	private int arrivalOfVisitors;
	
	public TourGuideThread(IMuseum museum, int arrivalOfVisitors)
	{
		this.museum = museum;
		this.arrivalOfVisitors = arrivalOfVisitors;		
	}
	
	public void run()
	{
		
		this.numberInGroup = splitInGroup(this.arrivalOfVisitors);
		
		enter1();
		this.museum.enter(this.numberInGroup);		
		onTour();
		this.museum.leave(this.numberInGroup);
		enter2();
		
	}
	
	private void enter1()
	{
		
			try {
				Thread.sleep(4000, 10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(this.numberInGroup + " entering museum ");	
		
	}
	
	private void onTour()
	{
		try {
			Thread.sleep(4000, 10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(this.numberInGroup + " guided through museum ");
	}
	
	private void enter2()
	{
		
			try {
				Thread.sleep(4000, 10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(this.numberInGroup + " leaving museum ");	
		
	}

	private int splitInGroup(int arrivalOfVisitors)
	{
		int number;
		if(arrivalOfVisitors > 1 && arrivalOfVisitors <= 15)
		{
				this.arrivalOfVisitors = arrivalOfVisitors;
				return arrivalOfVisitors;
		}
		else
		{		
			number = 15;
			this.arrivalOfVisitors = this.arrivalOfVisitors - number;		
			return number;
		}
			
					
		
	}
}
