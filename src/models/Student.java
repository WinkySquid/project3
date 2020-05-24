package models;

import javax.swing.ImageIcon;

public class Student{
	
	//INSTANCE VARIABLES
	private String name;
	private int absences;
	private ImageIcon _i;
	
	//CONSTRUCTOR
	public Student(String s, int a) {
		name = s;
		absences = a;
		setupIcon();
	}
	
	//GETTERS
	public String getName(){ 
		return name; 
	}
	public int getAbsenceCount() {
		return absences;
	}
	public ImageIcon getIcon() {
		return _i;
	}
	
	//SETTER (depending on the value of x)
	/*
	 * This method sets the image to be displayed (sets the ImageIcon value of _i)
	 * when the Student object is created. It chooses the image to be selected based
	 * on the value of x, a random integer from 0 to 20, inclusive.
	 */
	private void setupIcon() {
		int x = (int)(Math.random()*21);
		switch(x) {
		case 0:
			_i = new ImageIcon(getClass().getResource("stick1.png"));
			break;
		case 1:
			_i = new ImageIcon(getClass().getResource("callie.png"));
			break;
		case 2:
			_i = new ImageIcon(getClass().getResource("marie.png"));
			break;
		case 3:
			_i = new ImageIcon(getClass().getResource("stick2.png"));
			break;
		case 4:
			_i = new ImageIcon(getClass().getResource("mario.png"));
			break;
		case 5:
			_i = new ImageIcon(getClass().getResource("pororo.png"));
			break;
		case 6:
			_i = new ImageIcon(getClass().getResource("stick3.png"));
			break;
		case 7:
			_i = new ImageIcon(getClass().getResource("pearl.png"));
			break;
		case 8:
			_i = new ImageIcon(getClass().getResource("marina.png"));
			break;
		case 9:
			_i = new ImageIcon(getClass().getResource("luigi.png"));
			break;
		case 10:
			_i = new ImageIcon(getClass().getResource("marth.png"));
			break;
		case 11:
			_i = new ImageIcon(getClass().getResource("incineroar.png"));
			break;
		case 12:
			_i = new ImageIcon(getClass().getResource("simon.png"));
			break;
		case 13:
			_i = new ImageIcon(getClass().getResource("daisy.png"));
			break;
		case 14:
			_i = new ImageIcon(getClass().getResource("snake.png"));
			break;
		case 15:
			_i = new ImageIcon(getClass().getResource("samus.png"));
			break;
		case 16:
			_i = new ImageIcon(getClass().getResource("richter.png"));
			break;
		case 17:
			_i = new ImageIcon(getClass().getResource("kirby.png"));
			break;
		case 18:
			_i = new ImageIcon(getClass().getResource("inkling.png"));
			break;
		case 19:
			_i = new ImageIcon(getClass().getResource("paruko.png"));
			break;
		case 20:
			_i = new ImageIcon(getClass().getResource("papyrus.jpg"));
			break;
		default:
			_i = new ImageIcon(getClass().getResource("MissingNo.jpg"));
			break;
		}
	}
}