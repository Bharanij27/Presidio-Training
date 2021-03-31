package JDBCLab;

/*  Eg., 12			  program for procedure 		*/


import  java.sql.*;
import day18.DBUtility;
import  java.io.*;

public class Ex12 {
	public static void main(String st1[ ])
	{
		try
		{
			Connection con = DBUtility.getConnection();
			System.out.println("enter Increment value  ");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String st=br.readLine();
			int p=Integer.parseInt(st);
			
			CallableStatement cs=con.prepareCall ( "{call proc(?)}" );
			cs.setInt(1,p);
			cs.execute();
			System.out.println("procedure executed ");
			cs.close();
			
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from sam");
			while(rs.next())
			{
				String name=rs.getString(1);
				int eno=rs.getInt(2);
				System.out.println(eno +"\t " + name );
			}
			rs.close();
			stm.close();
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}