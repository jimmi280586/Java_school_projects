/**
 * HelloSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package interfaces.skeleton;

/**
 *  HelloSkeleton java skeleton for the axisService
 */
public class HelloSkeleton implements HelloSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param getHelloText0
     * @return getHelloTextResponse1
     */
    public interfaces.GetHelloTextResponse getHelloText(interfaces.GetHelloText getHelloText0) {
    	interfaces.GetHelloTextResponse res  = new interfaces.GetHelloTextResponse();
    	
    	res.set_return("Hello caller!");
    	return res;
    }
}
