package day18;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCDemo4 {
	public static void main(String[] args) {
		Connection con = DBUtility.getConnection();
		Savepoint first = null;
		
		try {
				Statement stmt = con.createStatement();
				
//				int i=stmt.executeUpdate("create table users (uid int(5),uname varchar(30),upass varchar(8),flag int(1))");
				// create table customer (customerId int(5), customerName varchar(30), customerAddress varchar(20), customerAccountDetail varchar(40), customerGSTNum int(20));
//				System.out.println(i +" table created....");
//				create table user (userId int(5), userName varchar(30), password varchar(10), flag int(1));
//				create table itemMaster (ietmId int(5), itemDesc varchar(30), price int(1));
//				create table invoiceTrans (invoiceId varchar(10), itemId int (5), quantity int(3));
//				create table invoiceMaster (invoiceId varchar(10), invoiceDate DATE, customerId int(5));
				
				int i = stmt.executeUpdate("insert into itemMaster values (3, 'Labour work', 5)");
				
				System.out.println(i +" rows inserted....");
				
//				first = con.setSavepoint("first");
//				//con.commit();
//				
//				i = stmt.executeUpdate("insert into users values (3,'monu','spider',0)");
//				System.out.println(i +" rows inserted....");
//						
//				Savepoint second = con.setSavepoint("second");
//				//con.commit();
//				
//				i = stmt.executeUpdate("insert into user values (4,'monu','spider')");
//				System.out.println(i +" rows inserted....");
				
				DBUtility.closeConnection(null, null);
						
			} catch (Exception e) {
				DBUtility.closeConnection(e, first);
				e.printStackTrace();
		}
	}
}
