package controller;

import java.util.ArrayList;

import model.*;
import view.*;
import servers.*;

public class ClientController implements Controller {
	private Model model;
	private View view;

	public ClientController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void execute(String what) {
		if (what.equals("getAllAnimals")) {
			getAllAnimals();
		} else if (what.equals("getAllParts")) {
			getAllParts();
		} else if (what.equals("getAllProducts")) {
			getAllProducts();
		} else if (what.equals("getAllTrays")) {
			getAllTrays();
		} else if (what.equals("getAllMarkets")) {
			getAllMarkets();
		} else if (what.equals("addAnimal")) {
			addAnimal();
		} else if (what.equals("transportProducts")) {
			transportProducts();
		} else if (what.equals("trackProducts")) {
			trackProducts();
		} else if (what.equals("packProduct")) {
			packProduct();
		} else if(what.equals("addAnimalPart")){
			addAnimalPart();
		} else if(what.equals("addTray")){
			addTray();
		} else if(what.equals("putToTray")){
			putToTray();
		}  else {
			// Do nothing
			view.show("Execution error");
		}
	}
	
	private void putToTray()
	{
		Tray[] trays = model.getAllTrays();
		view.showAllTrays(trays);
		
		int trayId = Integer.parseInt(view.get("which tray ID?"));
		Tray tray = null;
		
		for(int i = 0; i < trays.length; i++)
		{
			if(trays[i].getTrayId() == trayId)
			{
				tray = trays[i];
			}
		}

		view.show("The trays max weight is: " +tray.getMaxWeight());
		view.show("The trays current weight is: " +tray.getCurrentWeight() + "\n");
				
		Part[] parts = model.getAllParts();		
		ArrayList<Part> partsToShow = new ArrayList<>();
		
		boolean a = true;
		
		for (int k = 0; k < parts.length; k++) {
			
			a = true;
			
			for(int i = 0; i < trays.length; i++) {
				for(int j = 0; j < trays[i].getParts().size(); j++) {
					if (trays[i].getParts().get(j).getPartId() == parts[k].getPartId()) {
						a = false;
					}
				}
			}
			
			if (a) {
				partsToShow.add(parts[k]);
			}
		}
	
	
		Part[] newParts = new Part[partsToShow.size()];
		
		for (int i = 0; i < partsToShow.size(); i++) {
			newParts[i] = partsToShow.get(i);
		}
		
		
		view.showAllParts(newParts);
		int partId = Integer.parseInt(view.get2("part Id"));
		Part part = null;
		
		for (Part tempPart : newParts) {
			if (tempPart.getPartId() == partId) {
				part = tempPart;
			}
		}
		
		if ((tray.getCurrentWeight() + part.getWeight()) > tray.getMaxWeight() ) {
			view.show("Part is too big for this tray or the tray is full");
		} else {			
			view.show("" + model.addToTray(partId, trayId));
		}
	}
	
	private void addTray()
	{
		Part[] animals = model.getAllParts();
		view.showAllParts(animals);
		String type = view.get("type");
		Float maxWeight = Float.parseFloat(view.get2("max weight"));
		view.show("" + model.addTray(type, maxWeight));
	}
	
	private void addAnimalPart()
	{
		Animal[] animals = model.getAllAnimals();
		view.showAllAnimals(animals);
		int animalId = Integer.parseInt(view.get("animal Id"));
		Float weight = Float.parseFloat(view.get2("part weight"));
		String type = view.get2("partType");
		view.show("" + model.addPart(animalId, type, weight));
	}

	private void addAnimal() {
		Float weight = Float.parseFloat(view.get("weight"));
		String type = view.get2("type");

		view.show("" + model.addAnimal(weight, type));

	}

	private void getAllMarkets() {
		Market[] animals = model.getAllMarkets();
		view.showAllMarkets(animals);
	}

	private void getAllTrays() {
		Tray[] animals = model.getAllTrays();
		view.showAllTrays(animals);
	}

	private void getAllProducts() {
		Product[] animals = model.getAllProducts();
		view.showAllProducts(animals);
	}

	private void getAllParts() {
		Part[] animals = model.getAllParts();
		view.showAllParts(animals);

	}

	private void getAllAnimals() {
		Animal[] animals = model.getAllAnimals();
		view.showAllAnimals(animals);
	}

	private void transportProducts() {
		Product[] products = model.getAllProducts();
		Market[] markets = model.getAllMarkets();
		view.showAllProducts(products);
		int productId = Integer.parseInt(view.get("product id:"));
		view.showAllMarkets(markets);
		int marketId = Integer.parseInt(view.get2("market id:"));

		model.transportProductToMarket(productId, marketId);
	}

	private void trackProducts() {
		Animal[] animals = model.getAllAnimals();
//		Part[] parts = model.getAllParts();
//		Tray[] trays = model.getAllTrays();
		Product[] products = model.getAllProducts();
		ArrayList<Integer> productIds = new ArrayList<Integer>();
//		ArrayList<Integer> trayIds = new ArrayList<Integer>();

		view.showAllAnimals(animals);
		int animalId = Integer.parseInt(view.get("animal id:"));

//		// For getting bad trays
//		for (int i = 0; i < parts.length; i++) {
//			if (animalId == parts[i].getAnimalId()) {
//				for (int k = 0; k < trays.length; k++) {
//					for (int j = 0; j < trays[k].getParts().size(); j++) {
//						if (trays[k].getParts().get(j).getPartId() == parts[i].getPartId()) {
//							trayIds.add(trays[k].getTrayId());
//							break;
//						}
//					}
//				}
//				// partIds.add(parts[i].getPartId());
//			}
//		}

		for (int k = 0; k < products.length; k++) {
			for (int j = 0; j < products[k].getParts().size(); j++) {
				if (products[k].getParts().get(j).getAnimalId() == animalId) {
					productIds.add(products[k].getProductId());
					break;
				}
			}
		}
		view.show("Bad products:");
		for (int i = 0; i < productIds.size(); i++) {
			view.show("" + productIds.get(i));
		}
	}
	
	private void packProduct(){
		Tray[] trays = model.getAllTrays();
		String type = view.get("type:");
		Float weight = Float.parseFloat(view.get2("weight"));
		
		view.showAllTrays(trays);
		String trayIds = view.get2("tray id(if more than 1 use , to separate)");
		String[] split = trayIds.split("\\D\\s", -1);
		Tray[] usedTrays = new Tray[split.length];
		for(int i=0;i<split.length;i++){
			for(int j=0;j<trays.length;j++){
				if(Integer.parseInt(split[i]) == trays[j].getTrayId()){
					usedTrays[i] = trays[j];
					break;
				}
			}
		}
		model.packTraysToProduct(type, weight, usedTrays);
//		for(int i=0;i<split.length;i++){
//			view.show(split[i]);
//		}
//		view.show(type);
//		view.show("" + weight);
	}
}
