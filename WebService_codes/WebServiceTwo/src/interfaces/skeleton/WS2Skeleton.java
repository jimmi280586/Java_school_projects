/**
 * WS2Skeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package interfaces.skeleton;

import interfaces.MaxResponse;

/**
 *  WS2Skeleton java skeleton for the axisService
 */
public class WS2Skeleton implements WS2SkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param reverse0
     * @return reverseResponse1
     */
    public interfaces.ReverseResponse reverse(interfaces.Reverse reverse0) {
        System.out.println( "reverse called" );
        
        String original = reverse0.getArgs0();
        
        String reverse = new StringBuffer(original).reverse().toString();
        
        interfaces.ReverseResponse res = new interfaces.ReverseResponse();
        res.set_return(reverse);
        
        return res;

    }

    /**
     * Auto generated method signature
     *
     * @param vat2
     * @return vatResponse3
     */
    public interfaces.VatResponse vat(interfaces.Vat vat2) {
    	
    	System.out.println( "vat called" );
      	 
		double amount = vat2.getArgs0();
		double vat = 0.25 * amount;
   
		interfaces.VatResponse res = new interfaces.VatResponse();
		res.set_return( vat );
		
		return res;
    }

    /**
     * Auto generated method signature
     *
     * @param max4
     * @return maxResponse5
     */
    public interfaces.MaxResponse max(interfaces.Max max4)
    {
    	System.out.println( "max called" );
      	 
        int a = max4.getArgs0();
        int b = max4.getArgs1();
        
        int max = a > b ? a : b;
        
        MaxResponse res = new MaxResponse();
        res.set_return( max );
        
        return res;
    }

    /**
     * Auto generated method signature
     *
     * @param isLeap6
     * @return isLeapResponse7
     */
    public interfaces.IsLeapResponse isLeap(interfaces.IsLeap isLeap6) {
    	System.out.println( "isLeap called" );
    	
    	int original = isLeap6.getArgs0();
    	interfaces.IsLeapResponse res = new interfaces.IsLeapResponse();
    	
    	if (original % 4 != 0) 
    		{
    	    res.set_return(false);
    	    return res;
    		} 
    	else if (original % 400 == 0) 
    		{
    		  res.set_return(true);
    		  return res;
    	  	} 
    	else if (original % 100 == 0) 
    	  	{
    		  res.set_return(false);
    		  return res;
    	  	} 
    	else 
    		{
    		  res.set_return(true);
    		  return res;
    		}
    }

    /**
     * Auto generated method signature
     *
     * @param avg8
     * @return avgResponse9
     */
    public interfaces.AvgResponse avg(interfaces.Avg avg8) {
    	System.out.println( "avarage called" );
    	int a = avg8.getArgs0();
    	int b = avg8.getArgs1();
    	
    	int result = (a+b)/2;
    	interfaces.AvgResponse res = new interfaces.AvgResponse();
    	res.set_return(result);
    	return res;
    }
}
