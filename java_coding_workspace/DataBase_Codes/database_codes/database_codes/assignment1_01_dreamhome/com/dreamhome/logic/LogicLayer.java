package database_codes.assignment1_01_dreamhome.com.dreamhome.logic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import database_codes.assignment1_01_dreamhome.com.dreamhome.dal.PersistenceLayer;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lease;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lessee;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;

public abstract class LogicLayer implements LogicLayerInterface {

	private PersistenceLayer persistenceLayer = null;
	
	protected PersistenceLayer getPersistenceLayer() {
		return persistenceLayer;
	}

	/**
	 * @param persistenceLayer the persistenceLayer to set
	 */
	protected void setPersistenceLayer(PersistenceLayer persistenceLayer) {
		this.persistenceLayer = persistenceLayer;
	}
	
	
	@Override	
	public Owner getOwner(int ownerId) {
		return persistenceLayer.getOwner(ownerId);
	}
	
	@Override
	public Boolean saveOwner(Owner o) {
		// TODO Auto-generated method stub
		return getPersistenceLayer().saveOwner(o);
	}

	@Override
	public Apartment getApartment(int apartmentId) {
		// TODO Auto-generated method stub
		return getPersistenceLayer().getApartment(apartmentId);
	}

	@Override
	public Boolean saveApartment(Apartment a) {
		// Verify that owner exist:
		if (getPersistenceLayer().getOwner(a.getOwnerNo()) != null)
			return getPersistenceLayer().saveApartment(a);
		else {
			System.out.println("Cannot save apartment " + a.getApartmentNo() + " as owner with Id "
					+ a.getOwnerNo() + " does not exist");
			return false;
		}
	}

	@Override
	public Lessee getLessee(int lesseeId) {
		return getPersistenceLayer().getLessee(lesseeId);
	}

	@Override
	public Boolean saveLessee(Lessee l) {
		return getPersistenceLayer().saveLessee(l);
	}

	@Override
	public Lease getLease(int apartmentNo, LocalDateTime leaseFromDate) {
		return getPersistenceLayer().getLease(apartmentNo, leaseFromDate);
	}

	@Override
	public Boolean saveLease(Lease l) {
		return getPersistenceLayer().saveLease(l);
	}
	
	public Owner getOwnerOfApartment(int apartmentId) {
		ArrayList<Apartment> al = persistenceLayer.getApartmentList();
		ArrayList<Owner> ol = persistenceLayer.getOwnerList();
		int ownerId = -1;
		Iterator<Apartment> apartmentIter = al.iterator();
		while (apartmentIter.hasNext()) {
			Apartment a = apartmentIter.next();
			if (a.getApartmentNo() == apartmentId)
				ownerId = a.getOwnerNo();
			break;
		}
		Iterator<Owner> ownerIter = ol.iterator();
		while (ownerIter.hasNext()) {
			Owner o = ownerIter.next();
			if (o.getOwnerNo() == ownerId)
				return o;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dreamhome.logic.LogicLayerInterface#getApartmentList()
	 */
	@Override
	public ArrayList<Apartment> getApartmentList() {
		return persistenceLayer.getApartmentList();
	}

	/* (non-Javadoc)
	 * @see com.dreamhome.logic.LogicLayerInterface#getOwnerList()
	 */
	@Override
	public ArrayList<Owner> getOwnerList() {
		return persistenceLayer.getOwnerList();
	}

	/* (non-Javadoc)
	 * @see com.dreamhome.logic.LogicLayerInterface#getLesseeList()
	 */
	@Override
	public ArrayList<Lessee> getLesseeList() {
		return persistenceLayer.getLesseeList();
	}

	/* (non-Javadoc)
	 * @see com.dreamhome.logic.LogicLayerInterface#getLeaseList()
	 */
	@Override
	public ArrayList<Lease> getLeaseList() {
		return persistenceLayer.getLeaseList();
	}

	/**
	 * @return the persistenceLayer
	 */
}
