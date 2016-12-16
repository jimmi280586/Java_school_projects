/**
 * TrackingSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package services.skeleton;

/**
 *  TrackingSkeletonInterface java skeleton interface for the axisService
 */
public interface TrackingSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param getAnimals
     */
    public services.GetAnimalsResponse getAnimals(
        services.GetAnimals getAnimals);

    /**
     * Auto generated method signature
     *
     * @param trackAnimal
     */
    public services.TrackAnimalResponse trackAnimal(
        services.TrackAnimal trackAnimal);

    /**
     * Auto generated method signature
     *
     * @param trackProduct
     */
    public services.TrackProductResponse trackProduct(
        services.TrackProduct trackProduct);
}
