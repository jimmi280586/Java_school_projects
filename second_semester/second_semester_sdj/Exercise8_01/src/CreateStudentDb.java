
import java.sql.SQLException;
import java.util.ArrayList;
import utility.persistence.MyDatabase;

public class CreateStudentDb
{
  public static void main(String args[])
  {
    try
    {
      MyDatabase db = new MyDatabase();
      String sql = "CREATE DATABASE IF NOT EXISTS SXclass;";
      db.update(sql);

      //db = new MyDatabase("Students");
      db  = new MyDatabase("SXclass");

      sql = "CREATE TABLE IF NOT EXISTS Nationality ("
          + "  CountryCode varchar(2) NOT NULL PRIMARY KEY,"
          + "  Country varchar(50) NOT NULL" + ") ENGINE=InnoDB;";
      db.update(sql);

      sql = "CREATE TABLE IF NOT EXISTS Student ("
          + "  StudyNumber int NOT NULL PRIMARY KEY,"
          + "  FirstName varchar(30) NOT NULL, "
          + "  LastName varchar(30) NOT NULL, "
          + "  CountryCode varchar(50) NOT NULL,"
          + "  FOREIGN KEY (CountryCode) REFERENCES Nationality(CountryCode)"
          + ") ENGINE=InnoDB;";
      db.update(sql);

      sql = "INSERT INTO Nationality (CountryCode, Country) "
          + "SELECT * FROM (SELECT ?, ?) AS tmp "
          + "WHERE NOT EXISTS (SELECT CountryCode FROM Nationality "
          + "WHERE CountryCode = ?) LIMIT 1;";

      // or if you don't want to check if already there:
      // sql = "INSERT INTO Nationality (CountryCode, Country) VALUES(?, ?);";

      db.update(sql, "BG", "Bulgaria", "BG");
      db.update(sql, "DK", "Denmark", "DK");
      db.update(sql, "ES", "Spain", "ES");
      db.update(sql, "ET", "Ethiopia", "ET");
      db.update(sql, "GB", "United Kingdom", "GB");
      db.update(sql, "HR", "Croatia", "HR");
      db.update(sql, "FR", "France", "FR");
      db.update(sql, "LT", "Lithuania", "LT");
      db.update(sql, "LV", "Latvia", "LV");
      db.update(sql, "MD", "Moldova", "MD");
      db.update(sql, "PL", "Poland", "PL");
      db.update(sql, "RO", "Romania", "RO");
      db.update(sql, "SK", "Slovakia", "SK");
      db.update(sql, "SR", "Serbia", "SR");
      db.update(sql, "US", "United States", "US");
      db.update(sql, "?", "Not listed", "?");
     
      
      

      sql = "INSERT INTO Student (StudyNumber, FirstName, LastName, CountryCode) "
          + "SELECT * FROM (SELECT ?, ?, ?, ?) AS tmp "
          + "WHERE NOT EXISTS (SELECT StudyNumber FROM Student "
          + "WHERE StudyNumber = ?)  LIMIT 1;";

      // or if you don't want to check if already there:
      // sql =
      // "INSERT INTO Student (StudyNumber, FirstName, LastName, CountryCode) "
      // + "VALUES (?, ?, ?, ?);";

      db.update(sql, 232014, "Alex", "Seiwert", "FR", 232014);
      db.update(sql, 164626, "Alexandra Cristina", "Alstanei", "RO", 164626);
      db.update(sql, 224469, "Alexandru", "Ungureanu", "RO", 224469);
      db.update(sql, 224206, "Alice Sinkamba", "Christoffersen", "DK", 224206);
      db.update(sql, 231912, "Alvaro", "Camarasa", "ES", 231912);
      db.update(sql, 232001, "Andreas", "Guillot", "FR", 232001);
      db.update(sql, 224339, "Branislav", "Machava", "SK", 224339);
      db.update(sql, 224201, "Catalin", "Cervis", "RO", 224201);
      db.update(sql, 224429, "Cristian", "Serban", "RO", 224429);
      db.update(sql, 224436, "Damyan", "Sirakov", "BG", 224436);
      db.update(sql, 224160, "David", "Andreev", "SK", 224160);
      db.update(sql, 224274, "Dominik", "Hurcik", "SK", 224274);
      db.update(sql, 224408, "Emanuel", "Rad", "RO", 224408);
      db.update(sql, 226484, "Ionela", "Marinuta", "RO", 226484);
      db.update(sql, 224410, "Jevgenijs", "Ragozins", "LT", 224410);
      db.update(sql, 196852, "Jimmi", "Andersen", "DK", 196852);
      db.update(sql, 224355, "Kalin", "Mitkov", "BG", 224355);
      db.update(sql, 164662, "Karolis", "Kalanta", "LT", 164662);
      db.update(sql, 224197, "Kristofer", "Carta", "US", 224197);
      db.update(sql, 224352, "Laurynas", "Mileris", "LT", 224352);
      db.update(sql, 224475, "Lukas", "Varmeda", "SK", 224475);
      db.update(sql, 224271, "Magdalena", "Houska", "HR", 224271);
      db.update(sql, 225862, "Mantas", "Skimelis", "LT", 225862);
      db.update(sql, 208238, "Marcin", "Kraj", "PL", 208238);
      db.update(sql, 224351, "Marek", "Mikitovic", "SK", 224351);
      db.update(sql, 189602, "Nicolae-Claudiu", "Furca", "RO", 189602);
      db.update(sql, 224385, "Nikola", "Peevski", "BG", 224385);
      db.update(sql, 224164, "Ognian", "Apostolov", "BG", 224164);
      db.update(sql, 224409, "Rares-Alin", "Radulescu", "RO", 224409);
      db.update(sql, 208277, "Renatas", "Valatka", "LT", 208277);
      db.update(sql, 224447, "Ryen", "Stork", "GB", 224447);
      db.update(sql, 224194, "Sarunas", "Burba", "LT", 224194);
      db.update(sql, 224433, "Slavomir", "Simko", "SK", 224433);
      db.update(sql, 224378, "Stanislav", "Ondrus", "SK", 224378);
      db.update(sql, 224202, "Teodor-Raul", "Chicinas", "RO", 224202);
      db.update(sql, 208234, "Trifon", "Kamenov", "BG", 208234);
      db.update(sql, 224464, "Tseno", "Tsenov", "BG", 224464);
      db.update(sql, 224165, "Valeriu", "Arhip", "RO", 224165);
      db.update(sql, 224337, "Vanja", "Lukac", "SR", 224337);
      db.update(sql, 224313, "Verinda", "Kondzheli", "BG", 224313);
      db.update(sql, 164634, "Victor", "Cazan", "RO", 164634);
      db.update(sql, 224181, "Viktors", "Bergholcs", "LV", 224181);
      db.update(sql, 224487, "Zemichael", "Tadesse", "ET", 224487);

      // Check result:

      sql = "SELECT CountryCode, Country FROM Nationality ORDER BY CountryCode;";

      ArrayList<Object[]> results = db.query(sql);
      for (int i = 0; i < results.size(); i++)
      {
        Object[] row = results.get(i);
        String countryCode = row[0].toString();
        String country = row[1].toString();
        System.out.println(country + " (" + countryCode + ")");
      }

      sql = "SELECT StudyNumber, FirstName, LastName, "
          + "Country FROM Student, Nationality "
          + "WHERE Student.CountryCode = Nationality.CountryCode "
          + "AND FirstName LIKE ? " + "ORDER BY FirstName, LastName;";

      results = db.query(sql, "%");
      for (int i = 0; i < results.size(); i++)
      {
        Object[] row = results.get(i);
        int studyNumber = Integer.parseInt(row[0].toString());
        String firstName = row[1].toString();
        String lastName = row[2].toString();
        String country = row[3].toString();

        System.out.println(firstName + " " + lastName + " (" + studyNumber
            + ") - " + country);
      }
    }
    catch (SQLException | ClassNotFoundException e)
    {
      System.out.println("Database issue");
      e.printStackTrace();
    }
  }
}
