package test_04_05_2015.task3;

public class PizzaMethods implements IPizzaMethods
{

	private int slice = 0;
    private int orders = 0;
    private int deliver = 0;
    private final int S = 6;
   

    public synchronized void orderAPizza() throws InterruptedException
    {
        if(this.slice > 0)
        	wait();
        else
        this.orders++;
        notifyAll();
    }

    public synchronized void getAPizzaSlice() throws InterruptedException
    {    	
        if(this.slice == 0)
        {        	
        	 wait();
        }  
        else
        	this.slice--;
        	notifyAll();      
    }

    public synchronized void reciveAPizzaOrder() throws InterruptedException 
    {    	
        if(this.orders == 0) 
        	wait();
        else
        this.deliver++;
        this.orders--;
        notifyAll();
    }

    public synchronized void deliverAPizza() throws InterruptedException
    {
       if(this.deliver == 0)
       {
    	  wait();
       } 
       else
    	   this.slice += S;
    	   this.deliver--;
    	   notifyAll();       
    }

}
