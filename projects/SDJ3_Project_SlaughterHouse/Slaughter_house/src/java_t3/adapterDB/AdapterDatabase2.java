package java_t3.adapterDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java_t2.Data.*;
import java_t2.Data.Order;
import java_t2.Data.Part;
import java_t2.Data.Tray;

public class AdapterDatabase2 implements IAdapterDatabase
{
   private String host;
   private int port;
   private String user;
   private String password;
   private String dataBase;
   private Connection connection;

   public AdapterDatabase2(String host, int port, String dataBase, String user,
         String password)
   {
      this.host = host;
      this.port = port;
      this.dataBase = dataBase;
      this.user = user;
      this.password = password;
      connection = null;
      ;
   }

   public AdapterDatabase2(String user, String password)
   {
      this.user = user;
      this.password = password;
      connection = null;
   }

   public Connection openDatabase() throws SQLException
   {
      connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", user, password);

      return connection;

   }

   public void closeDatabase() throws SQLException
   {
      connection.close();
   }

   public ArrayList<Object[]> query(String sql) throws SQLException
   {
      openDatabase();
      PreparedStatement statement = null;
      ArrayList<Object[]> resultList = null;
      ResultSet resultSet = null;
      if (sql != null && statement == null)
      {
         statement = connection.prepareStatement(sql);
      }
      resultSet = statement.executeQuery();
      resultList = new ArrayList<Object[]>();
      while (resultSet.next())
      {
         Object[] resultRow = new Object[resultSet.getMetaData()
               .getColumnCount()];
         for (int i = 0; i < resultRow.length; i++)
         {
            resultRow[i] = resultSet.getObject(i + 1);
         }
         resultList.add(resultRow);
      }
      if (resultSet != null)
         resultSet.close();
      if (statement != null)
         statement.close();
      closeDatabase();
      return resultList;
   }

   public int update(String sql) throws SQLException
   {
      int results = 0;

      openDatabase();
      PreparedStatement statement = connection.prepareStatement(sql);
      if (sql != null && statement == null)
      {
         statement = connection.prepareStatement(sql);
      }
      results = statement.executeUpdate();
      // closeDatabase();
      return results;
   }

   @Override
   public boolean storageAnimal(Animal a)
   {
      int results;
      String sql;
      try
      {
         sql = "INSERT INTO slaghterHouse.animal " + "VALUES ('"
               + a.getAnimalID() + "', '" + a.getType() + "', '" + a.getWeight()
               + "')";

         results = update(sql);
         if (results == 0)
         {
            return false;
         }

         return true;
      }
      catch (SQLException e)
      {
         e.printStackTrace();
         return false;
      }
   }

   @Override
   public boolean storagePart(Part p)
   {
      int results;
      String sql;
      try
      {

         sql = "INSERT INTO slaghterHouse.part " + "VALUES ('" + p.getAnimalID()
               + "','" + p.getPartID() + "', '" + p.getType() + "', '"
               + p.getWeight() + "')";
         results = update(sql);

         if (results == 0)
         {
            return false;
         }
      }
      catch (SQLException e)
      {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   @Override
   public boolean storageTray(Tray t)
   {
      int results;
      String sql;
      try
      {
         sql = "INSERT INTO slaghterHouse.part " + "VALUES ('" + t.getType()
               + "','" + t.getTrayID() + "', '" + t.getMaxWeight() + "')";
         results = update(sql);
         if (results == 0)
         {
            return false;
         }
         for (int i = 0; i < t.getPartsSize(); i++)
         {
            int results2;
            String sql2;
            sql2 = "INSERT INTO slaghterHouse.trayPart " + "VALUES ('"
                  + t.getPart(i) + "','" + t.getTrayID() + "')";
            results2 = update(sql2);
            if (results2 == 0)
            {
               return false;
            }
         }

      }
      catch (SQLException e)
      {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   @Override
   public boolean storageOrder(Order o)
   {
      int results;
      String sql;
      try
      {
         sql = "INSERT INTO slaghterHouse.orders " + "VALUES ('"
               + o.getOrderID() + "','" + o.getWeight() + "', '" + o.getType()
               + "')";
         results = update(sql);
         if (results == 0)
         {
            return false;
         }
         for (int i = 0; i < o.getTraySize(); i++)
         {
            int results2;
            String sql2;
            sql2 = "INSERT INTO slaghterHouse.orderTrays " + "VALUES ('"
                  + o.getOrderID() + "','" + o.getTray(i) + "')";
            results2 = update(sql2);
            if (results2 == 0)
            {
               return false;
            }
         }

      }
      catch (SQLException e)
      {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   @Override
   public boolean updateTray(String ref, String partRef)
   {
      try
      {
         int results2;
         String sql2;
         sql2 = "INSERT INTO slaghterHouse.trayPart " + "VALUES ('" + ref
               + "','" + partRef + "')";
         results2 = update(sql2);
         if (results2 == 0)
         {
            return false;
         }

      }
      catch (SQLException e)
      {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   @Override
   public boolean updateOrder(String orderRef, String reg)
   {
      try
      {
         int results2;
         String sql2;
         sql2 = "INSERT INTO slaghterHouse.orderTrays " + "VALUES ('"
               + orderRef + "','" + reg + "')";
         results2 = update(sql2);
         if (results2 == 0)
         {
            return false;
         }
      }
      catch (SQLException e)
      {
         e.printStackTrace();
         return false;
      }
      return true;
   }

   @Override
   public ArrayList<String> getComplainsOrders(String orderID)
   {
      try
      {
         String temp;
         int i;
         ArrayList<String> trayRefs = new ArrayList<String>();
         ArrayList<String> partRefs = new ArrayList<String>();
         ArrayList<String> animals = new ArrayList<String>();
         ArrayList<String> parts = new ArrayList<String>();
         ArrayList<String> trays = new ArrayList<String>();
         ArrayList<String> orders = new ArrayList<String>();

         PreparedStatement st, stGetParts, stGetAnimals, stGetTrays, stGetOrder;
         ResultSet rs, rsGetParts, rsGetAnimals, rsGetTrays, rsGetOrders;

         // #1 tray ref from orderID
         st = connection.prepareStatement(
               "SELECT * FROM slaughterHouse.orderTrays INNER JOIN orders "
                     + "ON slaughterHouse.orderTrays.orderRef = slaughterHouse.orders.orderID "
                     + "WHERE orderRef = orderID");

         rs = st.executeQuery();

         // got all the tray refs
         while (rs.next())
         {
            temp = rs.getString("trayRef");
            if (!trayRefs.contains(temp))
               trayRefs.add(temp);
         }
         System.out.println("Tray refs: " + trayRefs.toString());

         // #2 Part refs from tray
         for (i = 0; i < trayRefs.size(); i++)
         {
            temp = trayRefs.get(i);

            stGetParts = connection.prepareStatement(
                  "" + "SELECT * FROM slaughterHouse.trayParts INNER JOIN slaughterHouse.part "
                        + "ON slaughterHouse.trayParts.partRef = slaughterHouse.part.partID "
                        + "WHERE trayRef = temp");

            rsGetParts = stGetParts.executeQuery();

            // got all the part refs
            while (rsGetParts.next())
            {
               temp = rsGetParts.getString("partRef");
               if (!partRefs.contains(temp))
                  partRefs.add(temp);
            }
         }
         System.out.println("Part refs: " + partRefs.toString());

         // #3 Animal refs from part
         for (i = 0; i < partRefs.size(); i++)
         {
            temp = partRefs.get(i);

            stGetAnimals = connection.prepareStatement(
                  "" + "SELECT * FROM slaughterHouse.animal INNER JOIN slaughterHouse.part "
                        + "ON slaughterHouse.part.animalID = slaughterHouse.animal.animalID"
                        + "WHERE slaughterHouse.part.partID = temp");

            rsGetAnimals = stGetAnimals.executeQuery();

            // got all the animal references
            while (rsGetAnimals.next())
            {
               temp = rsGetAnimals.getString("animalID");
               if (!animals.contains(temp))
                  animals.add(temp);
            }
         }
         System.out.println("Animal refs: " + animals.toString());

         // #4 Part references (all contaminated parts) from animal
         for (i = 0; i < animals.size(); i++)
         {
            temp = animals.get(i);

            stGetParts = connection.prepareStatement(
                  "" + "SELECT partID FROM slaughterHouse.part " + "WHERE animalID = temp");

            rsGetParts = stGetParts.executeQuery();

            // got all the part references
            while (rsGetParts.next())
            {
               temp = rsGetParts.getString("partID");
               if (!parts.contains(temp))
                  parts.add(temp);
            }
         }
         System.out.println("All Contaminated Part: " + parts.toString());

         // #5 Tray ref (all contaminated trays) from part
         for (i = 0; i < parts.size(); i++)
         {
            temp = parts.get(i);

            stGetTrays = connection
                  .prepareStatement("" + "SELECT * FROM slaughterHouse.trayParts "
                        + "INNER JOIN slaughterHouse.part ON slaughterHouse.trayparts.partRef = slaughterHouse.part.partID "
                        + "WHERE partRef = temp");

            stGetTrays.setString(1, temp);
            rsGetTrays = stGetTrays.executeQuery();

            // got all the tray refs
            while (rsGetTrays.next())
            {
               temp = rsGetTrays.getString("trayRef");
               if (!trays.contains(temp))
                  trays.add(temp);
            }
         }
         System.out.println("All Contaminated Trays: " + trays.toString());

         // #6 Order references (all contaminated orders) from trays
         for (i = 0; i < trays.size(); i++)
         {
            temp = trays.get(i);

            stGetOrder = connection.prepareStatement(
                  "" + "SELECT * FROM slaughterHouse.orderTrays INNER JOIN slaughterHouse.tray "
                        + "ON slaughterHouse.orderTrays.trayRef = slaughterHouse.tray.trayID "
                        + "WHERE trayRef = temp");

            stGetOrder.setString(1, temp);
            rsGetOrders = stGetOrder.executeQuery();

            // got all the order refs
            while (rsGetOrders.next())
            {
               temp = rsGetOrders.getString("orderID");
               if (!orders.contains(temp))
                  orders.add(temp);
            }
         }
         System.out.println("All complains : " + orders.toString());

         return orders;
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      System.err.println("Failled to gets Part");
      return null;

   }

   @Override
   public Tray getTray(String reg)
   {
      try
      {
         PreparedStatement st = connection
               .prepareStatement("SELECT * FROM slaughterHouse.tray WHERE trayID='+reg+'");

         ResultSet rs = st.executeQuery();

         while (rs.next())
         {
            Tray temp = new Tray(rs.getString("type"), rs.getFloat("weight"));
            temp.setTrayID(reg);

            PreparedStatement st2 = connection.prepareStatement(
                  "SELECT partRef FROM slaughterHouse.trayParts WHERE trayRef = reg");

            ResultSet rs2 = st2.executeQuery();
            // get part references
            while (rs2.next())
            {
               String tempPartRef = rs2.getString("partRef");
               temp.addPart(tempPartRef);
            }
            return temp;
         }
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      System.err.println("Failled to gets Tray");

      return null;
   }

   @Override
   public Part getPart(String reg)
   {
      try
      {
         PreparedStatement st = connection
               .prepareStatement("SELECT * FROM slaughterHouse.part WHERE partID = reg");

         ResultSet rs = st.executeQuery();
        	 
         while (rs.next())
         {
            Part temp = new Part(rs.getString("animalID"), rs.getString("type"),rs.getFloat("weight"));
            temp.setPartID(rs.getString("reg"));

            return temp;
         }
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      System.err.println("Failled to gets Part");
      return null;
   }

   @Override
   public Order getOrder(String reg)
   {
      try
      {
         PreparedStatement st = connection
               .prepareStatement("SELECT * FROM slaughterHouse.orders WHERE orderID = reg");

         ResultSet rs = st.executeQuery();

         while (rs.next())
         {
            Order temp = new Order(rs.getFloat("weight"),
                  rs.getString("type"));
            temp.setOrderID(reg);

            PreparedStatement st2 = connection.prepareStatement(
                  "SELECT * FROM orderTrays WHERE orderRef = reg");

            ResultSet rs2 = st2.executeQuery();
            while (rs2.next())
            {
               String tempTrayToList = rs2.getString("trayRef");
               temp.addTrayToList(tempTrayToList);
            }

            return temp;
         }

      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      return null;
   }



}
