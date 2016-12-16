package view;

import controller.Controller;
import model.*;

public interface View {

	public void start(Controller controller);
	public void show(String message);

	public void showAllAnimals(Animal[] animals);
	public void showAllParts(Part[] parts);
	public void showAllTrays(Tray[] trays);
	public void showAllProducts(Product[] products);
	public void showAllMarkets(Market[] markets);
	
	public String get(String whatToGet);
	public String get2(String whatToGet);
}
