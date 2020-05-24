package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;

import javax.swing.*;
import models.*;

public class Frame {
	
	//INSTANCE VARIABLES
	private JFrame _frame;
	private JPanel _pan;
	private JButton[][] _labMaze;
	private SeatingChart _s;
	private String _str;
	
	//CONSTRUCTORS
	public Frame(SeatingChart s, String str) {
		_s = s;
		_str = str;
		setupButtons();
		setupPanel();
		setupFrame();
	}
	
	/*
	 * This method sets up the frame for the seating chart. It does
	 * not allow for resizing, lets you exit the program
	 * upon closing, sets the background of the frame, sets 
	 * the bounds for the frame, sets the icon for the frame,
	 * and sets the decoration of the frame. 
	 */
	private void setupFrame() {
		_frame = new JFrame(_str);
		_frame.add(_pan);
		_frame.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("dualies.png")));
		_frame.pack();
		_frame.setResizable(false);
		_frame.setBounds(300, 300, 400, 400);
		_frame.dispatchEvent(new WindowEvent(_frame, WindowEvent.WINDOW_CLOSING));
		_frame.repaint();
		_frame.setVisible(true);
	}
	
	/*
	 * This method sets up all the JButtons that represent the students
	 * that are in the class room. It also sets up the margin of the buttons, 
	 * sets up the background for each button, adds the text representing 
	 * each student's name, and adds an ActionListener to each button.
	 */
	private void setupButtons() {
		_labMaze = new JButton[_s.getChart().length][_s.getChart()[0].length];
		for(int r = 0; r < _labMaze.length; r++) {
			for(int c = 0; c < _labMaze[0].length; c++) {
				if(_s.getChart()[r][c] != null) {
					_labMaze[r][c] = new JButton(_s.getChart()[r][c].getName());
					_labMaze[r][c].setBackground(new Color(180, 180, 180));
					_labMaze[r][c].setFocusPainted(false);
					_labMaze[r][c].setContentAreaFilled(false);
					_labMaze[r][c].setMargin(new Insets(0,0,0,0));
					_labMaze[r][c].setOpaque(true);
					_labMaze[r][c].addActionListener(new JOPListener(_s.getChart()[r][c].getName(),_s, r , c));
				}
				else {
					_labMaze[r][c] = new JButton("[{--------}]");
					_labMaze[r][c].setBackground(new Color(150, 150, 150));
					_labMaze[r][c].setFocusPainted(false);
					_labMaze[r][c].setContentAreaFilled(false);
					_labMaze[r][c].setMargin(new Insets(0,0,0,0));
					_labMaze[r][c].setOpaque(true);
					
					_labMaze[r][c].addActionListener(new JOPListener(" ",_s, r , c));
				}
			}
		}
	}
	
	/*
	 * This method sets up the panel that will display the
	 * main menu. It also adds the buttons that represent
	 * the students in the classroom.
	 */
	private void setupPanel() {
		_pan = new JPanel(new GridLayout(_labMaze.length, _labMaze[0].length));
		for(JButton[] l: _labMaze) {
			for(JButton b : l) {
				_pan.add(b);
			}
		}
		_pan.repaint();
	}
}
