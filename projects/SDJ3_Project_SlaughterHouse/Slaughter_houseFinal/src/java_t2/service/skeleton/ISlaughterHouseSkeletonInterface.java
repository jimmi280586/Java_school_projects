/**
 * ISlaughterHouseSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package java_t2.service.skeleton;

/**
 *  ISlaughterHouseSkeletonInterface java skeleton interface for the axisService
 */
public interface ISlaughterHouseSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param addAnimal
     */
    public java_t2.service.AddAnimalResponse addAnimal(
        java_t2.service.AddAnimal addAnimal);

    /**
     * Auto generated method signature
     *
     * @param newTray
     */
    public java_t2.service.NewTrayResponse newTray(
        java_t2.service.NewTray newTray);

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
     * @param newPart
     */
    public java_t2.service.NewPartResponse newPart(
        java_t2.service.NewPart newPart);

    /**
     * Auto generated method signature
     *
     * @param getCurrentWeight
     */
    public java_t2.service.GetCurrentWeightResponse getCurrentWeight(
        java_t2.service.GetCurrentWeight getCurrentWeight);

    /**
     * Auto generated method signature
     *
     * @param newOrder
     */
    public java_t2.service.NewOrderResponse newOrder(
        java_t2.service.NewOrder newOrder);
}
