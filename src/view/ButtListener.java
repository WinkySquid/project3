package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import models.SeatingChart;
import models.Student;
import models.StudentList;

public class ButtListener implements ActionListener{

	//INSTANCE VARIABLES
	private int _i;
	private Window2 _w2;
	private Window _w;
	private Frame _f;
	private StudentList _l;
	private SeatingChart _c;
	
	//CONSTRUCTOR
	public ButtListener(int i, Window2 w3, StudentList l) {
		_i = i;
		_l = l;
		_w2 = w3;
		_w = new Window();
	}

	/*
	 * This method overrides the original actionPerformed method
	 * in ActionListener and calls one method out of 5 available
	 * methods (depending on what option the user chooses & the 
	 * value of _i) to swap students, add a student, create a 
	 * chart of all the students, remove a student, or remove 
	 * a student based on the number of maximum absences.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(_i == 0) {
			addPerson();
		}
		else if (_i == 1) {
			removePerson();
		}
		else if (_i == 2) {
			chart();
		}
		else if (_i == 3) {
			remove();
		}
		else if (_i == 4) {
			swap();
		}
	}
	
	/*
	 * This method adds a new person to the student list. It asks
	 * the user to input in the name of the student and the number
	 * of absences the student has. It also checks if the inputs
	 * are invalid or not and lets the user know if an invalid
	 * input exists.
	 */
	public void addPerson() {
		_w2.getFrame().setVisible(false);
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Times New Roman", Font.ITALIC, 14)));
		String s = "";
		int a = 0;
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Helvetica", Font.ITALIC, 14)));
		String c = _w.in("What will be the first name of your new student?");
		if(c == null || c.equalsIgnoreCase("exit")) {
			System.exit(0);
		}
		String d = _w.in("What will be the last name (or initial) of your new student?");
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
	
	/*
	 * This method removes a student from the student list
	 * if and only if there is 1 or more student in the list.
	 * If there are no students in the list, the method displays
	 * a message letting the user know that there are no students
	 * in the student list; otherwise, it will ask for the name
	 * of the student to be removed and removes that student
	 * if the name exists in the list.
	 */
	public void removePerson() {
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Times New Roman", Font.ITALIC, 14)));
		if(_l.getList().size() > 0) {
			String c = _w.in("Type the exact name of the student \n"
					+ "that you want to remove.");
			if(c != null) {
				for(int i = 0; i < _l.getList().size(); i++) {
					if(c.equals(_l.getList().get(i).getName())) {
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
						          "Times New Roman", Font.BOLD, 14)));
						_l.getList().remove(i);
						_w.msg2("Student removed.", "Removed.");
					}
				}
			}
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Times New Roman", Font.ITALIC, 14)));
		}
		else {
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Times New Roman", Font.BOLD, 14)));
			UIManager.put("OptionPane.background",new ColorUIResource(200,0,0));
			_w.msg3("There are no students in your class;\n"
					+ "add a student to your class!", "");
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Helvetica", Font.ITALIC, 14)));
			UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
		}
		_w2.getFrame().setVisible(false);
		_w2 = new Window2(_l);
	}
	
	/*
	 * This method creates the seating chart in a 2-D grid in column-major
	 * order. The number of rows and the number of columns in the chart are
	 * determined by the user, who inputs the number of columns and rows
	 * in the chart. It also allows the user to name the chart/classroom.
	 */
	public void chart() {
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Times New Roman", Font.ITALIC, 14)));
		int a = 0;
		int f = 0;
		boolean b = false;
		while(!b) {
			try {
				String w = _w.in("How many rows in the seating chart?");
				a = Integer.parseInt(w);
				if(a >= 1) {
					b = true;
				}
				else {
					_w.msg3("This is not a valid number;\n"
							+ "try again!", "NOT A VALID NUMBER");
				}
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
		b = false;
		while(!b) {
			try {
				String w = _w.in("How many columns in the chart?");
				f = Integer.parseInt(w);
				if(f >= 1) {
					b = true;
				}
				else {
					_w.msg3("This is not a valid number;\n"
							+ "try again!", "NOT A VALID NUMBER");
				}
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
		String w = _w.in("What's the name of your class?");
		_c = new SeatingChart(_l.getList(), a, f);
		_f = new Frame(_c,w);
	}
	
	/*
	 * This method removes the students based on the maximum amount of absences
	 * the students are supposed to have. This amount is determined only by
	 * the user's input. The method then displays the amount of students removed
	 * because they have more absences than the maximum amount of absences.
	 */
	public void remove() {
		_w2.getFrame().setVisible(false);
		int a = 0;
		boolean b = false;
		while(!b) {
			try {
				String w = _w.in("How many absences AT MOST\n"
						+ "should the students have?");
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
		int i = _l.removeAbsentStudents(a);
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Times New Roman", Font.BOLD, 14)));
		if(i == 1) {
			JOptionPane.showMessageDialog(null,
					1 + " student removed.",
					
					"",
					JOptionPane.DEFAULT_OPTION,
					null);
		}
		else {
			JOptionPane.showMessageDialog(null,
					i + " students removed.",
					
					"",
					JOptionPane.DEFAULT_OPTION,
					null);
		}
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Helvetica", Font.ITALIC, 14)));
		_w2 = new Window2(_l);
	}
	
	/*
	 * This method swaps two students if and only if 2 or more
	 * students are in the student list. If there are less 
	 * than 2 students in the list, the method displays a message
	 * letting the user know that either 1 or no students are in
	 * the student list; otherwise, the method asks for the names
	 * of the two students and swaps the two students in the list.
	 */
	public void swap() {
		int first = 0;
		int second = 0;
		if(_l.getList().size() > 1) {
			boolean b = false;
			while(!b) {
			try {
				
					String c = _w.in("Type in the exact name of the first student \n"
							+ "that you want to swap with.");
					String d = _w.in("Type in the exact name of the second student \n"
							+ "that you want to swap with.");
					for(int i = 0; i < _l.getList().size(); i++) {
						if(c.equals(_l.getList().get(i).getName())) {
							first = i;
						}
						else if(d.equals(_l.getList().get(i).getName())) {
							second = i;
						}
					}
					if(first < second) {
						Student s1 = _l.getList().remove(first);
						_l.getList().add(second, s1);
						Student s2 = _l.getList().remove(second-1);
						_l.getList().add(first, s2);
						_w2.getFrame().setVisible(false);
						_w.msg2("Swapped!", "Done.");
						b = true;
					}
					else if (first > second) {
						Student s1 = _l.getList().remove(first);
						_l.getList().add(second, s1);
						Student s2 = _l.getList().remove(second+1);
						_l.getList().add(first, s2);
						_w2.getFrame().setVisible(false);
						_w.msg2("Swapped!", "Done.");
						b = true;
					}
					else {
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
						          "Times New Roman", Font.BOLD, 14)));
						UIManager.put("OptionPane.background",new ColorUIResource(0,0,0));
						_w.msg3("These reference the same student; try again!", "");
						UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
						          "Helvetica", Font.ITALIC, 14)));
						UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
					}
				
			}
			catch(NullPointerException n) {
				_w.msg3("You did not input anything for either question;\n"
						+ "try again!", "");
			}
			}
		}
		else if(_l.getList().size() == 1) {
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Times New Roman", Font.BOLD, 14)));
			UIManager.put("OptionPane.background",new ColorUIResource(200,0,0));
			_w.msg3("There is only 1 student in your class;\n"
					+ "add a student to your class!", "");
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Helvetica", Font.ITALIC, 14)));
			UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
		}
		else {
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Times New Roman", Font.BOLD, 14)));
			UIManager.put("OptionPane.background",new ColorUIResource(200,0,0));
			_w.msg3("There are no students in your class;\n"
					+ "add a student to your class!", "");
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
			          "Helvetica", Font.ITALIC, 14)));
			UIManager.put("OptionPane.background",new ColorUIResource(0,200,0));
		}
		_w2.getFrame().setVisible(false);
		_w2 = new Window2(_l);
	}
}
