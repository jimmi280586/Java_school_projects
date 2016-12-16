package database_codes.assignment1_01_dreamhome.com.dreamhome.logic;

import database_codes.assignment1_01_dreamhome.com.dreamhome.dal.FileManager;

public class LogicLayerFile extends LogicLayer {

	public LogicLayerFile() {
		super();
		// TODO Auto-generated constructor stub
		super.setPersistenceLayer(new FileManager());
	}
}
