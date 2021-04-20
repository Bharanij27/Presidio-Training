package JDBCLab;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/*  Eg. ,11		another eg. For PreparedStatement 	*/
import java.sql.*;

import day18.DBUtility;

public class Ex11 {
	public static void main(String st[])
	{
		try
		{
			Connection con = DBUtility.getConnection();
            File image = new File("");
            FileInputStream inputStream = new FileInputStream(image);
 
            PreparedStatement stmt = con.prepareStatement("insert into groceries values(?,?,?,?)");
            stmt.setString(1, "c1");
            stmt.setString(2, "Carrot");
            stmt.setDouble(3, 20);
            stmt.setBinaryStream(4, (InputStream) inputStream, (int)(image.length()));
            stmt.setString(5, "shop1");
 
            stmt.executeUpdate();
//			int  no = 666 ;
//			String name = "sammm";
//			PreparedStatement ps = con.prepareStatement("insert into sam values ( ? ,? ) ");
//			ps.setString(1,name);
//			ps.setInt(2,no);
//			ps.executeUpdate();
//			ps.close();
			System.out.println(" data inserted ");
			DBUtility.closeConnection(null, null);
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}
}
	
