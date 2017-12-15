package chapter19projects;

/**
 * Chat client for chapter 19 project 8
 * @author hb
 *
 */
public class BasicChatClient {
	private int port = 0;
	private String server_ip = "";
	
	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.err.println("This program takes arguments <server ip-address> <port number>");
			System.exit(0); //incorrect number of arguments
		}
	}
	
	public BasicChatClient(String[] args)
	{
		this.port = Integer.parseInt(args[1]);
		this.server_ip = args[0];
	}
	
	
	//this will probably be more monolithic than it should be
	public void connect()
	{
		
	}
}
