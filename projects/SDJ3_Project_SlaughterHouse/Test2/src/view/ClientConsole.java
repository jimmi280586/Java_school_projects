package view;

import java.util.Scanner;

import model.*;
import controller.*;

public class ClientConsole implements View {
	private Scanner input;

	public ClientConsole() {
		input = new Scanner(System.in);
	}

	private int consoleMenu() {
		show("-------------- Client Menu -------------");
		show("\t1. Get all animals");
		show("\t2. Get all parts");
		show("\t3. Get all trays");
		show("\t4. Get all products");
		show("\t5. Get all markets");
		show("\t6. Register animal");
		show("\t7. Tranport product to market");
		show("\t8. Track animal");
		show("\t9. Pack product");
		show("\t10. Register Animal Part");
		show("\t11. Register Tray");
		show("\t12. Put parts into Tray");
		show("\t0. quit");
		show("-----------------------------------------");
		show("* Type in your choice");
		System.out.print("> ");
		int choice= input.nextInt();

		return choice;
	}
	
	public void start(Controller controller) {
		int choice;
	      do
	      {
	         choice=consoleMenu();
	         show("\n");
	         
	         switch(choice)
	         {
	         case 1: 
		            controller.execute("getAllAnimals");
		            break;
	         case 2: 
		            controller.execute("getAllParts");
		            break;
	         case 3: 
		            controller.execute("getAllTrays");
		            break;
	         case 4: 
		            controller.execute("getAllProducts");
		            break;
	         case 5: 
		            controller.execute("getAllMarkets");
		            break;
	         case 6: 
		            controller.execute("addAnimal");
		            break;
	         case 7: 
		            controller.execute("transportProducts");
		            break;
	         case 8: 
		            controller.execute("trackProducts");
		            break;
	         case 9: 
		            controller.execute("packProduct");
		            break;
	         case 10: 
		            controller.execute("addAnimalPart"); 
		            break;
	         case 11: 
		            controller.execute("addTray"); //d
		            break;
	         case 12: 
		            controller.execute("putToTray"); //d
		            break;
	         default:
	             show("Shutting down");
	             choice=-1;
	         }
	         
	         show("\nPress any key to continue...");
	         try
	         {
	             System.in.read();
	         }  
	         catch(Exception e)
	         {}  
	         
	      } while(choice!=-1);
	}
	
	public void show(String message) {
		System.out.println(message);
	}

	@Override
	public void showAllAnimals(Animal[] animals) {
		String result = "All animals:";
		
		for (Animal animal : animals) {
			result += "\n[ID:" + animal.getAnimalId() + ", Type:" + animal.getType() + ", Weight:" + animal.getWeight() + "]";
		}
		
		show(result);
	}

	@Override
	public void showAllParts(Part[] parts) {
		String result = "All parts:";
		
		for (Part part : parts) {
			result += "\n[ID:" + part.getPartId() + ", AnimalID:" + part.getAnimalId() + ", Type:" + part.getType() + ", Weight:" + part.getWeight() + "]";
		}
		
		show(result);
	}

	@Override
	public void showAllTrays(Tray[] trays) {
		String result = "All trays:";
		
		for (Tray tray : trays) {
			result += "\n[ID:" + tray.getTrayId() + ", Type:" + tray.getType() + ", Max Weight:" + tray.getMaxWeight() + ", Current Weight:" + tray.getCurrentWeight() + "]";
		}
		
		show(result);
	}

	@Override
	public void showAllProducts(Product[] products) {
		String result = "All products:";
		
		for (Product product : products) {
			result += "\n[ID:" + product.getProductId() + ", Type:" + product.getType() + ", Weight:" + product.getWeight() + "]";
		}
		
		show(result);
	}

	@Override
	public void showAllMarkets(Market[] markets) {
		String result = "All markets:";
		
		for (Market market : markets) {
			result += "\n[ID:" + market.getMarketId() + ", Address:" + market.getAddress() + "]";
		}
		
		show(result);
	}

	@Override
	public String get(String whatToGet) {
		show("Write " + whatToGet);
		input.nextLine();
		String result = input.nextLine();
		
		return result;
	}
	@Override
	public String get2(String whatToGet) {
		show("Write " + whatToGet);
		String result = input.nextLine();
		
		return result;
	}
	
}
