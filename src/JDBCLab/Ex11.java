package JDBCLab;
/*  Eg. ,11		another eg. For PreparedStatement 	*/
import java.sql.*;

import day18.DBUtility;

public class Ex11 {
	public static void main(String st[])
	{
		try
		{
			Connection con = DBUtility.getConnection();
			int  no = 666 ;
			String name = "sammm";
			PreparedStatement ps = con.prepareStatement("insert into sam values ( ? ,? ) ");
			ps.setString(1,name);
			ps.setInt(2,no);
			ps.executeUpdate();
			ps.close();
			System.out.println(" data inserted ");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}
	
