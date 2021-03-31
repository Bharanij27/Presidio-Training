package JDBCLab;

/* Eg., 9 			 Deleting a Table  		*/
import java.sql.*;

import day18.DBUtility;

public class Ex9 {
	public static void main(String str[]) throws Exception
	{
		try
		{
			Connection con = DBUtility.getConnection();
			Statement st=con.createStatement();
			//	  st.executeUpdate("drop table sam");
			ResultSet rs=st.executeQuery("select * from tab ");
			System.out.println("TNAME  \t\t TABTYPE  \t\t  CLUSTERID");
			while(rs.next())
			{
				String name=rs.getString(1);
				String type=rs.getString(2);
				String clus=rs.getString(3);
				System.out.println(name +"\t \t" +type + "\t\t " +clus);
			}
			System.out.println("Customer Table Successufully Droped");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}
	
