package JDBCLab;

/*  Eg. 10		 For PreparedStatement 		*/
import java.sql.*;

import day18.DBUtility;

public class EX10 {
	public static void main(String st[])
	{
		try
		{
			Connection con = DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from sam where age>= ?");
			ps.setInt(1,20);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("empno \t\t empname ");
			while(rs.next())
			{
				String e1=rs.getString(1);
				int e=rs.getInt(2);
				System.out.println("name = " +e1 +"\t age = " +e);
			}
			rs.close();
			ps.close();
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}