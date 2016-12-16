/**
 * IJSimpCalcWebServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package webservice.skeleton;

import webservice.Addition;
import webservice.AdditionResponse;

/**
 *  IJSimpCalcWebServiceSkeleton java skeleton for the axisService
 */
public class IJSimpCalcWebServiceSkeleton
    implements IJSimpCalcWebServiceSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param addition0
     * @return additionResponse1
     */
    public webservice.AdditionResponse addition(webservice.Addition addition0) {
    	webservice.AdditionResponse res = new webservice.AdditionResponse();
        
    	res.set_return(": web service working!");//this will be shown in c#
    	System.out.println("printing to java" + addition0.getArgs0());//this will be in the server side cmd promt
    	return res;
    }

	
	}

