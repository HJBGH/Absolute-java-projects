package chapter19projects;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * This is basic chat server implemented according the requirements outlined
 * in chapter 19 project 8 of Walter Savitch's Absolute Java.
 * @author hb
 *
 */
public class BasicChatServer {

	private int connectionCount = 0;
	private static final String WELCOME = "Welcome to a chat server";
	private int port = -1;//it's probably bad practise to do this.
	private ArrayList<CommsHandler> handlers;
	
	public BasicChatServer(String[] args) {
		this.port = Integer.parseInt(args[0]);
		this.handlers = new ArrayList<CommsHandler>();
	}

	public static void main(String args[])
	{
		//server is created to listen on the port provided in the argument
		if(args.length != 1)
		{
			System.err.println("This chat server program takes a listening port number as an argument");
			System.exit(0); //wrong argument count
		}
		BasicChatServer bcs = new BasicChatServer(args);
		try
		{
			bcs.serve();
		}
		catch(IOException ioe)
		{
			System.out.println("Failed to construct socket on port " + bcs.port);
		}
	}

	private void serve() throws IOException
	{
		System.out.println("Now listening on port number: " + this.port); 
		
		ServerSocket ss = new ServerSocket(this.port);
		
		while(true) //I prefer this to for(;;), it's easier to read.
		{
			Socket clientConnection = ss.accept();
			CommsHandler comms = new CommsHandler(clientConnection);
			this.handlers.add(comms);
			comms.run();
		}
	}
	
	private class CommsHandler extends Thread
	{
		Socket connection;
		
		public CommsHandler(Socket newConnection)
		{
			connectionCount++; //I shouldn't be incrementing this here
			this.connection = newConnection;
		}
		
		public void run()
		{
			
		}
	}
}
