package java_t2.Data;

import java.io.Serializable;
import java.util.Random;


public class Part extends Animal  implements Serializable 
{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	   private String animalID;
	   private String type;
	   private String partID;
	   private float weight;
	   

      
	   public Part(String animalId, String type, String partID, float weight)
	   {
		 super(animalId, type , weight);
	    
	     animalID=super.getAnimalID();
	      this.type = type;
	      this.weight = weight;
	      this.partID = partID;
	   }

	   public String getAnimalID()
	   {
	      return super.getAnimalID();
	   }

	 

	
	   public String getType()
	   {
	      return type;
	   }

	   
	   public void setType(String type)
	   {
	      this.type = type;
	   }

	 
	   public String getPartID()
	   {
	      return partID;
	   }

	
	   public void setPartID(String partID)
	   {
	      this.partID = partID;
	   }

	
	   public double getWeight()
	   {
	      return weight;
	   }

	  
	   public void setWeight(float weight)
	   {
	      this.weight = weight;
	   }

	  
	   public String toString()
	   {
	      return "Type: " + type + "\nID: " + partID + "\nW: " + weight + "kg"
	            + "\nAnimal ID: " + animalID;
	   }	  
	}

