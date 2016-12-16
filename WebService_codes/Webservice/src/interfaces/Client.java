package interfaces;

import interfaces.stub.*;

public class Client {

	public static void main(String[] args) throws Exception {
		String address = "http://localhost:8080/axis2/services/Hello";
		interfaces.stub.HelloStub stub = new interfaces.stub.HelloStub(address);
		
		HelloStub.GetHelloText param = new HelloStub.GetHelloText();
		
		HelloStub.GetHelloTextResponse res = stub.getHelloText(param);
		
		System.out.println("Result: " + res.get_return());
	}
}