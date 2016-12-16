package exercise1_dreamhouse;

import javax.swing.JFrame;

import database_codes.assignment1_01_dreamhome.com.dreamhome.dal.DBManager;
import database_codes.assignment1_01_dreamhome.com.dreamhome.logic.LogicLayer;
import database_codes.assignment1_01_dreamhome.com.dreamhome.logic.LogicLayerDB;
import database_codes.assignment1_01_dreamhome.com.dreamhome.logic.LogicLayerFile;
import database_codes.assignment1_01_dreamhome.com.dreamhome.presentation.ApartmentOverview;


public class DreamHome {

	public DreamHome() {
	}

	public static void main(String[] args) {
		
		LogicLayer ll = new LogicLayerDB();
		ApartmentOverview ao = new ApartmentOverview();
		
		ao.setLogicLayerInterface(ll);
		
		ao.showApartmentsAndOwners();
		
		ao.setVisible(true);
		ao.setTitle("Dream Home Booking System");
		ao.setSize(400, 200);
		ao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
