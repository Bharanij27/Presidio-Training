package day18;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class DBUtility {
	
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	private static Connection con;
	private static String url,username,password;

	private DBUtility() {
		// TODO Auto-generated constructor stub
	}
	static {
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("dbconfig.properties"));
			String driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	synchronized public static Connection getConnection() {
		con=tlocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection(url,username,password);
				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	synchronized public static void closeConnection(Exception e, Savepoint s) {
		con=tlocal.get();
		if(con!=null) {
			try {
				if(e == null)con.commit();
				else {
					if(s == null) con.rollback();
					else {
						con.rollback(s);
						con.commit();
					}
				}
				con.close();
				tlocal.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}