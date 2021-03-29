package day16;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddDemo {
	public static void main(String[] args) throws Exception {
//		InetAddress i6 = Inet6Address.getByName("www.yahoo.com");
//		System.out.println(i6.getHostAddress());

		InetAddress i6[] = Inet6Address.getAllByName("www.yahoo.com");
		for(InetAddress i : i6) {
			System.out.println(i.getHostAddress());
		}
	}
}
