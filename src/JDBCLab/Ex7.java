package JDBCLab;

/* Eg., 7			using execute 	*/
import java.sql.*;

import day18.DBUtility;

public class Ex7 {
	public static void main(String str[]) throws Exception
	{
		try
		{
			Connection con = DBUtility.getConnection();
			Statement st=con.createStatement();
			st.execute("insert into sam values('hapa',111)");
			st.execute("delete from sam where age=21");
			System.out.println(" successÖ.. ");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}

