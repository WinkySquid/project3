package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import models.SeatingChart;

public class JOPListener implements ActionListener {
	
	//INSTANCE VARIABLES
	private String _s;
	private SeatingChart _c;
	private int row;
	private int col;
	
	//CONSTRUCTOR
	public JOPListener(String lab, SeatingChart s, int r, int c) {
		_s = lab;
		_c = s;
		row = r;
		col = c;
	}
	
	/*
	 * This method overrides the original actionPerformed method
	 * in ActionListener and displays the information about one
	 * specific student that the user chooses if the student is
	 * present. If the student is not present, then the method
	 * displays a message dialog letting the user know that no
	 * student is present.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		UIManager.put("OptionPane.background",new ColorUIResource(0,150,0));
		UIManager.put("Panel.background",new ColorUIResource(0,150,150));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Calibri", Font.CENTER_BASELINE, 18)));
		
		if(_s.equals(" ")) {
			JOptionPane.showMessageDialog(null, "No student is present in this desk!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Student Info: \n"
					+ "Name: " + _s + "\n"
					+ "Number of absences: " + _c.getChart()[row][col].getAbsenceCount(),
					"Info about " + _s,
					JOptionPane.DEFAULT_OPTION,
					_c.getChart()[row][col].getIcon());
		}
		UIManager.put("Panel.background",new ColorUIResource(150,75,0));
	}
	
}
