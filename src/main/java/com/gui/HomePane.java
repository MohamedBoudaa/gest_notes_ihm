package com.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class HomePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePane() {

		setSize(1003,769);
		setLayout(null);
		
		JLabel lblWelcom = new JLabel("Bienvenue sur l'application de gestion des notes");
		lblWelcom.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcom.setBounds(40, 24, 685, 83);
		add(lblWelcom);
		
		String desc = 
			    "<html><p>This is a Description , This is a Description , This is a Description , </p>"
			    + "<p>This is a Description , This is a Description , This is a Description </p>"
			    + "<p>This is a Description , This is a Description , This is a Description </p>"
			    + "<p>This is a Description , This is a Description , This is a Description </p></html>";
		String guide = "<html>This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "<br>This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "<br>This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "<br>This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide "
				+ "This is a guide This is a guide This is a guide This is a guide This is a guide This is a guide </html>";
		JLabel lblNewLabel = new JLabel(desc);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBounds(29, 102, 415, 199);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(guide);
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(494, 102, 431, 620);
		add(lblNewLabel_1);
		
		setVisible(true);
		
	}

}
