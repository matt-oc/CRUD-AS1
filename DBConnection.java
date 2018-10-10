
/**
 * The DB class of GUI CRUD database connection
 * 
 * 
 * @author Matthew O'Connor
 * @version 25/09/2018
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test";

	/** The name of the table we are testing with */
	private final String tableName = "Employee";

	/** Create the table template used (not used after first time) */
	private String initial = "CREATE TABLE Employee(" + "ssn int (30) NOT NULL," + "dob varchar (12) NOT NULL,"
			+ "name varchar (30) NOT NULL," + "address varchar (50) NOT NULL," + "salary int (10) NOT NULL,"
			+ "gender varchar (10) NOT NULL," + "PRIMARY KEY (ssn))"; // ssn is the key

	/**
	 * Insert some data into new table (not used after first time) Individual for ease of reading for sake of assignment
	 */
	private String initialEntry1 = "INSERT INTO Employee VALUES (0000001, '12/02/1989', 'John McBeal', '1233 WIT avenue Waterford', 57000, 'Male')";
	private String initialEntry2 = "INSERT INTO Employee VALUES (0000002, '12/12/1979', 'Paul McNally', '1253 WIT drive Waterford', 47000, 'Male')";
	private String initialEntry3 = "INSERT INTO Employee VALUES (0000003, '04/02/1989', 'Mary Johnson', '1423 WIT close Waterford', 47000, 'Female')";
	private String initialEntry4 = "INSERT INTO Employee VALUES (0000004, '02/02/1969', 'Stephen Peterson', '2123 WIT island Waterford', 37500, 'Male')";
	private String initialEntry5 = "INSERT INTO Employee VALUES (0000005, '30/03/1984', 'Billy O Connor', '91273 WIT area Waterford', 100000, 'Male')";
	private String initialEntry6 = "INSERT INTO Employee VALUES (0000006, '28/02/1988', 'Alex Jukowska', '8123 WIT island Waterford', 21000, 'Female')";
	private String initialEntry7 = "INSERT INTO Employee VALUES (0000007, '17/12/1982', 'Jacob Murray', '1223 WIT offices Waterford', 34000, 'Male')";
	private String initialEntry8 = "INSERT INTO Employee VALUES (0000008, '12/02/1989', 'Robert Kiely', '123 WIT forest Waterford', 89000, 'Male')";
	private String initialEntry9 = "INSERT INTO Employee VALUES (0000009, '22/11/1973', 'Ciaran Roche', '1323 WIT field Waterford', 12000, 'Male')";
	private String initialEntry10 = "INSERT INTO Employee VALUES (0000010, '12/05/1989', 'Ross Kirwan', '1237 WIT street Waterford', 10000, 'Male')";

	private Statement myStmt;
	private ResultSet myRs;


	/**
	 * Create a DBConnection instance. Initialise its state so that it is ready for use.
	 */
	public DBConnection() {

	}


	/**
	 * Run a SQL command which does not return a recordset: CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException
	 *             If something goes wrong
	 */
	public boolean executeUpdate(String command) throws SQLException {

		try {

			myStmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		}
		finally {

			// This will run whether we throw an exception or not
			if (myStmt != null) {
				myStmt.close();
			}
		}
	}


	public void connect() {

		try {

			// connection to database
			System.out.println("....Attempting to connect to Database....\n");
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName + "?autoReconnect=true&useSSL=false", userName,
					password);
			// &useSSL=false will suppress warning on phpMyAdmin

			// create statement
			myStmt = myConn.createStatement();

			// create & populate initial table, only ran once
			// myStmt.executeUpdate(initial);
			// myStmt.executeUpdate(initialEntry1);
			// myStmt.executeUpdate(initialEntry2);
			// myStmt.executeUpdate(initialEntry3);
			// myStmt.executeUpdate(initialEntry4);
			// myStmt.executeUpdate(initialEntry5);
			// myStmt.executeUpdate(initialEntry6);
			// myStmt.executeUpdate(initialEntry7);
			// myStmt.executeUpdate(initialEntry8);
			// myStmt.executeUpdate(initialEntry9);
			// myStmt.executeUpdate(initialEntry10);

			// execute sql query
			myRs = myStmt.executeQuery("select * from " + tableName);

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}


	// Getter for Rows
	public String getRow() {
		try {
			myRs = myStmt.executeQuery("select * from " + tableName);
			return myRs.getString("ssn");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbName;
	}


	// Getter for Results set
	public ResultSet getRs() {
		return myRs;
	}


	// Getter for Statement
	public Statement getmyStmt() {
		return myStmt;
	}
}
