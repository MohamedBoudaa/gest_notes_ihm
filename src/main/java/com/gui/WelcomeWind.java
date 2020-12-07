package com.gui;

import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JWindow;

public class WelcomeWind extends JWindow{

	private JLabel lab = new JLabel("welcome !");
	
	public WelcomeWind() {
		setSize(300, 300);
		setLocation(200,200);
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		setVisible(true);
		
		lab.setBounds(0, 0, 82, 89);
		
		add(lab);
		
	}
	
	
}
