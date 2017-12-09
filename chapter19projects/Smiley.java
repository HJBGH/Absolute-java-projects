package chapter19projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Smiley extends JFrame
{

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
		this.box = new FacePanel();
		add(box, "Center");
	}
	
	public void startThread()
	{
		Drawer d = new Drawer();
		d.start();
	}
	
	public class FacePanel extends JPanel //I HATE JAVA SOMETIMES
	{
		private boolean smile = false;
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.YELLOW);
			g.fillOval(FILL_WIDTH-FACE_SIZE, FILL_HEIGHT-FACE_SIZE, FACE_SIZE, FACE_SIZE);
			g.setColor(Color.BLACK);
			g.fillOval((FILL_WIDTH-FACE_SIZE) +((FACE_SIZE / 3)), FILL_HEIGHT-FACE_SIZE + (FACE_SIZE / 3), EYE_SIZE, EYE_SIZE);
			g.fillOval((FILL_WIDTH-FACE_SIZE) +(((FACE_SIZE / 3) * 2)), FILL_HEIGHT-FACE_SIZE + (FACE_SIZE / 3), EYE_SIZE, EYE_SIZE);
			
			int x = (FILL_WIDTH-FACE_SIZE) +((FACE_SIZE / 3) );
			int y = (FILL_HEIGHT-FACE_SIZE) + (FACE_SIZE / 2);
			
			if(smile == true)
			{
				System.out.println("Smiling");
				g.drawArc(x, y, FACE_SIZE/2, FACE_SIZE/4, 180, 180);
			}
			else
			{
				System.out.println("Frowning");
				g.drawArc(x, y, FACE_SIZE/2, FACE_SIZE/4, 0, 180);
			}
		}
		
		public void drawSmile()
		{
			this.smile = true;
			repaint();
		}
		
		public void drawFrown()
		{
			this.smile = false;
			repaint();
		}
	}
	
	private class Drawer extends Thread
	{
		public void run()
		{
			while(true)
			{
				((FacePanel) box).drawSmile();
				doNothing(PAUSE);
				((FacePanel) box).drawFrown();
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
