package museum;

public class main2Museum
{
	public static void main(String[] args) 
	{
		IMuseum museum = new MuseumImpl(100);
		Thread displayThread = new DisplayThread(museum);
		displayThread.start();
		
		for (int i = 1; i < 4; i++)
		{
			new TourGuideThread(museum, 50).start();
			System.out.println("tour " + i + " started");
			try {
				Thread.sleep(4000, 5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
