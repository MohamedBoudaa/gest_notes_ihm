package com.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class AddStudentPane extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddStudentPane() {
		
		setSize(1003, 769);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations Personnelles", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		panel.setBounds(49, 44, 917, 345);
		add(panel);
		panel.setLayout(null);
		
		JLabel nomLabel = new JLabel("Nom");
		nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nomLabel.setBounds(36, 49, 100, 36);
		panel.add(nomLabel);
		
		JLabel prenomLabel = new JLabel("Prenom");
		prenomLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prenomLabel.setBounds(36, 145, 100, 36);
		panel.add(prenomLabel);
		
		JLabel cneLabel = new JLabel("CNE");
		cneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cneLabel.setBounds(480, 49, 100, 36);
		panel.add(cneLabel);
		
		JLabel cinLabel = new JLabel("CIN");
		cinLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cinLabel.setBounds(480, 145, 100, 36);
		panel.add(cinLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 49, 286, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 141, 286, 40);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(590, 49, 286, 40);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(590, 141, 286, 40);
		panel.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { null, "CP1", "CP2", "GI1", "GI2", "GI3", "GC1", "GC2",
				"GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox.setBounds(146, 235, 286, 37);
		panel.add(comboBox);
		
		JLabel niveauLabel = new JLabel("Niveau");
		niveauLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		niveauLabel.setBounds(36, 236, 100, 36);
		panel.add(niveauLabel);


		
		
		setVisible(false);
	}
}
