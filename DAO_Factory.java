import java.lang.*;
import java.sql.*;

public class DAO_Factory{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	static final String DB_URL = "jdbc:mysql://localhost/librarydb";
	static final String USER = "root";
	static final String PASS = "root";

	Connection dbconnection = null;

	BookDAO bookDAO = null;
	BookCopyDAO bookcopyDAO = null;
	MemberDAO memberDAO = null;

	boolean activeConnection = false;

	public DAO_Factory()
	{
		dbconnection = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception
	{
		if( activeConnection == true )
		{
			throw new Exception("Connection already active");
		}

		System.out.println("Connecting to database...");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnection = DriverManager.getConnection(DB_URL,USER,PASS);
			activeConnection = true;
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
		catch (SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public BookDAO getBookDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( bookDAO == null )
			bookDAO = new BookDAO_JDBC( dbconnection );

		return bookDAO;
	}
	public BookCopyDAO getBookCopyDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( bookcopyDAO == null )
			bookcopyDAO = new BookCopyDAO_JDBC( dbconnection );

		return bookcopyDAO;
	}
	public MemberDAO getMemberDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( memberDAO == null )
			memberDAO = new MemberDAO_JDBC( dbconnection );

		return memberDAO;
	}
	public void deactivateConnection()
	{
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if( dbconnection != null ){
			try{
				dbconnection.close();
				dbconnection = null;
				bookDAO = null;
				bookcopyDAO = null;
				memberDAO = null;
			}
			catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
};