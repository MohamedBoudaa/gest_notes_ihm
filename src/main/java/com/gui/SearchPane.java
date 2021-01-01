package com.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bll.SearchManagerImpl;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SearchPane extends JPanel {
	private JTable table;
	private SearchManagerImpl searchManager;
	private List<HashMap<String, String>> searchList;

	/**
	 * Create the panel.
	 */
	public SearchPane() {
		searchList = null;
		searchManager = new SearchManagerImpl();

		setSize(1003, 769);
		setLayout(null);

		JPanel panSearch = new JPanel();
		panSearch.setBounds(10, 56, 426, 281);
		panSearch.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recherche des \u00E9tudiants",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		panSearch.setLayout(null);
		panSearch.setBackground(UIManager.getColor("Button.background"));
		add(panSearch);

		JFormattedTextField Fnom = new JFormattedTextField();
		Fnom.setBounds(108, 29, 297, 37);
		panSearch.add(Fnom);

		JButton btnSearch = new JButton("Rechercher");
		btnSearch.setBounds(249, 221, 156, 37);
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

		JLabel lblNiveau = new JLabel("Niveau");
		lblNiveau.setBounds(37, 173, 61, 37);
		panSearch.add(lblNiveau);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { null, "CP1", "CP2", "GI1", "GI2", "GI3", "GC1", "GC2",
				"GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox.setBounds(108, 173, 297, 37);
		panSearch.add(comboBox);

		JPanel panel = new JPanel();
		panel.setBounds(462, 56, 531, 281);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "R\u00E9sultats de recherche", TitledBorder.LEADING, TitledBorder.TOP,
				null, UIManager.getColor("CheckBox.focus")));
		panel_1.setBounds(10, 348, 983, 410);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 963, 367);
		panel_1.add(scrollPane);

		Object[] columns = { "CNE", "Nom", "Prenom", "Niveau", "CIN","Afficher details" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		table.setRowHeight(40);

		/********************************************************************************************/
		/*****************************
		 * SearchBTN action
		 *********************************************/
		/********************************************************************************************/

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = null;
				String scndName = null;
				String cne = null;
				if (!Fnom.getText().equals("")) {
					name = Fnom.getText();
				}
				if (!Fprenom.getText().equals("")) {
					scndName = Fprenom.getText();
				}
				if (!Fcne.getText().equals("")) {
					cne = Fcne.getText();
				}

//				Long niveau = (long) Fniveau.getSelectedIndex();
				searchList = searchManager.searchStudent(name, scndName, cne, null);

				if (searchList.size() > 0) {
					int rows = model.getRowCount(); 
					for(int i = rows - 1; i >=0; i--)
					{
					   model.removeRow(i); 
					}
					for (int i = 0; i < searchList.size(); i++) {
						Object[] row = new Object[5];
						row[0] = searchList.get(i).get("cne");
						row[1] = searchList.get(i).get("firstName");
						row[2] = searchList.get(i).get("secondName");
						row[3] = searchList.get(i).get("niveau");
						row[4] = searchList.get(i).get("cin");

						model.addRow(row);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Aucun résltat trouvé");
				}

			}
		});

		setVisible(false);

	}
}
