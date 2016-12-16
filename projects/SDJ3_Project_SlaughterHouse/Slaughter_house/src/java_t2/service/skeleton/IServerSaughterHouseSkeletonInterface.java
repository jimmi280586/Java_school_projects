/**
 * IServerSaughterHouseSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package java_t2.service.skeleton;

import java.rmi.RemoteException;

/**
 *  IServerSaughterHouseSkeletonInterface java skeleton interface for the axisService
 */
public interface IServerSaughterHouseSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param recallPack
     */
    public java_t2.service.RecallPackResponse recallPack(
        java_t2.service.RecallPack recallPack);

    /**
     * Auto generated method signature
     *
     * @param addAnimal
     * @throws RemoteException 
     */
    public void addAnimal(java_t2.service.AddAnimal addAnimal) throws RemoteException;

    /**
     * Auto generated method signature
     *
     * @param addToTray
     */
    public void addToTray(java_t2.service.AddToTray addToTray);

    /**
     * Auto generated method signature
     *
     * @param getAnimal
     */
    public java_t2.service.GetAnimalResponse getAnimal(
        java_t2.service.GetAnimal getAnimal);

    /**
     * Auto generated method signature
     *
     * @param addTray
     */
    public void addTray(java_t2.service.AddTray addTray);

    /**
     * Auto generated method signature
     *
     * @param addPart
     */
    public void addPart(java_t2.service.AddPart addPart);

    /**
     * Auto generated method signature
     *
     * @param getPart
     */
    public java_t2.service.GetPartResponse getPart(
        java_t2.service.GetPart getPart);

    /**
     * Auto generated method signature
     *
     * @param getTray
     */
    public java_t2.service.GetTrayResponse getTray(
        java_t2.service.GetTray getTray);

    /**
     * Auto generated method signature
     *
     * @param addOrder
     */
    public void addOrder(java_t2.service.AddOrder addOrder);

    /**
     * Auto generated method signature
     *
     * @param makeOrder
     */
    public java_t2.service.MakeOrderResponse makeOrder(
        java_t2.service.MakeOrder makeOrder);
}
