package JDBCLab;


/* Eg., 8			 updating records 	*/
import java.sql.*;

import day18.DBUtility;

public class Ex8 {
	public static void main(String str[]) throws Exception
	{
		try
		{
			Connection con = DBUtility.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate("update  sam set name='iniah' where age=31");
			st.executeUpdate("update  sam set name='uhdap' where age=41");
			
			ResultSet rs=st.executeQuery("select * from sam");
			System.out.println("name "+"\t\t age");
			while(rs.next())
			{
				String e1=rs.getString(1);
				int e=rs.getInt(2);
				System.out.println("name = " +e1 +"\t age = " +e);
			}
			System.out.println("records successfully  updatedd");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}

	
