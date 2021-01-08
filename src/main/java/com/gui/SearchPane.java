package com.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.TableUI;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bll.SearchManagerImpl;
import com.components.CellBtnRender;
import com.components.DisplayDetailsBtn;
import com.components.ButtonColumn;

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
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class SearchPane extends JPanel {
	private JTable table;
	private SearchManagerImpl searchManager;
	private List<HashMap<String, String>> searchList;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	
	public static void displayDetails(JPanel panel,String[] studentData) {
		panel.removeAll();
		JLabel imageEtudiant = new JLabel();
		imageEtudiant.setBorder(new LineBorder(new Color(0, 0, 0)));
		imageEtudiant.setBounds(10, 23, 143, 143);
		ImageIcon icon = new ImageIcon(LoginPannel.URL_RESOURCES+"user.png");
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(imageEtudiant.getWidth(),imageEtudiant.getHeight(),java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		imageEtudiant.setIcon(icon);
		panel.add(imageEtudiant);
		JLabel fstName = new JLabel("Nom : "+studentData[2]);
		fstName.setBounds(163, 43, 198, 27);
		panel.add(fstName);
		
		JLabel scndName = new JLabel("Prénom : " +studentData[1]);
		scndName.setBounds(163, 81, 198, 27);
		panel.add(scndName);
		
		JLabel niveauLabel = new JLabel("Niveau : "+studentData[3]);
		niveauLabel.setBounds(163, 119, 198, 27);
		panel.add(niveauLabel);
		
		JLabel lblNewLabel_3 = new JLabel("CNE : "+ studentData[0]);
		lblNewLabel_3.setBounds(20, 177, 198, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("CIN : "+ studentData[4]);
		lblNewLabel_3_1.setBounds(20, 225, 198, 27);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setBounds(20, 273, 198, 27);
		panel.add(lblNewLabel_3_2);
		
		JButton editStudent = new JButton("Modifier");
		editStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Actuellement indisponible");
			}
		});
		editStudent.setBounds(242, 177, 174, 33);
		panel.add(editStudent);
		
		JButton deleteStudent = new JButton("Supprimer");
		deleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Actuellement indisponible");
			}
		});
		deleteStudent.setBounds(242, 227, 174, 33);
		panel.add(deleteStudent);
		panel.revalidate();
		panel.repaint();
		
	}
	
	public static String[] getDataFromTable(JTable table,int from,int to) {
		int row = table.getSelectedRow();
		String[] value= new String[to-from+1];
		for(int i = from; i<to+1;i++) {
			value[i] = table.getModel().getValueAt(row, i).toString();
			System.out.println(value[i]);
		}
		return value;
	}
	
	public SearchPane() {
		searchList = null;
		searchManager = new SearchManagerImpl();

		setSize(1003, 769);
		setLayout(null);

		JPanel panSearch = new JPanel();
		panSearch.setBounds(10, 56, 547, 281);
		panSearch.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recherche des \u00E9tudiants",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		panSearch.setLayout(null);
		panSearch.setBackground(UIManager.getColor("Button.background"));
		add(panSearch);

		JFormattedTextField Fnom = new JFormattedTextField();
		Fnom.setBounds(108, 29, 415, 37);
		panSearch.add(Fnom);

		JButton btnSearch = new JButton("Rechercher");
		btnSearch.setBounds(367, 221, 156, 37);
		panSearch.add(btnSearch);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(37, 29, 61, 37);
		panSearch.add(lblNom);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(37, 77, 61, 37);
		panSearch.add(lblPrnom);

		JFormattedTextField Fprenom = new JFormattedTextField();
		Fprenom.setBounds(108, 77, 415, 37);
		panSearch.add(Fprenom);

		JLabel lblCne = new JLabel("CNE");
		lblCne.setBounds(37, 125, 61, 37);
		panSearch.add(lblCne);

		JFormattedTextField Fcne = new JFormattedTextField();
		Fcne.setBounds(108, 125, 415, 37);
		panSearch.add(Fcne);

		JLabel lblNiveau = new JLabel("Niveau");
		lblNiveau.setBounds(37, 173, 61, 37);
		panSearch.add(lblNiveau);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { null, "CP1", "CP2", "GI1", "GI2", "GI3", "GC1", "GC2",
				"GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox.setBounds(108, 173, 415, 37);
		panSearch.add(comboBox);
		
		

		panel = new JPanel();
		panel.setBounds(567, 56, 426, 281);
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
//		table.setEnabled(true);
		table.setRowHeight(40);
		table.putClientProperty(

				   "Quaqua.Table.style", "striped"

				);
//		table.setDefaultRenderer(Object.class, new CellBtnRender());

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
				Long niveau = null;
				if (!Fnom.getText().equals("")) {
					name = Fnom.getText();
				}
				if (!Fprenom.getText().equals("")) {
					scndName = Fprenom.getText();
				}
				if (!Fcne.getText().equals("")) {
					cne = Fcne.getText();
				}if (comboBox.getSelectedIndex() >0) {
					niveau = new Long(comboBox.getSelectedIndex());
				}
				
				
				
				searchList = searchManager.searchStudent(name, scndName, cne, niveau);

				if (searchList.size() > 0) {
					int rows = model.getRowCount(); 
					for(int i = rows - 1; i >=0; i--)
					{
					   model.removeRow(i); 
					}
					for (int i = 0; i < searchList.size(); i++) {
						Object[] row = new Object[6];
						row[0] = searchList.get(i).get("cne");
						row[1] = searchList.get(i).get("firstName");
						row[2] = searchList.get(i).get("secondName");
						row[3] = searchList.get(i).get("niveau");
						row[4] = searchList.get(i).get("cin");
						row[5] = "Afficher";
						new DisplayDetailsBtn(table, 5) {
							@Override
							public void actionPerformed(ActionEvent e) {
								String[] studentData = SearchPane.getDataFromTable(table, 0, 4);
								SearchPane.displayDetails(panel,studentData);
								
							}
						};
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
