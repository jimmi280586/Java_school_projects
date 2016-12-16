package java_t2.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Tray implements Serializable
{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private String type;
   private String trayID;
   private float currentWeight;
   private float maxWeight;
   private ArrayList<String> parts;

   
   public Tray(){}
   public Tray(String type, float maxWeight)
   {
      this.type = type;
      this.maxWeight = maxWeight;
      parts = new ArrayList<String>(50);
      this.trayID = trayID;
      currentWeight = 0;
   }

   public Tray(String type, String trayID, float maxWeight, ArrayList<String> parts )
   {
      this.type = type;
      this.maxWeight = maxWeight;
      parts = new ArrayList<String>(50);
      this.trayID = trayID;
      currentWeight = 0;
   }

  

   public String getTrayID()
   {
      return trayID;
   }

   public void setTrayID(String trayID)
   {
      this.trayID = trayID;
   }
   
   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

  
   public double getMaxWeight()
   {
      return maxWeight;
   }

   public void setMaxWeight(float maxWeight)
   {
      this.maxWeight = maxWeight;
   }

   public void addPart(String part)
   {
      parts.add(part);
   }

   public double getCurrentWeight()
   {
      return currentWeight;
   }

   public String removePart(Part part)
   {
      if (parts.contains(part.getPartID()))
      {
         parts.remove(part.getPartID());
         return "Removed part from tray ID: " + trayID;
      }

      return "This part is not in tray ID: " + trayID;

   }

   public String removePart(String partID)
   {
      if (parts.contains(partID))
      {
         parts.remove(partID);
         return "Removed part from tray ID: " + trayID;
      }

      return "This part is not in tray ID: " + trayID;

   }

   public boolean contains(Part part)
   {
      return parts.contains(part.getPartID());
   }

   public boolean contains(String partID)
   {
      return parts.contains(partID);
   }

   public int getNumberOfParts()
   {
      return parts.size();
   }

   public String getParts()
   {
      return parts.toString();
   }

   public String getPart(int i)
   {
      return parts.get(i);
   }

   public int getPartsSize()
   {
      return parts.size();
   }
   
   public void removeAllParts()
   {
      parts.clear();
      currentWeight = 0;
   }

   public String toString()
   {
      return "TRAY ID:" + trayID + "\nType: " + type.toUpperCase()
            + "\nMax Weight: " + maxWeight + "kg" + "\nParts: " + getParts();
   }
}
