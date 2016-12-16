package database_codes.assignment1_01_dreamhome.com.dreamhome.logic;

import database_codes.assignment1_01_dreamhome.com.dreamhome.dal.DBManager;

public class LogicLayerDB extends LogicLayer {

	public LogicLayerDB() {
		super();
		DBManager m = new DBManager("dreamhome");
		super.setPersistenceLayer(m);
	}
}
