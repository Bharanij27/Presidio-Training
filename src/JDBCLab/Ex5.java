package JDBCLab;
import java.sql.*;

import day18.DBUtility;

public class Ex5 {
	public static void main(String str[]) throws Exception
	{
		try
		{

			Connection con=DBUtility.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from SAM");
			while(rs.next())
			{
				String e1=rs.getString(1);
				int e=rs.getInt(2);
				System.out.println("name = " +e1 +" age = " +e);
			}
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}	
}
