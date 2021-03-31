package JDBCLab;


import java.sql.*;
import day18.DBUtility;

public class Ex {
   public static void main(String str[]) throws Exception{
	try
	{
		Connection con = DBUtility.getConnection();
		
		// either statment works fine to make pointer move forward
		Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		//Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = st.executeQuery("select * from users");
		//while(rs.next()){}
		rs.afterLast();
		while(rs.previous()){
			String e1=rs.getString(2);
			int e=rs.getInt(1);
			System.out.println("name = " +e1 +" age = " +e);
		}
		st.close();
		con.close();  
	}
	catch(Exception e){e.printStackTrace();}
	
   }
}

