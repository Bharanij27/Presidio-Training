package JDBCLab;

import java.util.*;
import java.sql.*;
public class Ex14 {
	public static void main(String st1[]) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Enumeration e = DriverManager.getDrivers();
		System.out.println(" " +DriverManager.getLoginTimeout());
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
	}
}
