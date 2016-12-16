/**
 * WS2SkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package interfaces.skeleton;

/**
 *  WS2SkeletonInterface java skeleton interface for the axisService
 */
public interface WS2SkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param reverse
     */
    public interfaces.ReverseResponse reverse(interfaces.Reverse reverse);

    /**
     * Auto generated method signature
     *
     * @param vat
     */
    public interfaces.VatResponse vat(interfaces.Vat vat);

    /**
     * Auto generated method signature
     *
     * @param max
     */
    public interfaces.MaxResponse max(interfaces.Max max);

    /**
     * Auto generated method signature
     *
     * @param isLeap
     */
    public interfaces.IsLeapResponse isLeap(interfaces.IsLeap isLeap);

    /**
     * Auto generated method signature
     *
     * @param avg
     */
    public interfaces.AvgResponse avg(interfaces.Avg avg);
}
