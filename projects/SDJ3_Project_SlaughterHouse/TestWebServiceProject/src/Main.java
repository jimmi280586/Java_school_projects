import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import webservice.stub.IJSimpCalcWebServiceStub;

public class Main {

	public static void main(String[] args) throws RemoteException 
	{
		String URL = "http://localhost:8080/axis2/services/IJSimpCalcWebService";
		
		IJSimpCalcWebServiceStub stub = new IJSimpCalcWebServiceStub(URL);
		IJSimpCalcWebServiceStub.Addition par = new IJSimpCalcWebServiceStub.Addition();
		IJSimpCalcWebServiceStub.AdditionResponse res = stub.addition(par);
		
		System.out.println( "Received: " + res.get_return() );
	}

}
