package chapter19projects;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * This is basic chat server implemented according the requirements outlined
 * in chapter 19 project 8 of Walter Savitch's Absolute Java. This is really 
 * basic architecture without proper safeguards in place for race conditions
 * nor buffer lengths and other problems that may arise.
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
		 
		
		ServerSocket ss = new ServerSocket(this.port);
		
		while(true) //I prefer this to for(;;), it's easier to read.
		{
			System.out.println("Now listening on port number: " + this.port);
			Socket clientConnection = ss.accept();
			CommsHandler comms = new CommsHandler(clientConnection);
			this.handlers.add(comms);
			comms.run();
		}
	}
	
	private class CommsHandler extends Thread
	{
		Socket connection;
		DataOutputStream dos; //dos for Data Output Stream
		BufferedReader in;
		
		public CommsHandler(Socket newConnection)
		{
			connectionCount++; //I shouldn't be incrementing this here
			this.connection = newConnection;
			try {
				dos = new DataOutputStream(connection.getOutputStream());
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				System.out.println("new connection established, connection number: " + connectionCount);
			} catch (IOException e) {
				//man I hope InetAddresses have a toString function.
				System.out.println("connection from " + connection.getInetAddress() + " failed.");
				e.printStackTrace();
			}
		}
		
		public void run()
		{
			boolean run = true;
			System.out.println("connection handler running.");
			try {
				System.out.println("Trying to send welcome");
				dos.writeBytes("Welcome to the chat server!");
			} catch (IOException e) {
				System.out.println("DAMNIT");
				run = false;
				e.printStackTrace();
			}
			String message;
			while(run)
			{
				try
				{
					if((message = in.readLine()) != null)
					{
						//broadcast message to all listeners
						System.out.println("Broadcasting message '"+ message + "' to all users.");
						for(CommsHandler handler : handlers)
						{
							if(handler != this)//hopefully this won't cause any problems 
							{
								handler.dos.writeBytes(message);
							}
						}
					}
				}
				catch (IOException ioe)
				{
					System.out.println("Something died while a message was being read or broadcasted");
					//operating under the assumption that the connection has just been dropped.
					run = false;
				}
			}
			//eventually there will be a case where run will need to be false.
			//close everything when it comes. I need to figure out how to poll for a dead connections
			try
			{
				dos.close();
				in.close();
			}
			catch(IOException ioeTwoElectricBoogaloo) //DAMNIT
			{
				//Honestly I don't know how to properly structure this, these nested 
				//try - catch statements are hideous.
			}
			handlers.remove(this); //removed reference to the thread from the handler pool.
		}
	}
}
