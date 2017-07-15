package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Response to project 2 of chapter 17 of the Absolute Java textbook
 * @author hb
 *
 */
public class TicTacToe{
	
	public static void main(String args[])
	{
		//init all the shit
		View theView = new View();
		theView.setVisible(true);
	}

	private static class View extends JFrame
	{
		private static final int HEIGHT = 200;
		private static final int WIDTH = 100;
		private static final String WINDOW_NAME = "Tic-Tac-Toe";
		
		
		public View()
		{
			super(WINDOW_NAME);
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
		}
	}
	
	private static class Controller implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static class Model
	{
		//this will have all the data about the game in it
	}

}
