package JDBCLab;

/* Eg., 4 			program for inserting  a record 	*/
import java.sql.*;

import day18.DBUtility;
public class EX4{
	public static void main(String str[]) throws Exception {
		try
		{
			Connection con=DBUtility.getConnection();
			Statement st=con.createStatement();
			st.executeUpdate(" insert into sam values('one1',11)");
			st.executeUpdate(" insert into sam values('two1',21)");
			st.executeUpdate(" insert into sam values('three1',31)");
			st.executeUpdate(" insert into sam values('four1',41)");
			st.executeUpdate(" insert into sam values('five1',51)");
			System.out.println("records successfully  inserted");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}		
}
