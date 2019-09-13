import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class MemberDAO_JDBC implements MemberDAO
{
	Connection dbConnection;
	public MemberDAO_JDBC(Connection dbconn)
	{
		dbConnection = dbconn;
	}

	@Override
	public void addMember(Member m)
	{
		PreparedStatement prepstmt = null;
		String sql = "INSERT IGNORE INTO member(mid, fname, minit, lname, memberType, addr, phoneno, noofbooksissued, maxissued) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try
		{
			prepstmt = dbConnection.prepareStatement(sql);

			prepstmt.setInt(1, m.getId());
			prepstmt.setString(2, m.getFname());
            prepstmt.setString(3, Character.toString(m.getMInit()));
			prepstmt.setString(4, m.getLname());
			prepstmt.setString(5, m.getMemberType());
            prepstmt.setString(6, m.getAddr());
			prepstmt.setString(7, m.getPhoneNo());
			prepstmt.setInt(8, m.getBooksIssuedCount());
			prepstmt.setInt(9, m.getMaxIssuedCount());
			
			prepstmt.executeUpdate();
			//dbConnection.commit();

			System.out.println("Member "+m.getId()+" added to the database");
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