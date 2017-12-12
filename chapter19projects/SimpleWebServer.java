package chapter19projects;

public class SimpleWebServer {
	
	static final String body = "<html><title> Java Server</title> This web page was sent by our simple <b>" +
	"Java Server</b></html>";
	
	public static void main(String args[])
	{
		SimpleWebServer sws = new SimpleWebServer();
		sws.serve();
	}
	
	public void serve()
	{
		
	}
}
