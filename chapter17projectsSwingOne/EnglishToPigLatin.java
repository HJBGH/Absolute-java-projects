package chapter17projectsSwingOne;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Response to project suggestion 1 of chapter 17 of Absolute Java 
 * @author hb
 *
 */
public class EnglishToPigLatin extends JFrame{
	//window dimension constants
	private static final int HEIGHT = 300;
	private static final int WIDTH = 400;
	private static final String WINDOW_NAME = "English -> Pig Latin";
	private JTextField infield;
	
	public static void main(String args[]){
		EnglishToPigLatin gooey = new EnglishToPigLatin();

	}
	
	public EnglishToPigLatin(){
		super(WINDOW_NAME);
		
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		this.setVisible(true);
	}
	
	private static class Translator
	{
		//write translation bits in here.
	}

}
