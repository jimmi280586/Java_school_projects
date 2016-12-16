/*
 * 20.04.2016 Reorganized
 * 30.10.2011 Original version
 */

package eventhandler;


public abstract class Actor
 	implements Comparable<Actor>
{
	protected int nextActionTime;


	public int getNextActionTime()
	{
		return nextActionTime;
	}


	public void setNextActionTime( int nextActionTime )
	{
		this.nextActionTime = nextActionTime;
	}


	public abstract void action();


	@Override
	public int compareTo( Actor other )
	{
		return this.nextActionTime - other.nextActionTime;
	}
}