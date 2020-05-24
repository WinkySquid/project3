package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import models.StudentList;

public class Window2 {

	//INSTANCE VARIABLES
	private JFrame _frame;
	private JPanel _pan;
	private JLabel _lab;
	private JButton _btn, _btn2, _btn3,_btn4, _btn5;
	private StudentList _s;
	
	//CONSTRUCTORS
	public Window2(StudentList l) {
		_s = l;
		setupButtons();
		setupPanels();
		setupFrame();
	}
	
	//GETTERS
	public JFrame getFrame() {
		return _frame;
	}
	public JPanel getPanel() {
		return _pan;
	}
	
	/*
	 * This method sets up the frame for the menu. It does 
	 * not allow for resizing, lets you exit the program
	 * upon closing, sets the background of the frame, sets 
	 * the bounds for the frame, sets the icon for the frame,
	 * and sets the decoration of the frame. 
	 */
	private void setupFrame() {
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.gray));
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
		JFrame.setDefaultLookAndFeelDecorated(true);
		_frame = new JFrame("Main Menu");
		_frame.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("aerospray.png")));
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.add(_pan);
		_frame.setContentPane(_pan);
		_frame.setBounds(700, 300, 550, 500);
		_frame.setBackground(new Color(150,96,150));
		_frame.repaint();
		_frame.setVisible(true);
	}
	
	/*
	 * This method sets up the label that will display the
	 * list of student names and the buttons that will be
	 * used as options for the user to pick. It also sets
	 * the dimensions for each button and adds an ActionListener
	 * to each button.
	 */
	public void setupButtons() {
		String s = "Student List: \n";
		for(int i = 0; i < _s.getList().size(); i++) {
			if(_s.getList().size() == 1) {
				s += _s.getList().get(i).getName() + " ";
			}
			else {
				s += _s.getList().get(i).getName() + ", ";
			}
		}
		_lab = new JLabel(s);
		_btn = new JButton("Add a Student");
		_btn.setPreferredSize(new Dimension(60, 40));
		_btn.addActionListener(new ButtListener(0, this, _s));
		_btn2 = new JButton("Remove a Student");
		_btn2.setPreferredSize(new Dimension(60, 40));
		_btn2.addActionListener(new ButtListener(1, this, _s));
		_btn4 = new JButton("Remove Students "
				+ "Based on Absences");
		_btn4.setPreferredSize(new Dimension(60, 40));
		_btn4.addActionListener(new ButtListener(3, this, _s));
		_btn3= new JButton("Show Seating Chart");
		_btn3.setPreferredSize(new Dimension(60, 40));
		_btn3.addActionListener(new ButtListener(2, this, _s));
		_btn5= new JButton("Swap Students");
		_btn5.setPreferredSize(new Dimension(60, 40));
		_btn5.addActionListener(new ButtListener(4, this, _s));

	}
	
	/*
	 * This method sets up the panel that will display
	 * the main menu. It adds the various JButtons and
	 * the JLabel to the panel.
	 */
	private void setupPanels() {
		_pan = new JPanel();
		_pan.setLayout(new GridLayout(3,1));
		_pan.add(_lab);
		_pan.add(_btn);
		_pan.add(_btn2);
		_pan.add(_btn4);
		_pan.add(_btn3);
		_pan.add(_btn5);
	
	}
}
