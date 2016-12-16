/**
 * ISlaughterHouseSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package java_t2.service.skeleton;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.xalan.lib.Extensions;

import java_t2.Data.Tray;
import java_t2.RMIhost.RMIslaughterhouse;
import java_t2.service.AddAnimalResponse;
import java_t2.service.GetCurrentWeightResponse;
import java_t2.service.GetTrayResponse;
import java_t2.service.NewOrderResponse;
import java_t2.service.NewPartResponse;
import java_t2.service.NewTrayResponse;

/**
 *  ISlaughterHouseSkeleton java skeleton for the axisService
 */
public class ISlaughterHouseSkeleton implements ISlaughterHouseSkeletonInterface {
	public ISlaughterHouseSkeleton()throws RemoteException, NotBoundException, MalformedURLException
	{}
    private RMIslaughterhouse rmi = new RMIslaughterhouse("SDJ3 Slaughter ");
	
	/**
     * Auto generated method signature
     *
     * @param addAnimal0
     * @return addAnimalResponse1
     */
    public java_t2.service.AddAnimalResponse addAnimal(
        java_t2.service.AddAnimal addAnimal0) {
        rmi.addAnimal(addAnimal0.getArgs0(), addAnimal0.getArgs1(), addAnimal0.getArgs2());
		AddAnimalResponse res = new AddAnimalResponse();
		res.set_return("animal added");
		return res;
    }

    /**
     * Auto generated method signature
     *
     * @param newTray2
     * @return newTrayResponse3
     */
    public java_t2.service.NewTrayResponse newTray(
        java_t2.service.NewTray newTray2) {
    	//caluculate the list her
    	ArrayList<String> tmp = new ArrayList<String>();
    	String a = newTray2.getArgs3();
    	String b = "";
    	for (int i = 0; i < a.length(); i++) 
    	{
			if(a.charAt(i) == '/')
			{
				tmp.add(b);
				b = "";
			}
			b += a.charAt(i); 
		} 
    	
       rmi.newTray(newTray2.getArgs0(), newTray2.getArgs1(), newTray2.getArgs2(), tmp);
       NewTrayResponse res = new NewTrayResponse();
       res.set_return("tray added ");
       return res;
    }

    /**
     * Auto generated method signature
     *
     * @param getTray4
     * @return getTrayResponse5
     */
    public java_t2.service.GetTrayResponse getTray(
        java_t2.service.GetTray getTray4) {
        GetTrayResponse res = new GetTrayResponse();
        Tray a = rmi.getTray(getTray4.getArgs0());
        res.set_return(a.toString());
        return res;
    }

    /**
     * Auto generated method signature
     *
     * @param newPart6
     * @return newPartResponse7
     */
    public java_t2.service.NewPartResponse newPart(
        java_t2.service.NewPart newPart6) {
        rmi.newPart(newPart6.getArgs0(), newPart6.getArgs1(), newPart6.getArgs2(), newPart6.getArgs3());
        NewPartResponse res = new NewPartResponse();
        res.set_return("part added ");
        return res;
    }

    /**
     * Auto generated method signature
     *
     * @param getCurrentWeight8
     * @return getCurrentWeightResponse9
     */
    public java_t2.service.GetCurrentWeightResponse getCurrentWeight(
        java_t2.service.GetCurrentWeight getCurrentWeight8) {
       double a = rmi.getCurrentWeight(getCurrentWeight8.getArgs0());
       GetCurrentWeightResponse res = new GetCurrentWeightResponse();
       res.set_return("" + a);
       return res;
    }

    /**
     * Auto generated method signature
     *
     * @param newOrder10
     * @return newOrderResponse11
     */
    public java_t2.service.NewOrderResponse newOrder(
        java_t2.service.NewOrder newOrder10) {
        rmi.newOrder(newOrder10.getArgs0(), newOrder10.getArgs1(), newOrder10.getArgs2());
        NewOrderResponse res = new NewOrderResponse();
        res.set_return("order added ");
        return res;
    }
}
