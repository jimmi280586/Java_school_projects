package cd;

import cd.controller.Controller;
import cd.domain.model.Cd;
import cd.view.CdConsole;
import cd.view.CdView;
import utillity.collection.ArrayStack;
import utillity.collection.StackADT;

public class MyCdPile implements StackADT<Cd> 
{
	private ArrayStack<Cd> cds;
	
	public static void main(String[] args)
	{
		try
		{
			MyCdPile model = new MyCdPile();
			CdView view = new CdConsole();
			Controller controller = new Controller(view);
			view.start(controller);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public Cd pop() 
	{		
		return this.cds.pop();
	}

	@Override
	public Cd peek() 
	{
		return this.cds.peek();
	}

	@Override
	public int indexOf(Cd element) 
	{		
		return this.cds.indexOf(element);
	}

	@Override
	public boolean isEmpty()
	{	
		return this.cds.isEmpty();
	}

	@Override
	public int size()
	{		
		return this.cds.size();
	}

	@Override
	public void push(Cd element)
	{
		this.cds.push(element);		
	}

	

}
