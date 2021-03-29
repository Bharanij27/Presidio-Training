package day16;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.google.com/index.html");
		
		URLConnection urlCon = url.openConnection();
		
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(urlCon.getInputStream()));
		FileWriter out = new FileWriter("google.html");
		int i = 0;
		char[] c = new char[128];
		
		while((i = br.read(c)) != -1) {
			String str = new String(c, 0, i);
			System.out.print(str);
			out.write(c, 0, i);
		}
		out.close();
	}
}
