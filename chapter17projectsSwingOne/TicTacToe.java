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
		//init all the stuff
		TicTacToe tictactoe = new TicTacToe();
		TicTacToe.View theView = tictactoe.new View();
		TicTacToe.Model theModel = tictactoe.new Model();
		theModel.addWatcher(theView);
		TicTacToe.Controller theController = tictactoe.new Controller(theView, theModel);
		
	}

	//This should Implement some sort of listener that listens to changes in the model.
	private class View extends JFrame implements Watcher
	{
		private static final int HEIGHT = 200;
		private static final int WIDTH = 150;
		private static final String WINDOW_NAME = "Tic-Tac-Toe";
		protected JButton buttons[] = new JButton[BOARD_HEIGHT*BOARD_WIDTH];
		private JTextField messageField;
		
		public View()
		{
			//set window properties.
			super(WINDOW_NAME);
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			
			//message display box and panel
			JPanel messagePanel = new JPanel();
			this.messageField = new JTextField();//we need to edit the contents of this later, so it has to be a member
			messageField.setEditable(false);
			messagePanel.add(messageField);
			this.add(messagePanel, BorderLayout.NORTH);
			
			//Set up board
			JPanel boardPanel = new JPanel();
			boardPanel.setLayout(new GridLayout(BOARD_HEIGHT,BOARD_WIDTH));
			//JButtons
			for(int i = 0; i<BOARD_HEIGHT*BOARD_WIDTH; i++)
			{
				buttons[i] = new JButton(" ");
				boardPanel.add(buttons[i]); //add the newly created button to the boardpanel. 
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
			System.out.println("Here's your news you dumb bastard: " + news);
			switch(news)
			{
			case("DRAW"):
				messageField.setText("DRAW");
				break;
			case("OWINS"):
				messageField.setText("O Wins!");
				for(JButton button : buttons)
				{
					button.setEnabled(false);
				}
				break;
			case("XWINS"):
				messageField.setText("X Wins!");
				for(JButton button : buttons)
				{
					button.setEnabled(false);
				}
				break;			
			default:
				System.out.println("Default case entered.");
				int buttonNum = Integer.parseInt(news.substring(1));
				buttons[buttonNum].setText(news.substring(0,1));
			}
		}
	}
	
	private class Controller implements ActionListener 
	{
		View theView;
		Model theModel;
		public Controller(View theView, Model theModel)
		{
			this.theView = theView;
			this.theModel = theModel;
			
			for(JButton button : theView.buttons)
			{
				button.addActionListener(this);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton source = (JButton)arg0.getSource(); //idk if it's safe to be casting like this.
			int cell = 0;
			source.setEnabled(false);
			for(JButton button : theView.buttons)
			{
				if(button == source)
				{
					theModel.placeMark(cell);
				}
				cell++;
			}
		}
		
	}
	
	private class Model implements Watchable
	{
		//List of watchers to notify when the model changes
		ArrayList<Watcher> watchers = new ArrayList<Watcher>();
		private static final char EKS = 'X';
		private static final char OH = 'O';
		private int turn = 1;
		//I represent the board here as a one dimensional array, each group of three is one row in the board.
		private char board[] = new char[BOARD_HEIGHT*BOARD_WIDTH];
		
		/**Main method for acting upon the model, provide an int and the model will automatically assign a 
		 * mark to the corresponding board cell based on the current turn. X always goes on odd turns, O on even.
		 */
		public void placeMark(int cell){
			System.out.println("turn: " + turn);
			if(turn%2==0)
			{
				board[cell]=OH;
				notifyWatchersOfNews(OH + Integer.toString(cell));
			}
			else
			{
				board[cell]=EKS;
			    notifyWatchersOfNews(EKS + Integer.toString(cell));
			}
			checkForWin();
			turn+=1;
		}
			
		
		public void checkForWin()
		{
			//really what we need is a message object
			//you'll not need to check who wins here.
			if(turn < 5)
				return;
			//check for horizontal wins
			for(int i = 0; i<=6; i+=3)
			{
				if((board[i] == board[i+1] && board[i+1] == board[i+2]) && board[i] != '\u0000' )
				{
					System.out.println("Winrar:" + board[i]);
					notifyWatchersOfNews(Character.toString(board[i]) + "WINS");
					return; 
				}
			}
			for(int i = 0; i<=2; i++)
			{
				
			}
			if(turn >= 9)
				notifyWatchersOfNews("DRAW");
		}
		
		@Override
		public void addWatcher(Watcher newWatcher)
		{
			watchers.add(newWatcher);
		}

		@Override
		public void notifyWatchers() 
		{
			for(Watcher watcher : watchers)
			{
				watcher.notify(this);
			}
		}

		@Override
		public void removeAll(Watcher watcher) 
		{
			//potential for memory leak?
			watchers = new ArrayList<Watcher>();
		}

		@Override
		public void notifyWatchersOfNews(String news) 
		{
			for(Watcher watcher : watchers)
			{
				watcher.notify(news);
			}
		}
	}

}
