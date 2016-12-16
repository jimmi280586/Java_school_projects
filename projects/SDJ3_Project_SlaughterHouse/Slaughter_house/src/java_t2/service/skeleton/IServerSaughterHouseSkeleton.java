/**
 * IServerSaughterHouseSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package java_t2.service.skeleton;

import java.rmi.RemoteException;
import java.util.ArrayList;

import java_t2.Data.*;
import java_t3.Server.IServer;
import java_t3.Server.ServerRMIDB;

/**
 *  IServerSaughterHouseSkeleton java skeleton for the axisService
 */
public class IServerSaughterHouseSkeleton
    implements IServerSaughterHouseSkeletonInterface {
    public IServerSaughterHouseSkeleton()throws RemoteException
    {}
	IServer db = new ServerRMIDB();
	
	/**
     * Auto generated method signature
     *
     * @param recallPack0
     * @return recallPackResponse1
     */
    public java_t2.service.RecallPackResponse recallPack(
        java_t2.service.RecallPack recallPack0) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#recallPack");
    }

    /**
     * Auto generated method signature
     *
     * @param addAnimal2
     * @return
     * @throws RemoteException 
     */
    public void addAnimal(java_t2.service.AddAnimal addAnimal2) throws RemoteException {
        Animal tmp = new Animal(addAnimal2.getArgs0(), addAnimal2.getArgs1(), (float) addAnimal2.getArgs2());
        db.saveAnimal(tmp);
    }

    /**
     * Auto generated method signature
     *
     * @param addToTray3
     * @return
     */
    public void addToTray(java_t2.service.AddToTray addToTray3) {
        //TODO : fill this with the necessary business logic
    }

    /**
     * Auto generated method signature
     *
     * @param getAnimal4
     * @return getAnimalResponse5
     */
    public java_t2.service.GetAnimalResponse getAnimal(
        java_t2.service.GetAnimal getAnimal4) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getAnimal");
    }

    /**
     * Auto generated method signature
     *
     * @param addTray6
     * @return
     */
    public void addTray(java_t2.service.AddTray addTray6) {
        //TODO : fill this with the necessary business logic
    }

    /**
     * Auto generated method signature
     *
     * @param addPart7
     * @return
     */
    public void addPart(java_t2.service.AddPart addPart7) {
    	ArrayList<String> list = new ArrayList<String>();
    	String a = addPart7.getArgs3();
    	String b = "";
    	for(int i = 0; i<a.length(); i++)
    	{    		
    		if(a.charAt(i) == '/')
    		{
    			list.add(b);
    		}
    		b += a.charAt(i);
    	}
        Tray tmp = new Tray(addPart7.getArgs0(), addPart7.getArgs1(), (float) addPart7.getArgs2(), list);
    }

    /**
     * Auto generated method signature
     *
     * @param getPart8
     * @return getPartResponse9
     */
    public java_t2.service.GetPartResponse getPart(
        java_t2.service.GetPart getPart8) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getPart");
    }

    /**
     * Auto generated method signature
     *
     * @param getTray10
     * @return getTrayResponse11
     */
    public java_t2.service.GetTrayResponse getTray(
        java_t2.service.GetTray getTray10) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getTray");
    }

    /**
     * Auto generated method signature
     *
     * @param addOrder12
     * @return
     */
    public void addOrder(java_t2.service.AddOrder addOrder12) {
        //TODO : fill this with the necessary business logic
    }

    /**
     * Auto generated method signature
     *
     * @param makeOrder13
     * @return makeOrderResponse14
     */
    public java_t2.service.MakeOrderResponse makeOrder(
        java_t2.service.MakeOrder makeOrder13) {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#makeOrder");
    }
}
