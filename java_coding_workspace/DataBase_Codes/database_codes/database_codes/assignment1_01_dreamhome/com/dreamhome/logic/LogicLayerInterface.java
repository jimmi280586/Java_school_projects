package database_codes.assignment1_01_dreamhome.com.dreamhome.logic;

import java.time.LocalDateTime;
import java.util.ArrayList;

import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lease;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lessee;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;

public interface LogicLayerInterface {

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
}
