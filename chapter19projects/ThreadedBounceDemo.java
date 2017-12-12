package chapter19projects;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class ThreadedBounceDemo extends JFrame implements ActionListener
{
	public static final int WIDTH = 500; //window width;
	public static final int HEIGHT = 300; //window height;
	public static final int FILL_WIDTH = 500;
	public static final int FILL_HEIGHT = 200;
	public static final int CIRCLE_SIZE = 10;
	public static final int PAUSE = 100; //100 millisecond pause duration
	
	private JPanel box;
	
	public static void main(String[] args)
	{
		ThreadedBounceDemo tbd = new ThreadedBounceDemo();
		tbd.setVisible(true);
	}
	
	public ThreadedBounceDemo()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Bounce Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.box = new JPanel();
		add(box, "Center");
		JPanel buttonPanel = new JPanel();
		JButton startButton = new JButton("Start");
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
		add(buttonPanel, "South");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Bouncer b = new Bouncer();
		b.start();
	}
	
	private class Bouncer extends Thread
	{
		Random rand = new Random();
		private double ball_x = FILL_WIDTH/2;
		private double ball_y = FILL_HEIGHT/2;
		private int gs = CIRCLE_SIZE/2; //gs for geschwindigkeit
		private double v = rand.nextInt(360);
		
		
		public void run()
		{
			Graphics g = box.getGraphics(); //I don't like referring to the box variable like this.
			
			while(true)
			{
				//check boundaries.
				if(ball_x + CIRCLE_SIZE >= FILL_WIDTH || ball_x <= 0)
				{
					v = rand.nextInt(360);
				}
				if(ball_y + CIRCLE_SIZE >= FILL_HEIGHT || ball_y <= 0)
				{
					v = rand.nextInt(360);
				}
				//increment position.
				ball_x = ball_x + gs * Math.sin(Math.toRadians(v));
				ball_y = ball_y + gs * Math.cos(Math.toRadians(v));
				g.setXORMode(getBackground());
				//I need to redefine paint_component to get this working properly.
				g.fillOval((int)ball_x, (int)ball_y, CIRCLE_SIZE, CIRCLE_SIZE);
				doNothing(PAUSE);
			}
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
	}
	
}

