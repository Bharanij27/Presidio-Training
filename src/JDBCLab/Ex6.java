package JDBCLab;

import java.sql.*;

import day18.DBUtility;
public class Ex6 {
	public static void main(String str[]) throws Exception
	{
		try
		{
			Connection con = DBUtility.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate("delete from sam where age=51");
			ResultSet rs = st.executeQuery("select * from sam");
			System.out.println("empno"+"\t empname");
			while(rs.next())
			{
				String e1=rs.getString(1);
				int e=rs.getInt(2);
				System.out.println("name = " +e1 +"\t age = " +e);
			}
			System.out.println("records successfully  deleted");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}
