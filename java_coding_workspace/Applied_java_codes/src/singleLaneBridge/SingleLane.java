package singleLaneBridge;

public class SingleLane implements Ilane
{

	private int red  = 0;
    private int blue = 0;

    public synchronized void enterFromTheLeft() throws InterruptedException
    {
        while (blue > 0)
        	wait();
        ++red;
    }

    public synchronized void exitToTheRight()
    {
        --red;
        if (red == 0)
            notifyAll();
    }

    public synchronized void enterFromTheRight() throws InterruptedException 
    {
        while (red > 0) 
        	wait();
        ++blue;
    }

    public synchronized void exitToTheLeft()
    {
        --blue;
        if (blue == 0)
            notifyAll();
    }

}
