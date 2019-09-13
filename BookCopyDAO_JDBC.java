import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookCopyDAO_JDBC implements BookCopyDAO
{
	Connection dbConnection;
	public BookCopyDAO_JDBC(Connection dbconn)
	{
		dbConnection = dbconn;
	}
	
	@Override
	public void addBookCopy(Book b)
	{
		PreparedStatement prepstmt = null;
		BookCopy bc = new BookCopy();
		String sql;
		sql = "INSERT IGNORE INTO bookcopy(ebid, copyid, status) VALUES (?, ?, ?);";
		try
		{
			prepstmt = dbConnection.prepareStatement(sql);
			
			for(int i=1;i<=b.getTotalCount();i++)
			{
				bc.setId(b.getId());
				bc.setCopyId(i);
				bc.setStatus(true);
				prepstmt.setInt(1, bc.getId());
				prepstmt.setString(2, bc.getCopyId());
				prepstmt.setBoolean(3, bc.getStatus());
				
				prepstmt.executeUpdate();
				//dbConnection.commit();

				System.out.println("Book copies of "+bc.getCopyId()+" added to the database");
			}
			System.out.println("Book copies of "+b.getId()+" added to the database");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			if(prepstmt!=null)
			{
				prepstmt.close();
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}