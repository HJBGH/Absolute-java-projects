package chapter19projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter19projects.Smiley.FacePanel;

public class SpinningBall extends JFrame{
	
	public static final int WIDTH = 200; //window width;
	public static final int HEIGHT = 200; //window height;

	private int position = 0;
	private JPanel box;
	
	public static void main(String args[])
	{
		SpinningBall sb = new SpinningBall();
		
		BallDrawer bd = sb.new BallDrawer();
		sb.setVisible(true);
		bd.run();
	}
	
	public SpinningBall()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Spinny ball demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.box = new BallPanel();
		add(box, "Center");
	}

	
	private class BallDrawer extends Thread
	{
		//use fill arc for multicolored circle

		public void run()
		{
			//rotate ball,
			while(true)
			{
				for(int i = 0; i < 4; i++)
				{
					SpinningBall.this.position = i;
					SpinningBall.this.box.repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Damn.");
					}
				}
			}
		}
	}
	
	private class BallPanel extends JPanel
	{
		public static final int FILL_WIDTH = 200;
		public static final int FILL_HEIGHT = 150;
		public static final int RADIUS = 50;
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			switch(SpinningBall.this.position)
			{
			case 0:
				g.setColor(Color.BLUE);
				g.fillArc(FILL_WIDTH/2, FILL_HEIGHT/2, RADIUS, RADIUS, 0, 90);
				g.setColor(Color.RED);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 90, 90);
				g.setColor(Color.YELLOW);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 180, 90);
				g.setColor(Color.CYAN);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 270, 90);
				break;
			case 1:
				g.setColor(Color.CYAN);
				g.fillArc(FILL_WIDTH/2, FILL_HEIGHT/2, RADIUS, RADIUS, 0, 90);
				g.setColor(Color.BLUE);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 90, 90);
				g.setColor(Color.RED);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 180, 90);
				g.setColor(Color.YELLOW);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 270, 90);
				break;
			case 2:
				g.setColor(Color.YELLOW);
				g.fillArc(FILL_WIDTH/2, FILL_HEIGHT/2, RADIUS, RADIUS, 0, 90);
				g.setColor(Color.CYAN);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 90, 90);
				g.setColor(Color.BLUE);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 180, 90);
				g.setColor(Color.RED);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 270, 90);
				break;
			case 3:
				g.setColor(Color.RED);
				g.fillArc(FILL_WIDTH/2, FILL_HEIGHT/2, RADIUS, RADIUS, 0, 90);
				g.setColor(Color.YELLOW);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 90, 90);
				g.setColor(Color.CYAN);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 180, 90);
				g.setColor(Color.BLUE);
				g.fillArc((FILL_WIDTH/2), (FILL_HEIGHT/2), RADIUS, RADIUS, 270, 90);
				break;
			}
		}
	}
}
