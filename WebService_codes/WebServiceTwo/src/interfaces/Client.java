package interfaces;

import interfaces.stub.WS2Stub;

public class Client
{
	private static final String URL = "http://localhost:8080/axis2/services/WS2";
	
	
	public static void main( String[] args )
		throws Exception
	{
		WS2Stub stub = new WS2Stub( URL );
		
		WS2Stub.Reverse call0 = new WS2Stub.Reverse();
		call0.setArgs0( "webservice" );
		WS2Stub.ReverseResponse res0 = stub.reverse( call0 );
		
		System.out.println( "Reverse: " + res0.get_return() );
		
		WS2Stub.Vat call = new WS2Stub.Vat();
		call.setArgs0( 100.0 );
		System.out.println(call.getArgs0());
		WS2Stub.VatResponse res1 = stub.vat( call );
		
		System.out.println( "VAT of 100.0 is " + res1.get_return() );
		
		WS2Stub.Max call2 = new WS2Stub.Max();
		call2.setArgs0( 27 );
		call2.setArgs1( 51 );
		WS2Stub.MaxResponse res2 = stub.max( call2 );
		
		System.out.println( "Max: " + res2.get_return() );
		
		WS2Stub.IsLeap call3 = new WS2Stub.IsLeap();
		call3.setArgs0( 2020 );
		System.out.println(call3.getArgs0());
		WS2Stub.IsLeapResponse res3 = stub.isLeap( call3 );
		
		System.out.println( "is the year a leap year " + res3.get_return() );
		
		WS2Stub.Avg call4 = new WS2Stub.Avg();
		call4.setArgs0( 4 );
		call4.setArgs1( 8 );
		System.out.println(call4.getArgs0());
		System.out.println(call4.getArgs1());
		WS2Stub.AvgResponse res4 = stub.avg( call4 );
		
		System.out.println( "avarage is " + res4.get_return() );
	}
}
