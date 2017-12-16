package chapter19projects;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Chat client for chapter 19 project 8, entire project doesn't work.
 * @author hb
 *
 */
public class BasicChatClient {
	private int port = 0;
	private String server_ip = "";
	private Socket socket;
	BufferedReader serverIn;
	BufferedReader localIn;
	DataOutputStream localOut;
	
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
			bcc.talk();
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
		
		serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		localIn = new BufferedReader(new InputStreamReader(System.in));
		localOut = new DataOutputStream(socket.getOutputStream());
		
		System.out.println("Connection established, send messages when ready");
	}
	
	//This function is poorly named, but it handles listening and writing to and from the server
	public void talk() throws IOException
	{
		//First create a new thread to listen to the server
		Thread listener = new Thread(){
			public void run(){
				while(true)
				{
					System.out.println("Starting listener thread");
					String incomingMessage = null;
					try {
						incomingMessage = serverIn.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("read failure caught");
						e.printStackTrace();
					}
					if(incomingMessage != null)
					{
						System.out.print("Message recieved: ");
						System.out.println(incomingMessage);
					}
				}
			}
		};
		listener.start();
		
		while(true)
		{
			//READLINE OPERATIONS ARE BLOCKING, HOW COULD I BE SO STUPID?
			
			String outgoingMessage = localIn.readLine();
			System.out.println("Does this even run?");
			
			if(outgoingMessage != null)
			{
				System.out.print("Message sent: ");
				System.out.println(outgoingMessage);
				localOut.writeBytes(outgoingMessage);
			}	
		}
	}
}
