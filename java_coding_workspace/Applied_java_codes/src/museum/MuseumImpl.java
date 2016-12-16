package museum;

public class MuseumImpl implements IMuseum 
{
	private static int MAX;	
	private static boolean changed = false;
	private static int numberInMuseum = 0;
	
	public MuseumImpl(int MAX) 
	{
		this.MAX = MAX;				
	}
	
	public synchronized void enter(int numberInGroup)
	{
		
		while(isFull(numberInGroup))
		{
			System.out.println(" * museum is full * ");
			System.out.println(" * waiting for Group to leave * ");
			try{				
				wait();
			}
			catch (InterruptedException e) {};
			enterNow(numberInGroup);
		}		
		this.changed = true;
		this.numberInMuseum = this.numberInMuseum + numberInGroup;
		notifyAll();
	}

	public synchronized int getNumber()
	{
		while(!this.changed)
		{
			try{
				wait();
			}
			catch (InterruptedException e){};
		}
		this.changed = false;
		return this.numberInMuseum;
	}

	public synchronized void leave(int numberInGroup)
	{		
		this.changed = true;
		this.numberInMuseum = this.numberInMuseum - numberInGroup;
		notifyAll();
	}
	
	private void enterNow(int numberInGroup) 
	{
		this.numberInMuseum += numberInGroup;		
	}

	private boolean isFull(int numberInGroup)
	{
		return (this.numberInMuseum + numberInGroup > this.MAX);
	}
	
	
}
