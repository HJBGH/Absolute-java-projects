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
	private static final int TEXT_FIELD_WIDTH = 15;
	
	private JTextField resultJTF;
	private JTextField operandJTF;
	
	private double result = 0; //initialize the variables to avoid problems later
	private double operand = 0;
	
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
		
		this.resultJTF = new JTextField(TEXT_FIELD_WIDTH);
		resultJTF.setEditable(false);
		resultPanel.add(new JLabel("Result:"));
		resultPanel.add(resultJTF);
		JButton resetButton = new JButton("reset");
		resetButton.setName("reset");
		resetButton.addActionListener(this);
		resultPanel.add(resetButton);
		this.add(resultPanel);
		
		this.operandJTF = new JTextField(TEXT_FIELD_WIDTH);
		operandJTF.setEditable(false);
		opPanel.add(new JLabel("Operand:"));
		opPanel.add(operandJTF);
		JButton clearButton = new JButton("clear");
		clearButton.setName("clear");
		clearButton.addActionListener(this);
		opPanel.add(clearButton);
		this.add(opPanel);
		
		//set up and add number buttons
		JButton anonymousButton;
		buttonsPanel.setLayout(new GridLayout(4, 3));
		for(int i = 0; i<=9; i++)
		{
			anonymousButton = new JButton(""+i);//""+1 works as weird hacky string conversion
			anonymousButton.addActionListener(this);
			buttonsPanel.add(anonymousButton);
		}
		//add operation buttons
		JButton plus = new JButton("+");
		plus.addActionListener(this);
		JButton minus = new JButton("-");
		minus.addActionListener(this);
		JButton times = new JButton("*");
		times.addActionListener(this);
		JButton div = new JButton("/");
		div.addActionListener(this);
		//no equals buttons, operations are performed when their related button is pressed
		buttonsPanel.add(plus);
		buttonsPanel.add(minus);
		buttonsPanel.add(times);
		buttonsPanel.add(div);
		this.add(buttonsPanel);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Button: " + ((JButton)arg0.getSource()).getText());
		//we could just use a massive switch statement in here
		try{
			Integer.parseInt(((JButton)arg0.getSource()).getText()); //ppor use of parseInt, but it gets the job done
			operandJTF.setText(operandJTF.getText() + ((JButton)arg0.getSource()).getText());
		}
		catch (Exception e)
		{
			//empty catch block
		}
		try{
			switch(((JButton)arg0.getSource()).getText())
			//find the operation
			{
			case "+":
				operand = Double.parseDouble(operandJTF.getText());
				operandJTF.setText("");
				result = result+operand;
				resultJTF.setText(""+result); // ""+result functions as hacky int -> string conversion
				break;
			default:
				System.out.println("FUCK");
			}
		} catch (Exception e)
		{
			//empty catch for now.
		}
	}
}
