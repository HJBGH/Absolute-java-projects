package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Response to project suggestion 1 of chapter 17 of Absolute Java 
 * @author hb
 *
 */
public class EnglishToPigLatin extends JFrame implements ActionListener{
	//window dimension constants
	private static final int HEIGHT = 350;
	private static final int WIDTH = 600;
	private static final String WINDOW_NAME = "English -> Pig Latin";
	private static final int CHARS_PER_LINE = 32;
	private static final int LINES = 5;
	private JTextArea infield;
	private JTextArea outfield;
	
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
		infield = new JTextArea(LINES, CHARS_PER_LINE);
		JLabel aLabel = new JLabel("Enter English here:");
		
		inputPanel.add(infield, BorderLayout.EAST);
		inputPanel.add(aLabel, BorderLayout.WEST);
		
		//set up button panel and button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton translateThisShit = new JButton("Click this to translate.");
		translateThisShit.addActionListener(this);
		buttonPanel.add(translateThisShit);
		
		//set up output Panel and contained elements
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		outfield = new JTextArea(LINES*2, CHARS_PER_LINE); //It's lazy to multiply lines by a magic number
		JLabel anotherLabel = new JLabel("Read Pig Latin here:");
		
		outputPanel.add(outfield, BorderLayout.EAST);
		outputPanel.add(anotherLabel, BorderLayout.WEST);
		
		//add elements to window in the order you want them to appear (flow layout)
		this.add(inputPanel);
		this.add(buttonPanel);
		this.add(outputPanel);
		
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
