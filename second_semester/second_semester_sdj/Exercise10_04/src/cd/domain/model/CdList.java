package cd.domain.model;

import java.util.ArrayList;

public class CdList
{
   private ArrayList<Cd> cds;

   public CdList()
   {
      this.cds = new ArrayList<Cd>();
   }

   public Cd getCD(int index)
   {
      return cds.get(index);
   }

   public CdList getCdsByTitle(String title)
   {
      CdList list = new CdList();
      for (int i = 0; i < cds.size(); i++)
      {
         if (cds.get(i).getTitle().equalsIgnoreCase(title))
         {
            list.addCd(cds.get(i));
         }
      }
      return list;
   }

   public int getNumberOfCds()
   {
      return cds.size();
   }

   public void addCd(Cd cd)
   {
      if (!cds.contains(cd))
         cds.add(cd);
   }

   public void removeCdByIndex(int index)
   {
      cds.remove(index);
   }

   public Cd removeFirstCdByTitle(String title)
   {
      Cd cd = null;
      for (int i = 0; i < cds.size(); i++)
      {
         if (cds.get(i).getTitle().equalsIgnoreCase(title))
         {
            cd = cds.get(i);
            removeCdByIndex(i);
            break;
         }
      }
      return cd;
   }

   public String toString()
   {
      String all = "";
      for (int i = 0; i < cds.size(); i++)
      {
         all += "\nCD #" + (i + 1) + "\n" + cds.get(i);
         if (i < cds.size() - 1)
            all += "\n";
      }
      return all;
   }

}
