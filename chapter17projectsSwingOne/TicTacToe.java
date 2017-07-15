package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Response to project 2 of chapter 17 of the Absolute Java textbook.
 * @author hb
 * For shits and giggles I'm trying to implement this with MVC.
 * It doesn't work exactly but the idea is that the controller makes changes to the model after
 * catching events thrown by the parts of the view, the model then throws events which are caught 
 * by the view which it uses to update itself. It's probably a bit to convoluted to be considered
 * proper MVC. An implementation of the observer pattern is used to make the View watch the model.
 */
public class TicTacToe{
	
	public static void main(String args[])
	{
		//init all the shit
		View theView = new View();
		theView.setVisible(true);
	}

	//This should Implement some sort of listener that listens to changes in the model.
	private static class View extends JFrame implements Watcher
	{
		private static final int HEIGHT = 300;
		private static final int WIDTH = 200;
		private static final String WINDOW_NAME = "Tic-Tac-Toe";
		
		
		public View()
		{
			super(WINDOW_NAME);
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
		}


		@Override
		public void notify(Watchable watchable) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void notify(String news) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private static class Controller implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static class Model implements Watchable
	{

		@Override
		public void addWatcher(Watcher watcher) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void notifyAll(Watcher watcher) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeAll(Watcher watcher) {
			// TODO Auto-generated method stub
			
		}
		//this will have all the data about the game in it
	}

}
