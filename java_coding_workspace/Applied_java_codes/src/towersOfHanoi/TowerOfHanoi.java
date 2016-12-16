package towersOfHanoi;
import java.util.Calendar;


public class TowerOfHanoi 
{
	  	private int totalDisks;
	    private int count;

	    
	    public TowerOfHanoi(int disks)
	    {
	        totalDisks = disks;
	        count = 0;
	    }

	    public void solve()
	    {
	    	System.out.println(Calendar.getInstance().getTime());
	        moveTower (totalDisks,1,3,2);
	        System.out.println(Calendar.getInstance().getTime());
	    }

	    private void moveTower(int numDisks, int start, int end, int temp)
	    {
	        if (numDisks == 1)
	        {
	            moveOneDisk(start, end);
	        }
	        else 
	        {
	            moveTower (numDisks - 1, start, temp, end);
	            moveOneDisk (start, end);
	            moveTower (numDisks - 1, temp, end, start);
	        }
	    }

	    private void moveOneDisk(int start, int end)
	    {
	       count = count + 1;
	       System.out.println("Move one disk from " + start + " to " + end + " - Move " + count);
	    }
	    
	    public static void main(String[] args)
	    {
			TowerOfHanoi t = new TowerOfHanoi(100);
			t.solve();
			System.out.println(t.count);
		}
}
