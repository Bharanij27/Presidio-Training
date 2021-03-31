package JDBCLab;
import java.sql.*;

import day18.DBUtility;

public class Ex1{
	public static void main(String st1[]) throws Exception
	{
		Connection con = DBUtility.getConnection();
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery("select * from users");
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("No. of Cols =" +rsmd.getColumnCount());
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{	
			String c=rsmd.getColumnName(i);
			String c1=rsmd.getColumnTypeName(i);
			
			String c2=rsmd.getColumnLabel(i);
			System.out.println("columne name " +c +" type "+c1+" label " +c2);
		}
		DBUtility.closeConnection(null, null);
	}
}
