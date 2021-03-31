package JDBCLab;

import java.sql.*;

import day18.DBUtility;
public class dataInfo {
      public static void main(String st[])
      {
		try {
			Connection con = DBUtility.getConnection();
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("DatabaseProductName : " + dbmd.getDatabaseProductName());
			System.out.println("DatabaseProductVersion : " + dbmd.getDatabaseProductVersion());
			System.out.println("getStringFunctions : " + dbmd.getStringFunctions());
			System.out.println("DriverMajorVersion : " + dbmd.getDriverMajorVersion());
			System.out.println("DriverMinorVersion : " + dbmd. getDriverMinorVersion ());
			System.out.println("DriverName : " + dbmd.getDriverName ());
			System.out.println("SQLKeywords : " + dbmd.getSQLKeywords());
			DBUtility.closeConnection(null, null);
		}catch(Exception e){ 
			e.printStackTrace();
		}
	} 
}