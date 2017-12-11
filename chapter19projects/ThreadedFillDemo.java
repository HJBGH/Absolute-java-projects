package chapter19projects;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter19misc.Nonresponsive_gui_demo;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadedFillDemo extends JFrame implements ActionListener
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
		ThreadedFillDemo tfd = new ThreadedFillDemo();
		tfd.setVisible(true);
	}
	
	public ThreadedFillDemo()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Fill Demo");
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
		Packer packerThread = new Packer();
		packerThread.start();
	}
	
	private class Packer extends Thread
	{
		public void run()
		{
			Graphics g = box.getGraphics(); //I don't like referring to the box variable like this.
		
			for(int y = FILL_HEIGHT; y > 0; y = y-CIRCLE_SIZE)
				for(int x = 0; x < FILL_WIDTH; x = x+CIRCLE_SIZE)
				{
					if(x%30 == 0)
					{
						g.setColor(Color.BLUE);
					}
					else if(x%20 == 0)
					{
						g.setColor(Color.RED);
					}
					else
					{
						g.setColor(Color.WHITE);
					}
					g.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
					doNothing(PAUSE); //pause execution for 100 milliseconds
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
