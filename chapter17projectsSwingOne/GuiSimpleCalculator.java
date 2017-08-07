package chapter17projectsSwingOne;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * My response to project suggestion 3 of chapter 17 of the Absolute Java Textbook.
 * Trying to implement MVC style pattern here.
 * @author hb
 *
 */
//TODO; rethink using MVC for a simple calculator. what was I thinking when I made this stub code last night?
public class GuiSimpleCalculator {

	private class Model extends java.util.Observable
	{
		
	}
	
	private class View implements java.util.Observer
	{

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class Controller implements java.awt.event.ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
