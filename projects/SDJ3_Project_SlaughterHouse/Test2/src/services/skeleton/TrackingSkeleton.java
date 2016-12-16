/**
 * TrackingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
package services.skeleton;

import java.rmi.RemoteException;
import java.util.ArrayList;

import model.xsd.Animal;
import model.xsd.Market;
import model.xsd.Product;
import servers.DatabaseServer;
import servers.DatabaseServerInterface;
import services.GetAnimalsResponse;
import services.TrackAnimalResponse;
import services.TrackProductResponse;

/**
 *  TrackingSkeleton java skeleton for the axisService
 */
public class TrackingSkeleton implements TrackingSkeletonInterface {
    /**
     * Auto generated method signature
     *
     * @param getAnimals0
     * @return getAnimalsResponse1
     */
    public services.GetAnimalsResponse getAnimals(
        services.GetAnimals getAnimals0) {
    	System.out.println("{Tracking} getAnimals called");    	
    	
    	GetAnimalsResponse response = new GetAnimalsResponse();
    	
    	DatabaseServerInterface db = null;
    	model.Animal[] animalsFromDB = null;
    	
    	try {
			db = new DatabaseServer();
			animalsFromDB = db.getAllAnimals();
			System.out.println("{Tracking} Connection to DB was successful!");
		} catch (RemoteException e) {
			System.out.println("{Tracking} ERROR! Connection to DB failed!");
			System.out.println(""+e.getMessage());
		} 
    	
    	Animal[] animals = new Animal[animalsFromDB.length];
    	Animal animal = null;
    	
    	for (int i = 0; i < animalsFromDB.length; i++) {
    		animal = new Animal();
    		
    		animal.setAnimalId(animalsFromDB[i].getAnimalId());
    		animal.setType(animalsFromDB[i].getType());
    		animal.setWeight(animalsFromDB[i].getWeight());
    		
    		animals[i] = animal;
    	}
    	
    	response.set_return(animals);
    	
    	return response;
    }

    /**
     * Auto generated method signature
     *
     * @param trackAnimal2
     * @return trackAnimalResponse3
     */
    public services.TrackAnimalResponse trackAnimal(
        services.TrackAnimal trackAnimal2) {
    	
    	System.out.println("{Tracking} trackAnimal called");

        TrackAnimalResponse response = new TrackAnimalResponse();

        DatabaseServerInterface db = null;
        model.Product[] productsFromDB = null;
        ArrayList<model.Product> animalProducts = new ArrayList<model.Product>();
        
        try {
            db = new DatabaseServer();
            productsFromDB = db.getAllProducts();
            System.out.println("{Tracking} Connection to DB was successful!");
        } catch (Exception e) {
            System.out.println("{Tracking} ERROR! Connection to DB failed!");
            System.out.println("" + e.getMessage());
        }


        for (int k = 0; k < productsFromDB.length; k++) {
			for (int j = 0; j < productsFromDB[k].getParts().size(); j++) {
				if (productsFromDB[k].getParts().get(j).getAnimalId() == trackAnimal2.getArgs0()) {
					animalProducts.add(productsFromDB[k]);
					break;
				}
			}
		}
        
        Product[] products = new Product[animalProducts.size()];
        Product product = null;
        
        for (int i = 0; i < products.length; i++) {
        	product = new Product();
        	System.out.println("DEBUG: " + animalProducts.get(i).getProductId());
        	
        	product.setProductId(animalProducts.get(i).getProductId());
        	product.setType(animalProducts.get(i).getType());
        	product.setWeight(animalProducts.get(i).getWeight());
        	products[i] = product;
        }
        
        response.set_return(products);
        
        return response;
    }

    /**
     * Auto generated method signature
     *
     * @param trackProduct4
     * @return trackProductResponse5
     */
    public services.TrackProductResponse trackProduct(
        services.TrackProduct trackProduct4) {

    	System.out.println("{Tracking} trackProduct called");
    	
    	TrackProductResponse response = new TrackProductResponse();
    	
    	DatabaseServerInterface db = null;
        model.Market[] marketsFromDB = null;
    	Market market = new Market();
    	
		try {
			db = new DatabaseServer();
			marketsFromDB = db.getAllMarkets();
			System.out.println("{Tracking} Connection to DB was successful!");
		} catch (Exception e) {
			System.out.println("{Tracking} ERROR! Connection to DB failed!");
			System.out.println("" + e.getMessage());
		}

    	for (int i = 0; i < marketsFromDB.length; i++) {
    		for (int j = 0; j < marketsFromDB[i].getProducts().size(); j++) {
    			if (marketsFromDB[i].getProducts().get(j).getProductId() == trackProduct4.getArgs0()) {
    				
    				market.setMarketId(marketsFromDB[i].getMarketId());
    				market.setAddress(marketsFromDB[i].getAddress());
    				
    				break;
    			}
    		}
    	}
    	
    	response.set_return(market);
    	
    	return response;
    }
}
