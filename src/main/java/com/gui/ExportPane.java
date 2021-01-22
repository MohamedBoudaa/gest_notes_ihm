package com.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bll.SearchManagerImpl;

public class ExportPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExportPane() {

		setSize(1003, 769);
		setLayout(null);

		
		//Ajouter des composants graphiques
		JPanel contentPane=new JPanel();
		
		JButton jButton=new JButton("Click me");
		jButton.setBounds(200, 20, 100, 30);
		contentPane.add( jButton);
		JCheckBox jCheckbox=new JCheckBox("Je suis checkbox");
		jCheckbox.setBounds(200, 60, 100, 30);
		contentPane.add(jCheckbox);
		JTextField jTextfield=new JTextField("Ecrire ici");
		jTextfield.setBounds(200, 90, 100, 30);
		contentPane.add(jTextfield);
		setVisible(true);
	}

}
