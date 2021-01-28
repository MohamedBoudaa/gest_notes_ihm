package com.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bll.ImportManagerImpl;
import com.bll.SearchManagerImpl;
import com.bo.Module;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ImportPane extends JPanel {
	
	private static final SearchManagerImpl searchManager = new SearchManagerImpl();
	private static final ImportManagerImpl importManager = new ImportManagerImpl();

	private JTable table;
	private List<Module> allModules = searchManager.getModulesByNiveau(null); // get all modules
	private JTextField selectedModule;
	private Long idModule;
	private File selectedFile = null;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public ImportPane() {

		setSize(1003, 660);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Importation des notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 511, 438);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFiltrerLesModules = new JLabel("Filtrer les modules par niveau");
		lblFiltrerLesModules.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFiltrerLesModules.setBounds(36, 35, 384, 36);
		panel.add(lblFiltrerLesModules);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CP1", "CP2", "GI1", "GI2", "GI3", "GC1",
				"GC2", "GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox_1.setBounds(35, 82, 233, 37);
		panel.add(comboBox_1);

		JButton filterBtn = new JButton("Filtrer");

		filterBtn.setBounds(278, 82, 205, 36);
		panel.add(filterBtn);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(36, 130, 447, 111);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Module S\u00E9l\u00E9ctionn\u00E9 ");
		lblNewLabel.setBounds(36, 252, 135, 36);
		panel.add(lblNewLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 447, 89);
		panel_2.add(scrollPane);

		
		Object[] columns = { "id","Module", "Niveau", "Sem\u00E8stre"};
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
					idModule =  (Long) target.getValueAt(row, 0);
					selectedModule.setText((String) target.getValueAt(row, 1));
				}
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		filterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String niveau = (String) comboBox_1.getSelectedItem();

				List<Module> listModules = searchManager.filterModulesByNiveau(niveau, allModules);
				if (listModules.size() > 0) {
					int rows = model.getRowCount();

					//delete all rows from table 1 to update it next
					for (int i = rows - 1; i >= 0; i--) {
						model.removeRow(i);
						
					}
					
					
					//displaying searched modules into table 1
					for (int i = 0; i < listModules.size(); i++) {
						Object[] row = new Object[4];
						row[0] = listModules.get(i).getId();
						row[1] = listModules.get(i).getTitle();
						row[2] = listModules.get(i).getNiveau().getTitle();
						row[3] = listModules.get(i).getSemester();
						
						model.addRow(row);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Aucun résltat trouvé");
				}

			}
		});
		
		
		
		JButton fileChoserBtn = new JButton("Choisir fichier");
		fileChoserBtn.setBounds(36, 319, 135, 31);
		panel.add(fileChoserBtn);
		
		selectedModule = new JTextField();
		selectedModule.setBounds(192, 252, 291, 36);
		selectedModule.setEditable(false);
		panel.add(selectedModule);
		selectedModule.setColumns(10);
		
		JButton importBtn = new JButton("Importer");
		importBtn.setBounds(357, 381, 126, 34);
		panel.add(importBtn);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(192, 316, 291, 36);
		panel.add(textField_1);
		
		JLabel lblYear = new JLabel("Ann\u00E9e");
		lblYear.setBounds(36, 380, 135, 36);
		panel.add(lblYear);
		
		JComboBox comboBox = new JComboBox();
		String[] years =  new String[20];
		for(int i = 0 ; i<20 ; i++) {
			int k = 2008 + i;
			years[i] = String.valueOf(k);
		}
		comboBox.setModel(new DefaultComboBoxModel(years));
		comboBox.setBounds(192, 380, 145, 36);
		comboBox.setSelectedItem(years[12]);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Guide d'utilisation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(550, 11, 443, 438);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 26, 423, 400);
		panel_1.add(scrollPane_2);
		
		JTextPane guideTextPane = new JTextPane();
		scrollPane_2.setViewportView(guideTextPane);
		guideTextPane.setText("Bienvenue dans le guide d'utilisation de l'outil d'importation des notes.\r\n\r\n1-Type du fichier : \r\n\r\n l'importation des notes se fait \u00E0 partir d'un fichier .csv\r\n\r\n2-Syntaxe :\r\n\r\n les donn\u00E9es dans le fichier doivent avoir la forme suivate :\r\n\r\nCNE_Etudiant,note\r\nCNE_Etudiant2,note2\r\n.. , ..\r\n\r\nle fichier doit contenir tous les \u00E9tudiants inscrits au module ainsi que tous les \u00E9tudiants du niveau concern\u00E9. \r\n\r\nSi un \u00E9tudiant est ajourn\u00E9 mais a d\u00E9j\u00E0 valid\u00E9 le module, il doit etre pr\u00E9sent dans la liste et \u00E0 la place de la note on doit y mettre le caract\u00E8re : #\r\n\r\nLes \u00E9tudiant ajourn\u00E9s ayant des modules supplimentaire d'un autre niveau\r\ndoivent etre \u00E0 la fin de la liste et leur CNE doit commencer par # comme suivant\r\n\r\n#CNE_Etudiant,note\r\n\r\n4- Exemple : \r\n\r\nS130414250,16.15\r\nZ158020165,13.50\r\nE195198751,17.00\r\nS166554457,#            ----> cet \u00E9tudiant a d\u00E9j\u00E0 valid\u00E9 le module\r\n#S101048247,12.05   ----> cet \u00E9tudiant est ajourn\u00E9 et a ce module comme module \r\n                                            supplimentaire");
		guideTextPane.setEditable(false);
		guideTextPane.setOpaque(false);
		guideTextPane.setBackground(new Color(0,0,0,0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 460, 983, 167);
		add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 26, 963, 130);
		panel_3.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textPane.setEditable(false);
		textPane.setOpaque(false);
		textPane.setBackground(new Color(0,0,0,0));
		
		
		
		
		fileChoserBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					textField_1.setText(selectedFile.getName());
				}

			}
		});
		
		importBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String niveau = (String) comboBox_1.getSelectedItem();
				String year = (String) comboBox.getSelectedItem();
				String module = null;
				if(!selectedModule.getText().equals("")) {
					module = selectedModule.getText();
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir un module !");
					return ;
				}
				if(selectedFile != null) {
					
					importManager.importNotesFromCsv(selectedFile,niveau,module,year);
					try {
						String content = importManager.getImportLog();
						textPane.setText(content);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir un fichier !");
					return ;
				}
			}
		});
		
		
		setVisible(false);
	}
}
