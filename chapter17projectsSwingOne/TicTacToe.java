package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
			//set window properties.
			super(WINDOW_NAME);
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			
			//message display box and panel
			JPanel messagePanel = new JPanel();
			JTextField messageField = new JTextField();
			messageField.setEditable(false);
			messagePanel.add(messageField);
			this.add(messagePanel, BorderLayout.NORTH);
			
			//Set up board
			JPanel boardPanel = new JPanel();
			boardPanel.setLayout(new GridLayout(3,3));
			//JButtons
			for(int i = 0; i<6; i++)
			{
				//we don't actually need to know which button is which. we can use 
			}
		}


		@Override
		public void notify(Watchable watchable) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void notify(String news) {
			// TODO Auto-generated method stub
			//Case statements here for various events in the model
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
		//List of watchers to notify when the model changes
		ArrayList<Watcher> watchers = new ArrayList<Watcher>();

		@Override
		public void addWatcher(Watcher newWatcher) {
			watchers.add(newWatcher);
		}

		@Override
		public void notifyWatchers() {
			for(Watcher watcher : watchers)
			{
				watcher.notify(this);
			}
		}

		@Override
		public void removeAll(Watcher watcher) {
			//potential for memory leak?
			watchers = new ArrayList<Watcher>();
		}

		@Override
		public void notifyWatchersOfNews(String news) {
			for(Watcher watcher : watchers)
			{
				watcher.notify(news);
			}
		}
	}

}
