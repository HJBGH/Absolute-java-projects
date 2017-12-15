package chapter19projects;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Chat client for chapter 19 project 8
 * @author hb
 *
 */
public class BasicChatClient {
	private int port = 0;
	private String server_ip = "";
	private Socket socket;
	
	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.err.println("This program takes arguments <server ip-address> <port number>");
			System.exit(0); //incorrect number of arguments
		}
		BasicChatClient bcc = new BasicChatClient(args);
		try
		{
			bcc.connect();
		}
		catch(IOException ioe)
		{
			System.err.print(ioe.getMessage());
			System.out.println("Connection failed");
			System.exit(0);
		}
	}
	
	public BasicChatClient(String[] args)
	{
		this.port = Integer.parseInt(args[1]);
		this.server_ip = args[0];
	}
	
	
	//this will probably be more monolithic than it should be
	private void connect() throws IOException
	{
		System.out.println("Connecting to server.");
		socket = new Socket(this.server_ip, this.port);
		
		BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream clientOut = new DataOutputStream(socket.getOutputStream());
		
		System.out.println("Connection established, send messages when ready");
		
		while(true)
		{
			String incomingMessage;
			String outgoingMessage;
			if((incomingMessage = serverIn.readLine()) != null)
			{
				System.out.println(incomingMessage);
			}
			if((outgoingMessage = clientIn.readLine()) != null)
			{
				System.out.println(outgoingMessage);
			}	
		}
	}
}
