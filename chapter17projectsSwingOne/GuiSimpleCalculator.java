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
	private static final int HEIGHT = 300;
	private static final int WIDTH = 350;
	private static final String WINDOW_NAME = "Swing Calculator";
	
	private JTextField result;
	private JTextField operand;
	
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
		setLayout(new FlowLayout());
		
		//set up JPanel variables
		JPanel opPanel = new JPanel();
		JPanel resultPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		this.result = new JTextField(10);
		result.setEditable(false);
		resultPanel.add(new JLabel("Result:"));
		resultPanel.add(result);
		JButton resetButton = new JButton("reset");
		resetButton.setName("reset");
		resultPanel.add(resetButton);
		this.add(resultPanel);
		
		this.operand = new JTextField(10);
		operand.setEditable(false);
		opPanel.add(new JLabel("Operand:"));
		opPanel.add(operand);
		JButton clearButton = new JButton("clear");
		clearButton.setName("clear");
		opPanel.add(clearButton);
		this.add(opPanel);
		
		//set up buttons
		JButton anonymousButton;
		buttonsPanel.setLayout(new GridLayout(4, 3));
		for(int i = 0; i<=9; i++)
		{
			anonymousButton = new JButton(""+i);
			anonymousButton.addActionListener(this);
			buttonsPanel.add(anonymousButton);
		}
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton times = new JButton("*");
		JButton div = new JButton("/");
		buttonsPanel.add(plus);
		buttonsPanel.add(minus);
		buttonsPanel.add(times);
		buttonsPanel.add(div);
		this.add(buttonsPanel);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Button: " + ((JButton)arg0.getSource()).getText());
	}
}
