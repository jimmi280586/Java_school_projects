package database_codes.assignment1_01_dreamhome.com.dreamhome.dal;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lease;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lessee;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;

public class FileManager implements PersistenceLayer {
	
	private final String filePrefixPath = "D:\\src\\relational_databases\\DreamHome\\";
	private final String apartmentFileName = filePrefixPath + "db\\dreamhome\\apartmentFile.db";
	private final String ownerFileName = filePrefixPath + "db/dreamhome/ownerFile.db";
	private final String lesseeFileName = filePrefixPath + "db/dreamhome/lesseeFile.db";
	private final String leaseFileName = filePrefixPath + "db/dreamhome/leaseFile.db";

	public FileManager() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Owner getOwner(int ownerId) {
		ArrayList<Owner> ol = getOwnerList();
		Iterator<Owner> ownerIter = ol.iterator();
		Owner foundowner = null;
		while (ownerIter.hasNext()) {
			Owner o2 = ownerIter.next();
			if (ownerId == o2.getOwnerNo()) {
				foundowner = o2;
				break;
			}
		}
		return foundowner;
	}

	@Override
	public Boolean saveOwner(Owner o) {
		Owner foundOwner = getOwner(o.getOwnerNo());

		if (foundOwner == null) {
			ArrayList<Owner> ol = getOwnerList();
			ol.add(o);
			return saveOwnerList(ol);
		}
		else {
			System.out.println("Owner " + o.getOwnerNo() + " has already been registered");
			return false;
		}

	}

	@Override
	public Apartment getApartment(int apartmentId) {
		ArrayList<Apartment> al = getApartmentList();
		Iterator<Apartment> apartmentIter = al.iterator();
		Apartment foundApartment = null;
		while (apartmentIter.hasNext()) {
			Apartment a2 = apartmentIter.next();
			if (apartmentId == a2.getApartmentNo()) {
				foundApartment = a2;
				break;
			}
		}
		return foundApartment;
	}

	@Override
	public Boolean saveApartment(Apartment a) {
		Apartment foundApartment = getApartment (a.getApartmentNo());

		if (foundApartment == null) {
			ArrayList<Apartment> al = getApartmentList();
			al.add(a);
			return saveApartmentList(al);
		}
		else {
			System.out.println("Apartment " + a.getApartmentNo() + " has already been registered");
			return false;
		}

	}

	@Override
	public Lessee getLessee(int lesseeId) {
		ArrayList<Lessee> ll = getLesseeList();
		Iterator<Lessee> lesseeIter = ll.iterator();
		Lessee foundlessee = null;
		while (lesseeIter.hasNext()) {
			Lessee l2 = lesseeIter.next();
			if (lesseeId == l2.getLesseeId()) {
				foundlessee = l2;
				break;
			}
		}
		return foundlessee;
	}

	@Override
	public Boolean saveLessee(Lessee l) {
		Lessee foundLessee = getLessee (l.getLesseeId());

		if (foundLessee == null) {
			ArrayList<Lessee> al = getLesseeList();
			al.add(l);
			return saveLesseeList(al);
		}
		else {
			System.out.println("Lessee " + l.getLesseeId() + " has already been registered");
			return false;
		}

	}

	@Override
	public Lease getLease(int apartmentNo, LocalDateTime leaseFromDate) {
		ArrayList<Lease> ol = getLeaseList();
		Iterator<Lease> LeaseIter = ol.iterator();
		Lease foundLease = null;
		while (LeaseIter.hasNext()) {
			Lease l2 = LeaseIter.next();
			if ((apartmentNo == l2.getApartmentNo()) && (leaseFromDate.equals(l2.getLeaseFrom()))) {
				foundLease = l2;
				break;
			}
		}
		return foundLease;
	}

	@Override
	public Boolean saveLease(Lease l) {
		// Now, check that the apartment exists:
		Apartment a1 = getApartment(l.getApartmentNo());
		if (a1 == null) {
			System.out.println("Cannot create lease for non-existing apartment " + l.getApartmentNo());
			return false;
		}
		// Now, check that the lessee exists:
		Lessee l1 = getLessee (l.getLesseeId());
		if (l1 == null) {
			System.out.println("Cannot create lease for non-existing lessee " + l.getLesseeId());
			return false;			
		}
		// Now, check that this lease does not already exist 
		// First, get the current lease list:
		ArrayList<Lease> ll = getLeaseList();
		Lease foundLease = getLease (l.getApartmentNo(), l.getLeaseFrom());
		if (foundLease == null) {
			ll.add(l);
			return saveLeaseList(ll);
		}
		else {
			// Seems that the apartment is rented out to someone else (or re-rented). So we need to do two things:
			// 1. Terminate the old lease
			System.out.println("Lease for apartment " + l.getApartmentNo() + " and lessee with id " +
					l.getLesseeId() + " has already been registered");
			
			ll.remove(foundLease);
			ll.add(new Lease(foundLease.getApartmentNo(), foundLease.getLeaseFrom(),  LocalDateTime.now(),
					foundLease.getPrice(), foundLease.getLesseeId()));
			// 2. Create a new lease:					
			Lease newLease = new Lease(l.getApartmentNo(), l.getLeaseFrom(), null, l.getPrice(), l.getLesseeId());
			ll.add(newLease);
			

			return false;
		}

	}

	@Override
	public ArrayList<Apartment> getApartmentList() {
		
		ArrayList<Apartment> objList = new ArrayList<Apartment>();
		
		ObjectInputStream fileIn = null;
		
		try {
			FileInputStream streamIn = new FileInputStream(apartmentFileName);
			fileIn = new ObjectInputStream(streamIn);
			
			while (true)
			{
				try {
					objList.add((Apartment) fileIn.readObject());
				}
				catch(EOFException eof)
				{
					break;
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fileIn != null) {
				try {
					fileIn.close();
					// System.out.println("File '" + apartmentFileName + "' has been closed");
				}
				catch (IOException e) {
					System.err.println("Error closing file: " + apartmentFileName);
				}
			} 

		}
		return objList;
	}

	@Override
	public ArrayList<Owner> getOwnerList() {
		ArrayList<Owner> objList = new ArrayList<Owner>();
		
		ObjectInputStream fileIn = null;
		
		try {
			FileInputStream streamIn = new FileInputStream(ownerFileName);
			fileIn = new ObjectInputStream(streamIn);
			
			while (true)
			{
				try {
					objList.add((Owner) fileIn.readObject());
				}
				catch(EOFException eof)
				{
					break;
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fileIn != null) {
				try {
					fileIn.close();
					//System.out.println("File '" + ownerFileName + "' has been closed");
				}
				catch (IOException e) {
					System.err.println("Error closing file: " + ownerFileName);
				}
			} 

		}
		return objList;
	}

	@Override
	public ArrayList<Lessee> getLesseeList() {
		ArrayList<Lessee> objList = new ArrayList<Lessee>();
		
		ObjectInputStream fileIn = null;
		
		try {
			FileInputStream streamIn = new FileInputStream(lesseeFileName);
			fileIn = new ObjectInputStream(streamIn);
			
			while (true)
			{
				try {
					objList.add((Lessee) fileIn.readObject());
				}
				catch(EOFException eof)
				{
					break;
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fileIn != null) {
				try {
					fileIn.close();
					//System.out.println("File '" + LesseeFileName + "' has been closed");
				}
				catch (IOException e) {
					System.err.println("Error closing file: " + lesseeFileName);
				}
			} 

		}
		return objList;
	}

	@Override
	public ArrayList<Lease> getLeaseList() {
		ArrayList<Lease> objList = new ArrayList<Lease>();
		
		ObjectInputStream fileIn = null;
		
		try {
			FileInputStream streamIn = new FileInputStream(leaseFileName);
			fileIn = new ObjectInputStream(streamIn);
			
			while (true)
			{
				try {
					objList.add((Lease) fileIn.readObject());
				}
				catch(EOFException eof)
				{
					break;
				}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fileIn != null) {
				try {
					fileIn.close();
					//System.out.println("File '" + leaseFileName + "' has been closed");
				}
				catch (IOException e) {
					System.err.println("Error closing file: " + leaseFileName);
				}
			} 

		}
		return objList;
	}

	@Override
	public Boolean saveApartmentList(ArrayList<Apartment> al) {
		
		ObjectOutputStream fileOut = null;
		
		try {
			FileOutputStream streamOut = new FileOutputStream(apartmentFileName, false);
			fileOut = new ObjectOutputStream(streamOut);
			Iterator<Apartment> apartmentIter = al.iterator(); 
		    while (apartmentIter.hasNext()){ 
		    	Apartment apartment = apartmentIter.next();
		    	// System.out.println(apartment.toString());
				fileOut.writeObject(apartment);
		    }
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fileOut != null)	{
				try {
					
					fileOut.close();
					return true;
				}
				catch (IOException e)
				{
					System.err.println("File could not be closed.");
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean saveOwnerList(ArrayList<Owner> ol) {
		ObjectOutputStream fileOut = null;
		
		try {
			FileOutputStream streamOut = new FileOutputStream(ownerFileName, false);
			fileOut = new ObjectOutputStream(streamOut);
			Iterator<Owner> ownerIter = ol.iterator(); 
		    while (ownerIter.hasNext()){ 
		    	Owner owner = ownerIter.next();
		    	// System.out.println(owner.toString());
				fileOut.writeObject(owner);
		    }
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fileOut != null)	{
				try {
					
					fileOut.close();
					return true;
				}
				catch (IOException e)
				{
					System.err.println("File could not be closed.");
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean saveLesseeList(ArrayList<Lessee> ll) {
		ObjectOutputStream fileOut = null;
		
		try {
			FileOutputStream streamOut = new FileOutputStream(lesseeFileName, false);
			fileOut = new ObjectOutputStream(streamOut);
			Iterator<Lessee> lesseeIter = ll.iterator(); 
		    while (lesseeIter.hasNext()){ 
		    	Lessee lessee = lesseeIter.next();
		    	// System.out.println(lessee.toString());
				fileOut.writeObject(lessee);
		    }
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fileOut != null)	{
				try {
					
					fileOut.close();
					return true;
				}
				catch (IOException e)
				{
					System.err.println("File could not be closed.");
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean saveLeaseList(ArrayList<Lease> ll) {
		ObjectOutputStream fileOut = null;
		
		try {
			FileOutputStream streamOut = new FileOutputStream(leaseFileName, false);
			fileOut = new ObjectOutputStream(streamOut);
			Iterator<Lease> leaseIter = ll.iterator(); 
		    while (leaseIter.hasNext()){ 
		    	Lease lease = leaseIter.next();
		    	// System.out.println(lease.toString());
				fileOut.writeObject(lease);
		    }
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fileOut != null)	{
				try {
					
					fileOut.close();
					return true;
				}
				catch (IOException e)
				{
					System.err.println("File could not be closed.");
					return false;
				}
			}
		}
		return false;
	}

}
