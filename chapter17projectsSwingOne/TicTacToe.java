package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
	private static final int BOARD_HEIGHT = 3;
	private static final int BOARD_WIDTH = 3;
	
	public static void main(String args[])
	{
		//init all the shit
		//View theView = new View();
		TicTacToe tictactoe = new TicTacToe();
		TicTacToe.Controller theController = tictactoe.new Controller();
		TicTacToe.View theView = tictactoe.new View(theController);
	}

	//This should Implement some sort of listener that listens to changes in the model.
	private class View extends JFrame implements Watcher
	{
		private static final int HEIGHT = 200;
		private static final int WIDTH = 150;
		private static final String WINDOW_NAME = "Tic-Tac-Toe";
		private JButton buttons[][] = new JButton[BOARD_HEIGHT][BOARD_WIDTH];
		private Controller the_controller;
		
		public View(Controller controller)
		{
			//set window properties.
			super(WINDOW_NAME);
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			the_controller = controller;
			
			//message display box and panel
			JPanel messagePanel = new JPanel();
			JTextField messageField = new JTextField();
			messageField.setEditable(false);
			messagePanel.add(messageField);
			this.add(messagePanel, BorderLayout.NORTH);
			
			//Set up board
			JPanel boardPanel = new JPanel();
			boardPanel.setLayout(new GridLayout(BOARD_HEIGHT,BOARD_WIDTH));
			//JButtons
			for(int i = 0; i<BOARD_HEIGHT; i++)
			{
				for(int k = 0; k<BOARD_WIDTH; k++)
				{
					buttons[i][k] = new JButton(" ");
					buttons[i][k].addActionListener(the_controller);
					boardPanel.add(buttons[i][k]); //add the newly created button to the boardpanel. 
				}
			}
			this.add(boardPanel, BorderLayout.CENTER);
			this.setVisible(true);
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
	
	private class Controller implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("A button was clicked");
		}
		
	}
	
	private class Model implements Watchable
	{
		//List of watchers to notify when the model changes
		ArrayList<Watcher> watchers = new ArrayList<Watcher>();
		private char board[][] = new char[BOARD_HEIGHT][BOARD_WIDTH];
		
		
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
