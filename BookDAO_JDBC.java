import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookDAO_JDBC implements BookDAO
{
	Connection dbConnection;
	public BookDAO_JDBC(Connection dbconn)
	{
		dbConnection = dbconn;
	}

	@Override
	public Book getBookById(int id)
	{
		Book b = new Book();
		String sql;
		Statement stmt = null;

		try
		{
			stmt = dbConnection.createStatement();
			sql = "SELECT * FROM book where bid="+Integer.toString(id)+";";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				int bid = rs.getInt("bid");
				String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                float price = rs.getFloat("price");
                String edition = rs.getString("edition");
				int totalcount = rs.getInt("totalcount");
				int availablecount = rs.getInt("availablecount");
				b.setId(bid);
				b.setName(name);
				b.setPublisher(publisher);
				b.setAuthor(author);
				b.setEdition(edition);
				b.setPrice(price);
				b.setTotalCount(totalcount);
				b.setAvailableCount(availablecount);
				break;
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: "+e.getMessage());
            System.out.println("SQLState: "+e.getSQLState());
            System.out.println("VendorError: "+e.getErrorCode());
		}
		return b;
	}

	@Override
	public void addBook(Book b)
	{
		PreparedStatement prepstmt = null;
		
		String sql = "INSERT INTO book(bid, name, author, publisher, price, edition, totalcount, availablecount) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE totalcount=totalcount+?, availablecount=availablecount+?;";

		try
		{
			prepstmt = dbConnection.prepareStatement(sql);

			prepstmt.setInt(1, b.getId());
			prepstmt.setString(2, b.getName());
            prepstmt.setString(3, b.getAuthor());
			prepstmt.setString(4, b.getPublisher());
			prepstmt.setFloat(5, b.getPrice());
            prepstmt.setString(6, b.getEdition());
			prepstmt.setInt(7, b.getTotalCount());
			prepstmt.setInt(8, b.getAvailableCount());
			prepstmt.setInt(9, b.getTotalCount());
			prepstmt.setInt(10, b.getTotalCount());
			
			prepstmt.executeUpdate();
			//dbConnection.commit();

			System.out.println("Book "+b.getId()+" added to the database");
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