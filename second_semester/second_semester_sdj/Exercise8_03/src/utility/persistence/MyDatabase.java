package utility.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class for database query and updates
 * 
 * @version 1.4, Date: 21 February 2015
 * @author Steffen Vissing Andersen
 */
public class MyDatabase
{
  private String url;
  private String user;
  private String pw;
  private Connection connection;

  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost/";
  private static final String USER = "kc";
  private static final String PASSWORD = "redsox";

  /**
   * Constructor.
   * 
   * @param driver
   *          the name of database driver
   * @param url
   *          the full url for the database
   * @param user
   *          the username for database
   * @param pw
   *          the password for database
   * @throws ClassNotFoundException
   *           if driver cannot be loaded
   */
  public MyDatabase(String driver, String url, String user, String pw)
      throws ClassNotFoundException
  {
    this.url = url;
    this.user = user;
    this.pw = pw;
    connection = null;
    Class.forName(driver);
  }

  /**
   * Constructor for a mysql database.
   * 
   * @param databaseName
   *          the name of the database
   * @param user
   *          the username for database
   * @param pw
   *          the password for database
   * @throws ClassNotFoundException
   *           if the mysql driver cannot be loaded
   */
  public MyDatabase(String databaseName, String user, String pw)
      throws ClassNotFoundException
  {
    this(DRIVER, URL + databaseName, user, pw);
  }

  /**
   * Constructor for a mysql database with username = "root" and an empty
   * password string.
   * 
   * @param databaseName
   *          the name of the database
   * @throws ClassNotFoundException
   *           if the mysql driver cannot be loaded
   */
  public MyDatabase(String databaseName) throws ClassNotFoundException
  {
    this(DRIVER, URL + databaseName, USER, PASSWORD);
  }

  /**
   * Constructor for a mysql database with username = "root", an empty
   * password string and database name not specified.
   * 
   * @throws ClassNotFoundException
   *           if the mysql driver cannot be loaded
   */
  public MyDatabase() throws ClassNotFoundException
  {
    this(DRIVER, URL, USER, PASSWORD);
  }

  private void openDatabase() throws SQLException
  {
    connection = DriverManager.getConnection(url, user, pw);
  }

  private void closeDatabase() throws SQLException
  {
    connection.close();
  }

  /**
   * Returning the result from an SQL query in the form of an Object array for
   * each row. All Object arrays are returned in an ArrayList.
   * 
   * @param sql
   *          the SQL statement to execute. Starting with "SELECT".
   * @param statementElements
   *          a number of statement elements each representing an element for a
   *          placeholder in the SQL string.
   * @return an ArrayList with an Object[] for each row in the query result
   * @throws SQLException
   *           if something went wrong in the connection or query
   */
  public ArrayList<Object[]> query(String sql, Object... statementElements)
      throws SQLException
  {
    openDatabase();

    PreparedStatement statement = null;
    ArrayList<Object[]> list = null;
    ResultSet resultSet = null;
    if (sql != null && statement == null)
    {
      statement = connection.prepareStatement(sql);
      if (statementElements != null)
      {
        for (int i = 0; i < statementElements.length; i++)
          statement.setObject(i + 1, statementElements[i]);
      }
    }
    resultSet = statement.executeQuery();
    list = new ArrayList<Object[]>();
    while (resultSet.next())
    {
      Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
      for (int i = 0; i < row.length; i++)
      {
        row[i] = resultSet.getObject(i + 1);
      }
      list.add(row);
    }
    if (resultSet != null)
      resultSet.close();
    if (statement != null)
      statement.close();
    closeDatabase();
    return list;
  }

  /**
   * An SQL update.
   * 
   * @param sql
   *          the sql updates to execute. Could start with "UPDATE", "INSERT", "CREATE", ...
   * @param statementElements
   *          a number of statement elements each representing an element for a
   *          placeholder in the SQL string.
   * @return an integer representing the number of updates given by the database
   * @throws SQLException
   *           if something went wrong in the connection or update
   */
  public int update(String sql, Object... statementElements)
      throws SQLException
  {
    openDatabase();
    PreparedStatement statement = connection.prepareStatement(sql);
    if (statementElements != null)
    {
      for (int i = 0; i < statementElements.length; i++)
        statement.setObject(i + 1, statementElements[i]);
    }

    int result = statement.executeUpdate();

    closeDatabase();
    return result;
  }

  /**
   * A number of SQL updates.
   * 
   * @param sqlList
   *          an ArrayList containing SQL updates to execute. 
   * @return an integer array representing the number of updates given by the database for each statement
   * @throws SQLException
   *           if something went wrong in the connection or update
   */
  public int[] updateAll(ArrayList<String> sqlList) throws SQLException
  {
    if (sqlList == null)
      return null;

    openDatabase();
    int[] results = new int[sqlList.size()];
    for (int i = 0; i < sqlList.size(); i++)
    {
      PreparedStatement statement = connection.prepareStatement(sqlList.get(i));
      results[i] = statement.executeUpdate();
    }
    closeDatabase();
    return results;
  }

  /**
   * A number of SQL updates from a text file with each SQL statement ended by a semicolon.
   * 
   * @param fileName
   *          a filename for a text file containing SQL updates to execute. 
   * @return an integer array representing the number of updates given by the database for each statement
   * @throws SQLException
   *           if something went wrong in the connection or update
   * @throws FileNotFoundException
   *           if text file cannot be found
   */
  public int[] updateAll(String fileName) throws SQLException,
      FileNotFoundException
  {
    ArrayList<String> sqlList = readFile(fileName, ";");
    return updateAll(sqlList);
  }

  private ArrayList<String> readFile(String filename, String deliminator)
      throws FileNotFoundException
  {
    Scanner input = new Scanner(new FileInputStream(filename));
    ArrayList<String> list = new ArrayList<String>();
    String sql = "";
    while (input.hasNext())
    {
      sql += input.nextLine();
      if (deliminator == null || sql.trim().endsWith(deliminator))
      {
        list.add(sql);
        sql = "";
      }
      else if (sql.length() > 0)
      {
        sql += "\n";
      }
    }
    input.close();
    return list;
  }
}
