package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	ServerSocket ss;
	Socket s;
	public Server() throws Exception{
		
		ss = new ServerSocket(2000);
		System.out.println("Server ready.....");
		while(true) {
			s = ss.accept();
			new ClientHandler(s);
			
		}
	}
	public static void main(String[] args) throws Exception{
		new Server();
	}
}


class ClientHandler{
	Socket client;
	BufferedReader br,in;
	PrintWriter out;
	static Map<String, Socket> clientThreads = new HashMap<String, Socket>();
	
	public ClientHandler(Socket client) throws Exception {
		String clientID = Integer.toString((int)(Math.random() * (9999 - 1000)) + 1000);
		clientThreads.put(clientID, client);
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		this.client = client;
		out = new PrintWriter(client.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(System.in));

		greetingMessage(clientID);		
		
		es.execute(() -> {			
			try {
				while(true) {					
					sendMessage();
					br = new BufferedReader(new InputStreamReader(client.getInputStream()));
					System.out.println("Server message: ");
					String msg = br.readLine();
					if(msg !=null) System.out.println("Message From Client..:"+msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				es.shutdown();
			}
		});
	}
	
	private void sendMessage() throws IOException {
		String msgToClient;
		System.out.println("Enter Message For Client..:");
		if((msgToClient = in.readLine()).length() !=0){	
			String[] arrOfStr = msgToClient.split("-", 2);
			Socket currentClient = clientThreads.get(arrOfStr[0]);
			if(currentClient != null) {				
				PrintWriter clinetOut = new PrintWriter(currentClient.getOutputStream(), true);
				clinetOut.println(arrOfStr[1]);
			}
			else {
				for(Socket s : clientThreads.values()) {
					PrintWriter clientOut = new PrintWriter(s.getOutputStream(), true);
					clientOut.println(arrOfStr[1]);
				}
			}
		}
	}

	public void greetingMessage(String id) {
		System.out.println("On server" + id);
		out.println(id + " is your id");
	}
}