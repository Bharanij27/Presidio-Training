package JDBCLab;

import java.sql.*;

import day18.DBUtility;
/* selecting rows from emp table */

public class Ex3{
	public static void main(String str[]) throws Exception
	{
		try
		{
			Connection con = DBUtility.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate("create table sam(name varchar(15),age int)");
			st.close();
			DBUtility.closeConnection(null, null);
			System.out.println("table created");
		}catch(Exception e)
		{
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}		