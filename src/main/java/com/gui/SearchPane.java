package com.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SearchPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchPane() {
		setSize(1003,769);
		setLayout(null);
		
		JPanel panSearch = new JPanel();
		panSearch.setLayout(null);
		panSearch.setBackground(Color.WHITE);
		panSearch.setBounds(10, 56, 426, 281);
		add(panSearch);
		
		JFormattedTextField Fnom = new JFormattedTextField();
		Fnom.setBounds(108, 29, 297, 37);
		panSearch.add(Fnom);
		
		JButton btnSearch = new JButton("Rechercher");
		btnSearch.setBounds(316, 221, 89, 37);
		panSearch.add(btnSearch);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(37, 29, 61, 37);
		panSearch.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(37, 77, 61, 37);
		panSearch.add(lblPrnom);
		
		JFormattedTextField Fprenom = new JFormattedTextField();
		Fprenom.setBounds(108, 77, 297, 37);
		panSearch.add(Fprenom);
		
		JLabel lblCne = new JLabel("CNE");
		lblCne.setBounds(37, 125, 61, 37);
		panSearch.add(lblCne);
		
		JFormattedTextField Fcne = new JFormattedTextField();
		Fcne.setBounds(108, 125, 297, 37);
		panSearch.add(Fcne);
		
		JFormattedTextField formattedTextField_2_1 = new JFormattedTextField();
		formattedTextField_2_1.setBounds(108, 173, 297, 37);
		panSearch.add(formattedTextField_2_1);
		
		JLabel lblNiveau = new JLabel("Niveau");
		lblNiveau.setBounds(37, 173, 61, 37);
		panSearch.add(lblNiveau);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 0, 426, 42);
		add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Recherche des \u00E9tudiants");
		lblNewLabel_1.setBounds(129, 11, 221, 20);
		panel_2.add(lblNewLabel_1);

		setVisible(false);
		
	}

}
