package com.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.bll.InscriptionException;
import com.bll.InscriptionManagerImpl;
import com.bll.SearchManager;
import com.bll.SearchManagerImpl;
import com.bo.Etudiant;
import com.bo.InscriptionAdministrative;
import com.bo.InscriptionModule;
import com.bo.InscriptionPedagogique;
import com.bo.Module;
import com.bo.Niveau;
import com.components.AddButton;
import com.components.DisplayDetailsBtn;

public class AddStudentPane extends JPanel {
	private static final SearchManagerImpl searchManager = new SearchManagerImpl();
	private static final InscriptionManagerImpl inscriptionManager = new InscriptionManagerImpl();
	private JTextField Fnom;
	private JTextField Fprenom;
	private JTextField Fcne;
	private JTextField Fcin;
	private JTextField Fannee;
	private JTable table;
	private JTable table_1;

	/**
	 * Function to add module for inscription pedago
	 */
	public static void selectModule(List list1, List list2, int index) {
		list2.add(list1.get(index));
		list1.remove(index);

	}

	/**
	 * Create the panel.
	 */
	public AddStudentPane() {
		
		List<Module> allModules = searchManager.getModulesByNiveau(null); // get all modules
		List<Module> selectedModules = new ArrayList<Module>();

		setSize(1003, 769);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations Personnelles",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		panel.setBounds(26, 44, 953, 270);
		add(panel);
		panel.setLayout(null);

		JLabel nomLabel = new JLabel("Nom");
		nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nomLabel.setBounds(36, 49, 100, 36);
		panel.add(nomLabel);

		JLabel prenomLabel = new JLabel("Prenom");
		prenomLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prenomLabel.setBounds(36, 124, 100, 36);
		panel.add(prenomLabel);

		JLabel cneLabel = new JLabel("CNE");
		cneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cneLabel.setBounds(501, 49, 100, 36);
		panel.add(cneLabel);

		JLabel cinLabel = new JLabel("CIN");
		cinLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cinLabel.setBounds(501, 130, 100, 36);
		panel.add(cinLabel);

		Fnom = new JTextField();
		Fnom.setBounds(146, 49, 286, 40);
		panel.add(Fnom);
		Fnom.setColumns(10);

		Fprenom = new JTextField();
		Fprenom.setColumns(10);
		Fprenom.setBounds(146, 120, 286, 40);
		panel.add(Fprenom);

		Fcne = new JTextField();
		Fcne.setColumns(10);
		Fcne.setBounds(611, 49, 286, 40);
		panel.add(Fcne);

		Fcin = new JTextField();
		Fcin.setColumns(10);
		Fcin.setBounds(611, 126, 286, 40);
		panel.add(Fcin);

		Fannee = new JTextField("2020");
		Fannee.setHorizontalAlignment(JTextField.CENTER);
		Fannee.setColumns(10);
		Fannee.setBounds(611, 195, 286, 40);
		panel.add(Fannee);

		JLabel annee = new JLabel("Ann\u00E9e");
		annee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		annee.setBounds(501, 199, 100, 36);
		panel.add(annee);

		JButton button = new JButton("New button");
		button.setBounds(787, 283, -75, -13);
		panel.add(button);

		JLabel niveauLabel = new JLabel("Niveau");
		niveauLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		niveauLabel.setBounds(36, 199, 100, 36);
		panel.add(niveauLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CP1", "CP2", "GI1", "GI2", "GI3", "GC1", "GC2",
				"GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox.setBounds(146, 198, 286, 37);
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inscription P\u00E9dagogique",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(26, 325, 953, 356);
		add(panel_1);

		JButton button_1 = new JButton("New button");
		button_1.setBounds(787, 283, -75, -13);
		panel_1.add(button_1);

		JLabel lblFiltrerLesModules = new JLabel("Filtrer les modules par niveau");
		lblFiltrerLesModules.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFiltrerLesModules.setBounds(36, 35, 384, 36);
		panel_1.add(lblFiltrerLesModules);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {null ,"CP1", "CP2", "GI1", "GI2", "GI3", "GC1",
				"GC2", "GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox_1.setBounds(35, 82, 233, 37);
		panel_1.add(comboBox_1);

		JButton filterBtn = new JButton("Filtrer");

		filterBtn.setBounds(278, 82, 142, 36);
		panel_1.add(filterBtn);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(36, 130, 384, 194);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 384, 172);
		panel_2.add(scrollPane);

		Object[] columns = { "Module", "Niveau", "Sem\u00E8stre"};
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;

			}
		};
		model.setColumnIdentifiers(columns);
		table = new JTable();
		table.setModel(model);
		// double click event listener
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) { // to detect doble click events
					JTable target = (JTable) me.getSource();
					int row = target.getSelectedRow(); // select a row

					selectedModules.add(allModules.get(row));
					allModules.remove(row);
					filterBtn.doClick();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(542, 82, 384, 242);
		panel_1.add(panel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 364, 220);
		panel_3.add(scrollPane_1);
		
		
		
		DefaultTableModel model_2 = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;

			}
		};
		model_2.setColumnIdentifiers(columns);
		table_1 = new JTable();
		table_1.setModel(model_2);
		// double click event listener
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) { // to detect doble click events
					JTable target = (JTable) me.getSource();
					int row = target.getSelectedRow(); // select a row

					allModules.add(selectedModules.get(row));
					selectedModules.remove(row);
					filterBtn.doClick();
				}
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblSelectedModules = new JLabel("Modules s\u00E9lectionn\u00E9s");
		lblSelectedModules.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectedModules.setBounds(542, 35, 384, 36);
		panel_1.add(lblSelectedModules);
		
		JButton saveEtu = new JButton("Inscrire");
		saveEtu.setBounds(825, 703, 154, 42);
		add(saveEtu);

		
		filterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String niveau = (String) comboBox_1.getSelectedItem();

				List<Module> listModules = searchManager.filterModulesByNiveau(niveau, allModules);
				if (listModules.size() > 0) {
					int rows = model.getRowCount();
					int rows_2 = model_2.getRowCount();

					//delete all rows from table 1 to update it next
					for (int i = rows - 1; i >= 0; i--) {
						model.removeRow(i);
						
					}
					//delete all rows from table 2 to update it next 
					for(int i = rows_2 - 1; i >= 0; i--) {
						model_2.removeRow(i);
					}
					
					//Adding selected modules into table 2
					for(int i = 0; i < selectedModules.size();i++) {
						Object[] row = new Object[3];
						row[0] = selectedModules.get(i).getTitle();
						row[1] = selectedModules.get(i).getNiveau().getTitle();
						row[2] = selectedModules.get(i).getSemester();
						
						model_2.addRow(row);
					}
					//displaying searched modules into table 1
					for (int i = 0; i < listModules.size(); i++) {

						Object[] row = new Object[3];
						row[0] = listModules.get(i).getTitle();
						row[1] = listModules.get(i).getNiveau().getTitle();
						row[2] = listModules.get(i).getSemester();
						
//						row[3] = "Ajouter" + (i);
//						new AddButton(table, 3, index);
//
//						new AddButton(table, 3,index) {
//							
//							@Override
//							public void actionPerformed(ActionEvent e) {
//								selectModule(allModules, selectedModules, index);
//								System.out.println(index);
//								
//							}
//						};
						model.addRow(row);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Aucun résltat trouvé");
				}

			}
		});
		
		
		saveEtu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean filled = true;
				String name = null;
				String scndName = null;
				String cne = null;
				String cin = null;
				String annee = null;
				Niveau niveau = inscriptionManager.getNiveauByTitle((String) comboBox.getSelectedItem());
				if (!Fnom.getText().equals("")) {
					name = Fnom.getText();
				}else {
					filled = false;
				}
				if (!Fprenom.getText().equals("")) {
					scndName = Fprenom.getText();
				}else {
					filled = false;
				}
				if (!Fcne.getText().equals("")) {
					cne = Fcne.getText();
				}else {
					filled = false;
				}if (!Fannee.getText().equals("")) {
					annee = Fannee.getText();
				}else {
					filled = false;
				}if (!Fcin.getText().equals("")) {
					cin = Fcin.getText();
				}else {
					filled = false;
				}
				
				if(filled == false) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
				}else {
					Etudiant etd = new Etudiant(name, scndName, cne, cin);
					InscriptionPedagogique inscPedago = new InscriptionPedagogique(Integer.parseInt(annee), etd,null);
					for(int i = 0 ; i < selectedModules.size();i++) {
						InscriptionModule inscModule = new InscriptionModule(selectedModules.get(i), null, null, inscPedago, 0);
						inscPedago.addInscriptionModule(inscModule);
					}
					etd.addInscrPedago(inscPedago);
					etd.addInscrAdmin(new InscriptionAdministrative(niveau, etd, Integer.parseInt(annee), -1, -1, -1, -1));
					try {
						inscriptionManager.inscription(etd);
////						inscriptionManager.inscrirAdmin(etd, niveau, Integer.parseInt(annee));
//						inscriptionManager.inscrirPedago(etd, selectedModules, Integer.parseInt(annee));
						JOptionPane.showMessageDialog(null, "Inscription avec succès !");
					} catch (InscriptionException e1) {
						JOptionPane.showMessageDialog(null,"erreur : "+ e1.getMessage());
						e1.printStackTrace();
					}
					
				}
			}
		});

		setVisible(false);
	}
}
