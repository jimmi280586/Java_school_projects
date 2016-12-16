/*
 * 20.04.2016 Reorganized
 * 30.10.2011 Original version
 */

package test;

import eventhandler.ShopSimulation;
import eventhandler.SimulationEngine;

public class Shop
{
	public static void main( String[] args )
	{
		new Shop().run();
	}


	private void run()
	{
		SimulationEngine engine = new ShopSimulation( 5, 500, 120, 600, 90 );
		engine.run();
	}
}