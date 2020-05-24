package controller;

import models.*;
import view.*;

import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class Overseer {
	
	//INSTANCE VARIABLES
	private StudentList _l;
	private SeatingChart _c;
	private Window _w;
	private Window2 _w2;
	private Frame _f;
	
	//CONSTRUCTOR
	public Overseer() {
		_w = new Window();
		_l = new StudentList();
		start();
		firstStudent();
	}
	
	/*
	 * This method displays the starting message dialog.
	 * It sets the decoration of the dialog box and displays
	 * the starting message along with a picture in the dialog
	 * box.
	 */
	private void start() {
		UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
		UIManager.put("Panel.background",new ColorUIResource(150,75,0));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Helvetica", Font.BOLD, 32)));
		_w.msg4("Welcome to the Class Simulator!\n"
				+ "Here, you can create a student list of you own\n"
				+ "and display it in a seating chart!\n"
				+ "Enjoy!", "Class Simulator",
				new ImageIcon(getClass().getResource("board.png")));
	}
	
	/*
	 * This method asks the user to input in the first name of the
	 * first student in the classroom, the last name of the first student
	 * in the classroom, and how many absences the first student has.
	 * It also checks if the inputs are invalid and lets the user know
	 * about it if such an invalid input exists. Then, the method adds
	 * the student to _l (the StudentList) and creates a new Window2.
	 */
	private void firstStudent() {
		String s = "";
		int a = 0;
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Helvetica", Font.ITALIC, 14)));
		String c = _w.in("What will be the first name of your first student?");
		if(c == null || c.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		String d = _w.in("What will be the last name (or initial) of your first student?");
		if(d == null || d.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		boolean b = false;
		while(!b) {
			try {
				String w = _w.in("How many absences does he/she have?");
				a = Integer.parseInt(w);
				b = true;
			}
			catch(NumberFormatException e) {
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
				          "Helvetica", Font.BOLD, 16)));
				UIManager.put("OptionPane.background",new ColorUIResource(0,0,0));
				_w.msg3("This is not a number; try again!", "");
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
				          "Helvetica", Font.ITALIC, 14)));
				UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
			}
		}
		s = c + " " + d;
		_l.getList().add(new Student(s, a));
		_w2 = new Window2(_l);
	}
}
