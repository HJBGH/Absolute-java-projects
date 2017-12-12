package chapter19projects;

import java.util.Date;
import java.net.ServerSocket;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

//modified from project 19.6 to project 19.7
public class SimpleWebServer {
	
	
	private int connectionCount = 0;
	static final String body = "<html><title> Java Server</title> This web page was sent by our simple <b>" +
	"Java Server</b></html>";
	
	public static void main(String args[]) throws IOException
	{
		SimpleWebServer sws = new SimpleWebServer();
		sws.serve();
	}
	
	public void serve() throws IOException
	{
		ServerSocket serverSock = new ServerSocket(8000);

		while(true)
		{
			System.out.println("waiting for broswer");
			Socket connection = serverSock.accept();
			
			Handler handler = new Handler(connection);
			handler.run();
		}
	}
	
	//connection handler
	public class Handler extends Thread
	{
		Socket connection;

		public Handler(Socket connection)
		{
			this.connection = connection;
		}
		
		public void run()
		{
			//do stuff with the connection
			connectionCount++;
			System.out.println("Started new thread");
			try
			{
				DataOutputStream output = new DataOutputStream(
					connection.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				//read the request before you respond idiot.
				String str = in.readLine();
		        while (!str.equals(""))
		        	str = in.readLine();
		        
				System.out.println("Browser connected, send info to connection number: " + connectionCount);			
				output.writeBytes("HTTP/1.0 200 OK\n\n" + body);
				
				System.out.println("Info sent");
				//while(connection.isConnected());
				
				connection.close();
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
				System.out.println("dead");
			}
		}
	}
}
