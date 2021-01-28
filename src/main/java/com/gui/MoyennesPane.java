package com.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bll.InscriptionManagerImpl;
import com.bll.MoyennesException;
import com.bll.MoyennesManagerImpl;
import com.bll.SearchManagerImpl;
import com.bo.Niveau;
import com.components.DisplayDetailsBtn;
import com.dao.DaoFactory;
import com.dao.impl.NoteDaoImpl;

public class MoyennesPane extends JPanel{
	private JTable table;
	private SearchManagerImpl searchManager;
	private List<HashMap<String, String>> searchList;
	private JPanel panel;

	private static final NoteDaoImpl noteDao=(NoteDaoImpl) DaoFactory.getDaoFactory().getDao(DaoFactory.DAO_NOTE);
	private static final InscriptionManagerImpl inscriptionManager = new InscriptionManagerImpl();
	
	/**
	 * Create the panel.
	 */
	
	public static void displayDetails(JPanel panel,String[] studentData,String niveau,List<HashMap<String, Object>> listN) {
		panel.removeAll();	
	
		JLabel fstName = new JLabel("Nom : "+studentData[2]);
		fstName.setBounds(197, 27, 161, 27);
		panel.add(fstName);
		
		JLabel scndName = new JLabel("Prénom : "+studentData[1]);
		scndName.setBounds(20, 27, 167, 27);
		panel.add(scndName);
		
		JLabel niveauLabel = new JLabel("Niveau : "+niveau);
		niveauLabel.setBounds(20, 50, 152, 24);
		panel.add(niveauLabel);
		
		JLabel cneLabel = new JLabel("CNE : "+studentData[0]);
		cneLabel.setBounds(371, 27, 167, 27);
		panel.add(cneLabel);

		Object[] columns = { "Modules", "Semester","Coeff", "Note finale" };
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row,int col) {
					if(col == 4) {
						return true;
					}
		            return false;
		        
			}
		};
		model.setColumnIdentifiers(columns);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 78, 521, 192);
		panel.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		table.setRowHeight(40);
		table.putClientProperty(
						   "Quaqua.Table.style", "striped"
						);			
		
		if (listN.size() > 0) {
			int rows = model.getRowCount(); 
			for(int i = rows - 1; i >=0; i--) {
			   model.removeRow(i); 
			}
			for (int i = 0; i < listN.size(); i++) {
				Object[] row = new Object[4];
				row[0] = (String) listN.get(i).get("titre");
				row[1] = (Integer) listN.get(i).get("semester");
				row[2] = (Double) listN.get(i).get("coeff");
				row[3] = (Double) listN.get(i).get("noteFinale");
				model.addRow(row);
			}
		}
		panel.revalidate();
		panel.repaint();
		
	}
	
	public static String[] getDataFromTable(JTable table,int from,int to) {
		int row = table.getSelectedRow();
		String[] value= new String[to-from+1];
		for(int i = from; i<to+1;i++) {
			value[i] = table.getModel().getValueAt(row, i).toString();
		}
		return value;
	}
	
	public MoyennesPane() {
		searchList = null;
		searchManager = new SearchManagerImpl();

		setSize(1003, 660);
		setLayout(null);

		JPanel panSearch = new JPanel();
		panSearch.setBounds(10, 56, 385, 142);
		panSearch.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calculer les moyennes des \u00E9tudiants selon le niveau",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		panSearch.setLayout(null);
		panSearch.setBackground(UIManager.getColor("Button.background"));
		add(panSearch);

		JButton btnCalculer = new JButton("Calculer moyennes");
		btnCalculer.setBounds(204, 94, 156, 37);
		panSearch.add(btnCalculer);

		JLabel lblNiveau = new JLabel("Niveau");
		lblNiveau.setBounds(33, 27, 61, 37);
		panSearch.add(lblNiveau);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CP1", "CP2", "GI1", "GI2", "GI3", "GC1", "GC2",
				"GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox.setBounds(104, 27, 105, 37);
		panSearch.add(comboBox);
		
		JFormattedTextField Fyear = new JFormattedTextField();
		Fyear.setBounds(286, 27, 72, 37);
		panSearch.add(Fyear);
		
		JLabel lblYear = new JLabel("Ann\u00E9e");
		lblYear.setBounds(230, 27, 58, 37);
		panSearch.add(lblYear);
		
		panel = new JPanel();
		panel.setBounds(428, 56, 565, 281);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "R\u00E9sultats de calcule des moyennes", TitledBorder.LEADING, TitledBorder.TOP,
				null, UIManager.getColor("CheckBox.focus")));
		panel_1.setBounds(10, 339, 983, 310);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 963, 267);
		panel_1.add(scrollPane);

		Object[] columns = { "CNE", "Nom", "Prenom", "Note finale", "Classement","Afficher details" };
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row,int col) {
					if(col == 5) {
						return true;
					}
		            return false;
		        
			}
		};
		model.setColumnIdentifiers(columns);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		table.setRowHeight(40);
		table.putClientProperty(

				   "Quaqua.Table.style", "striped"

				);
		
		btnCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean filled = true;
				Integer year = null;
				Niveau niveau = inscriptionManager.getNiveauByTitle((String) comboBox.getSelectedItem());
				
				if (!Fyear.getText().equals("")) {
					year = Integer.parseInt(Fyear.getText().trim());
				}else {
						filled = false;
				}
				
				if(filled == false) {
					JOptionPane.showMessageDialog(null, "Veuillez choisir l'année !");
				}else {
					try {
						MoyennesManagerImpl.calculerMoyennesByNiveau(niveau.getTitle(), year);
						//Affichage des notes finales des étudiants
						searchList = searchManager.searchInscAdmin(niveau.getId(), year);
						int y=year;
						//Get Etudiants and insc Etudiants 
						if (searchList.size() > 0) {
							int rows = model.getRowCount(); 
							for(int i = rows - 1; i >=0; i--) {
							   model.removeRow(i); 
							}
							for (int i = 0; i < searchList.size(); i++) {
								Object[] row = new Object[6];
								row[0] = searchList.get(i).get("cne");
								row[1] = searchList.get(i).get("firstName");
								row[2] = searchList.get(i).get("secondName");
								row[3] = searchList.get(i).get("noteFinal");
								row[4] = searchList.get(i).get("rank");
								row[5] = "Afficher";
								new DisplayDetailsBtn(table, 5) {
									@Override
									public void actionPerformed(ActionEvent e) {
										String[] studentData = MoyennesPane.getDataFromTable(table, 0, 2);
										Long inscPedag=searchManager.searchInscPedag(studentData[0], y);
										List<HashMap<String, Object>> listNotes=noteDao.getModulesNotesByEtudiant(inscPedag,niveau.getId());
										MoyennesPane.displayDetails(panel,studentData,niveau.getTitle(),listNotes);
									}
								};
								model.addRow(row);
							}
						}
					} catch (MoyennesException e1) {
						JOptionPane.showMessageDialog(null,"erreur : "+ e1.getMessage());
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		
		setVisible(false);

	}
}
