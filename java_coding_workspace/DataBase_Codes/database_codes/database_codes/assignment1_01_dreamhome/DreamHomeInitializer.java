package database_codes.assignment1_01_dreamhome;

import java.time.LocalDateTime;

import database_codes.assignment1_01_dreamhome.com.dreamhome.dal.FileManager;
import database_codes.assignment1_01_dreamhome.com.dreamhome.dal.PersistenceLayer;
import database_codes.assignment1_01_dreamhome.com.dreamhome.logic.LogicLayer;
import database_codes.assignment1_01_dreamhome.com.dreamhome.logic.LogicLayerFile;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lease;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Lessee;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;
import database_codes.assignment1_01_dreamhome.com.dreamhome.presentation.*;

public class DreamHomeInitializer {
	
	public DreamHomeInitializer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		LogicLayer ll = new LogicLayerFile();
		
		Apartment a1 = new Apartment(1, "Bøghsgade 1, 8700 Horsens", 1);
		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");

		Owner o1 = new Owner(1, "Jesper Hansen");
		if (ll.saveOwner(o1))
			System.out.println("Owner information updated!");
		else
			System.out.println("Failed to update Owner information!");

		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");
		
		a1 = new Apartment (1, "Bøgevangs Tværvej 1, 8700 Horsens", 1);
		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");
		
		a1 = new Apartment (2, "Bøgevangs Tværvej 1, 8700 Horsens", 2);
		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");		

		o1 = new Owner(2, "Hans Jespersen");
		if (ll.saveOwner(o1))
			System.out.println("Owner information updated!");
		else
			System.out.println("Failed to update Owner information!");
		
		a1 = new Apartment (2, "Bøgevangs Tværvej 1, 8700 Horsens", 2);
		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");	

		a1 = new Apartment (3, "Bøgevangs Tværvej 3, 8700 Horsens", 2);
		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");		

		a1 = new Apartment (4, "Hans Grethes Vej 77, 8700 Horsens", 1);
		if (ll.saveApartment(a1))
			System.out.println("Apartment information updated!");
		else
			System.out.println("Failed to update apartment information!");		

		return;
			
			/*					
			LocalDateTime t1 = LocalDateTime.now();
			LocalDateTime t2 = LocalDateTime.now();
			LocalDateTime t3 = LocalDateTime.of(t1.getYear(), t1.getMonth(), t1.getDayOfMonth(), t1.getHour(), t1.getMinute(), t1.getSecond(), t1.getNano());

			if (t1.equals(t2))
				System.out.println ("Dates t1 and t2 are identical!");
			if (t1.equals(t3))
				System.out.println ("Dates t1 and t3 are identical!");
						
			Lessee le1 = new Lessee(1, "Jesper Grode");
			if (ll.saveLessee(le1))
				System.out.println("Lessee information updated!");
			else
				System.out.println("Failed to update Lessee information!");
			
				
			// Non-existing apartment:
			Lease l1 = new Lease(4, LocalDateTime.now(), null, 100, 1);
			if (ll.saveLease(l1))
				System.out.println("Lease information updated!");
			else
				System.out.println("Failed to update Lease information!");
			
			// Non-existing lessee:
			l1 = new Lease (1,  LocalDateTime.now(), null, 200, 2);
			if (ll.saveLease(l1))
				System.out.println("Lease information updated!");
			else
				System.out.println("Failed to update Lease information!");
		
			// Create a real lease:
			l1 = new Lease (1,  LocalDateTime.now(), null, 200, 1);
			if (ll.saveLease(l1))
				System.out.println("Lease information updated!");
			else
				System.out.println("Failed to update Lease information!");
			
			// Check if we can find this lease again:
			if (ll.getLease(l1.getApartmentNo(), l1.getLeaseFrom()) != null)
				System.out.println("Found the lease again!!");
			else
				System.out.println("Could not find the lease!");
			
			Lease l2 = new Lease(l1.getApartmentNo(), l1.getLeaseFrom(), l1.getLeaseTo(),
					l1.getPrice(), l1.getLesseeId());
			if (ll.saveLease(l2))
				System.out.println("Lease information updated!");
			else
				System.out.println("Failed to update Lease information!");
			
				
			*/
	}
}
