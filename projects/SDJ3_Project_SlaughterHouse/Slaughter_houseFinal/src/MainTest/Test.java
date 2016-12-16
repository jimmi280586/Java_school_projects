package MainTest;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;

import java_t2.Data.Animal;
import java_t2.Data.Part;
import java_t3.Server.IServer;
import java_t3.Server.ServerRMIDB;

import java_t3.adapterDB.AdapterDatabase2;
import java_t3.adapterDB.IAdapterDatabase;

public class Test {

	public static void main(String[] args) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
	    Connection connection;
		IServer server =new ServerRMIDB();
		AdapterDatabase2 db = new AdapterDatabase2( "postgres", "1234");
		connection = db.openDatabase();
	
		//Animal animal = new Animal("pig",198720);
		Part part = new Part("12892","legs",40);
		
		//server.saveAnimal(animal);
	//	db.storageAnimal(animal);
		db.storagePart(part);
	
//		
//		db.storageAnimal("1234", "cow", 233333);
//		db.storageAnimal("5555", "pig", 9999);
//		db.storageAnimal("123456", "COW", 1111111);
	}

}
