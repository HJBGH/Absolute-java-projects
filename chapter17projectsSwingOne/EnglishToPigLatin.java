package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Response to project suggestion 1 of chapter 17 of Absolute Java 
 * @author hb
 *
 */
public class EnglishToPigLatin extends JFrame implements ActionListener{
	//window dimension constants
	private static final int HEIGHT = 300;
	private static final int WIDTH = 600;
	private static final String WINDOW_NAME = "English -> Pig Latin";
	private static final int IN_LENGTH = 32;
	private JTextField infield;
	
	public static void main(String args[]){
		EnglishToPigLatin gooey = new EnglishToPigLatin();
		gooey.setVisible(true);
	}
	
	public EnglishToPigLatin(){
		super(WINDOW_NAME);
		//set up frame
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//set up input panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
	    
		//set up input field and label
		infield = new JTextField(IN_LENGTH);
		JLabel aLabel = new JLabel("Enter english here:");
		
		inputPanel.add(infield, BorderLayout.EAST);
		inputPanel.add(aLabel, BorderLayout.WEST);
		
		//set up button panel and button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton translateThisShit = new JButton("Click this to translate.");
		translateThisShit.addActionListener(this);
		buttonPanel.add(translateThisShit);
		
		//add elements to window in the order you want them to appear (flow layout)
		this.add(inputPanel);
		this.add(buttonPanel);
		
	}
	
	private static class Translator
	{
		//write translation bits in here.
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Ich brauche mehr Suessigkeiten.");
	}

}
