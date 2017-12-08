package chapter19misc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//underscores in the class name shouldn't be done in serious code.
public class Nonresponsive_gui_demo extends JFrame implements ActionListener
{
	public static final int WIDTH = 300; //window width;
	public static final int HEIGHT = 200; //window height;
	public static final int FILL_WIDTH = 300;
	public static final int FILL_HEIGHT = 100;
	public static final int CIRCLE_SIZE = 10;
	public static final int PAUSE = 100; //100 millisecond pause duration
	
	private JPanel box;
	
	public static void main(String[] args)
	{
		Nonresponsive_gui_demo ngd = new Nonresponsive_gui_demo();
		ngd.setVisible(true);
	}
	
	public Nonresponsive_gui_demo()
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
		fill();
	}
	
	public void fill()
	{
		Graphics g = this.box.getGraphics();
		
		for(int y = 0; y < FILL_HEIGHT; y = y+CIRCLE_SIZE)
			for(int x = 0; x < FILL_WIDTH; x = x+CIRCLE_SIZE)
			{
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

