package chapter19projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Smiley extends JFrame implements Runnable{

	public static final int WIDTH = 800; //window width;
	public static final int HEIGHT = 500; //window height;
	public static final int FILL_WIDTH = 500;
	public static final int FILL_HEIGHT = 200;
	public static final int FACE_SIZE = 150;
	public static final int EYE_SIZE = 10;
	public static final int PAUSE = 1000; //100 millisecond pause duration
	
	private JPanel box;
	
	public static void main(String args[])
	{
		System.out.println("Running Smiley Frowny thread demo");
		Smiley s = new Smiley();
		s.setVisible(true);
		s.startThread();
	}
	
	public Smiley()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Smiley thread demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.box = new JPanel();
		add(box, "Center");
	}
	
	@Override
	public void run() {
		Graphics g = box.getGraphics();
		g.setColor(Color.YELLOW);
		System.out.println(g.getColor());
		
		g.fillRect(20, 20, 100, 100);
		g.fillOval(FILL_WIDTH-FACE_SIZE, FILL_HEIGHT-FACE_SIZE, FACE_SIZE, FACE_SIZE);
		g.setColor(Color.BLACK);
		g.fillOval(WIDTH-FACE_SIZE-(EYE_SIZE/2), HEIGHT-FACE_SIZE, EYE_SIZE, EYE_SIZE);
		g.fillOval(WIDTH-FACE_SIZE+(EYE_SIZE/2), HEIGHT-FACE_SIZE, EYE_SIZE, EYE_SIZE);
		System.out.println("drawface");
		while(true)
		{
			drawSmile();
			doNothing(PAUSE);
			drawFrown();
			doNothing(PAUSE);
		}
	}
	
	private void drawSmile()
	{
		Graphics g = this.box.getGraphics();
		//g.drawArc(x, y, width, height, startAngle, arcAngle);
	}
	
	private void drawFrown()
	{
		System.out.println("Drawing frown");
	}

	public void doNothing(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException e)
		{
			System.out.print("Unexpected interrupt");
			System.exit(0);
		}
	}
	
	public void startThread()
	{
		Thread thisThread = new Thread(this);
		thisThread.start();
	}
}
