package database_codes.assignment1_01_dreamhome.com.dreamhome.dal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lease;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lessee;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;

public interface PersistenceLayer {
	
	public Owner getOwner (int ownerId);
	
	public Boolean saveOwner (Owner o);
	
	public Apartment getApartment (int apartmentId);
	
	public Boolean saveApartment (Apartment a);
	
	public Lessee getLessee (int lesseeId);
	
	public Boolean saveLessee (Lessee l);
	
	public Lease getLease(int apartmentNo, LocalDateTime leaseFromDate);
	
	public Boolean saveLease (Lease l);
	
	public ArrayList<Apartment> getApartmentList();
	
	public ArrayList<Owner> getOwnerList();
	
	public ArrayList<Lessee> getLesseeList();
	
	public ArrayList<Lease> getLeaseList();
	
	public Boolean saveApartmentList(ArrayList<Apartment> al);
	
	public Boolean saveOwnerList(ArrayList<Owner> ol);
	
	public Boolean saveLesseeList(ArrayList<Lessee> ll);
	
	public Boolean saveLeaseList(ArrayList<Lease> ll);

}
