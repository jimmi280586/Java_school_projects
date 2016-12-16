package database_codes.assignment1_01_dreamhome.com.dreamhome.presentation;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database_codes.assignment1_01_dreamhome.com.dreamhome.logic.LogicLayerInterface;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Apartment;
import database_codes.assignment1_01_dreamhome.com.dreamhome.model.Owner;

public class ApartmentOverview extends JFrame {

	/**
	 * 
	 */
	LogicLayerInterface logicLayerInterface = null;
	
	
	private static final long serialVersionUID = 1L;

	public ApartmentOverview() throws HeadlessException {
		// TODO Auto-generated constructor stub	
	}

	public ApartmentOverview(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public ApartmentOverview(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ApartmentOverview(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ll the ll to set
	 */
	public void setLogicLayerInterface(LogicLayerInterface ll) {
		this.logicLayerInterface = ll;
	}
	
	public void showApartmentsAndOwners() {
		String text = "ID" + '\t' + "Address" + '\t' + '\t' + '\t' + '\t' + "Owner" + '\n';
		ArrayList<Apartment> allApartments = logicLayerInterface.getApartmentList();
		Iterator<Apartment> apartmentIter = allApartments.iterator();
		while (apartmentIter.hasNext()) {
			Apartment a = apartmentIter.next();
			Owner o = logicLayerInterface.getOwner(a.getOwnerNo());
			String line = "  " + a.getApartmentNo() + '\t' + a.getAddress() + '\t' + '\t' + o.getOwnerName() + '\n';
			text = text + line;
		}		
		
		JTextArea l = new JTextArea(text);
		this.add(l);
	}
}
