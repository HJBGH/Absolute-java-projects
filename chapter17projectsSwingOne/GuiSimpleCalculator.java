package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * My response to project suggestion 3 of chapter 17 of the Absolute Java Textbook.
 * 
 * @author hb
 *
 */

public class GuiSimpleCalculator extends JFrame implements ActionListener{
	//window dimension constants
	private static final int HEIGHT = 350;
	private static final int WIDTH = 600;
	private static final String WINDOW_NAME = "Swing Calculator";
	
	public static void main(String args[])
	{
		GuiSimpleCalculator jimmy = new GuiSimpleCalculator();
		jimmy.setVisible(true);
	}
	
	public GuiSimpleCalculator()
	{
		super(WINDOW_NAME);
		//set up frame
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
