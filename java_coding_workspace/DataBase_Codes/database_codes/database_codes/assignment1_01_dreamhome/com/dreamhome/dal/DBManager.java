package database_codes.assignment1_01_dreamhome.com.dreamhome.dal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;


import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lease;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lessee;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;

public class DBManager implements PersistenceLayer {

	private static String host = "localhost";
	private static int port = 3306;
	private static String user = "root";

	Connection connection = null;
	
	public DBManager(String databaseName) {
		connect(databaseName);
	}

	public void connect(String databaseName) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		}
    	catch(ClassNotFoundException cnfe) {
    		System.err.println("Error loading driver: " + cnfe);
    	} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
    		String url = "jdbc:mysql://"+ host + ":" + port;
    		System.out.println("Trying to establish connection to DB " + databaseName + " at " + url);
			connection = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port , user, "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		DatabaseMetaData dbMetaData;
		try {
			dbMetaData = connection.getMetaData();
			String productName = dbMetaData.getDatabaseProductName();
			System.out.println("Database: " + productName);
			String productVersion =	dbMetaData.getDatabaseProductVersion();
			System.out.println("Product version: " + productVersion);
			System.out.println("Connection established!");
			connection.setCatalog(databaseName);
			System.out.println("Found database " + databaseName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
		    stmt = (Statement) connection.createStatement();
		    rs = stmt.executeQuery("use hoteldb");
		    
		    rs = stmt.executeQuery("SELECT hotelno FROM hoteldb.booking");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

		    if (stmt.execute("SELECT * FROM hoteldb.booking")) {
		        rs = stmt.getResultSet();
		        while (rs.next()) {
		        	System.out.println("HotelId: " + rs.getInt("hotelNo") 
		        			+ " GuestID: " + rs.getInt("guestNo")
		        			+ " RoomNo: " + rs.getInt("roomNo")
		        			+ " From date: " + rs.getDate("dateFrom")); 
		        }
		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        }
		        catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
	}
	
	@Override
	public Owner getOwner(int ownerId) {
		// TODO Complete this method
		try {
			// Fix the prepared statement to match your database
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM owner WHERE ownerno = ?");
			stmt.setInt(1, ownerId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Owner o = new Owner(rs.getInt("OwnerNo"), rs.getString("OwnerName"));
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Apartment getApartment(int apartmentId) {
		try {
			// Fix the prepared statement to match your database
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM apartment WHERE apartNo = ?");
			stmt.setInt(1, apartmentId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Apartment a = new Apartment(rs.getInt("apartNo"), rs.getString("address"), rs.getInt("ownerNo"));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Lessee getLessee(int lesseeId) {
		// TODO Auto-generated method stub
		
		try {
			// Fix the prepared statement to match your database
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM owner WHERE apartNo = ?");
			stmt.setInt(1, lesseeId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Lessee o = new Lessee(rs.getInt("apartNo"), rs.getString("address"));
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public Lease getLease(int apartmentNo, LocalDateTime leaseFromDate) {
		// TODO Auto-generated method stub
		
		try {
			// Fix the prepared statement to match your database
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM owner WHERE apartmentno = ?");
			stmt.setInt(1, apartmentNo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Lease o = new Lease();
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Boolean saveOwner(Owner o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveApartment(Apartment a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveLessee(Lessee l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveLease(Lease l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Owner> getOwnerList() {
		
		// TODO Complete this method
		try {
			// Fix the prepared statement to match your database
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM owner");
			
			ArrayList<Owner> o = new ArrayList<Owner>();
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
			{
				o.add(new Owner(rs.getInt("ownerNo"), rs.getString("ownerName")));
				  
			}  
			return o;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Apartment> getApartmentList() 
	{
		// TODO Complete this method
		try
		{
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM apartment");
			
			ArrayList<Apartment> a = new ArrayList<Apartment>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				a.add(new Apartment(rs.getInt("apartNo"), rs.getString("address"), rs.getInt("ownerNo")));
			}
			return a;
		} catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Lessee> getLesseeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lease> getLeaseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveApartmentList(ArrayList<Apartment> al) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveOwnerList(ArrayList<Owner> ol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveLesseeList(ArrayList<Lessee> ll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveLeaseList(ArrayList<Lease> ll) {
		// TODO Auto-generated method stub
		return null;
	}

}
