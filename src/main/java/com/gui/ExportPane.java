package com.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

import com.bll.ExportManagerImpl;
import com.bll.InscriptionManagerImpl;
import com.bo.Niveau;

public class ExportPane extends JPanel {
	
	private JTextField Fcne;
	private JTextField Fannee;
	private static final InscriptionManagerImpl inscriptionManager = new InscriptionManagerImpl();

	/**
	 * Create the panel.
	 */
	public ExportPane() {
		setSize(1003, 769);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Exportation des notes ",
				TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("CheckBox.focus")));
		panel.setBounds(224, 171, 462, 404);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("Exporter Bulletin annuel");
		lbl.setBounds(36, 27, 384, 36);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lbl);
		
		JLabel cneLabel = new JLabel("CNE");
		cneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cneLabel.setBounds(36, 103, 100, 36);
		panel.add(cneLabel);
		
		Fcne = new JTextField();
		Fcne.setHorizontalAlignment(SwingConstants.CENTER);
		Fcne.setColumns(10);
		Fcne.setBounds(146, 104, 286, 40);
		panel.add(Fcne);
		
		JLabel annee = new JLabel("Ann\u00E9e");
		annee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		annee.setBounds(36, 169, 100, 36);
		panel.add(annee);

		Fannee = new JTextField();
		Fannee.setHorizontalAlignment(JTextField.CENTER);
		Fannee.setColumns(10);
		Fannee.setBounds(146, 170, 286, 40);
		panel.add(Fannee);

		JLabel niveauLabel = new JLabel("Niveau");
		niveauLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		niveauLabel.setBounds(36, 242, 100, 36);
		panel.add(niveauLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CP1", "CP2", "GI1", "GI2", "GI3", "GC1", "GC2",
				"GC3", "GEE1", "GEE2", "GEE3", "GEER1", "GEER2", "GEER3" }));
		comboBox.setBounds(146, 245, 286, 37);
		panel.add(comboBox);
		
		JButton export = new JButton("Exporter");
		export.setBounds(282, 342, 154, 42);
		panel.add(export);
			
		export.addActionListener(new ActionListener() {
			final JLabel label = new JLabel();
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean filled = true;
				String cne = null;
				String annee = null;
				Niveau niveau = inscriptionManager.getNiveauByTitle((String) comboBox.getSelectedItem());
				
				if (!Fcne.getText().equals("")) {
					cne = Fcne.getText();
				}else {
					filled = false;
				}if (!Fannee.getText().equals("")) {
					annee = Fannee.getText();
				}else {
					filled = false;
				}			
				if(filled == false) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
				}else {
					
					try {
						File file=ExportManagerImpl.exportBulltinToPDF(cne, Integer.parseInt(annee), niveau.getTitle());
						
						JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				        jfc.setDialogTitle("Choose a directory to save your file: ");
				        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				        int returnValue = jfc.showSaveDialog(null);
				        if (returnValue == JFileChooser.APPROVE_OPTION) {
				            if (jfc.getSelectedFile().isDirectory()) {
				                File str=jfc.getSelectedFile();
				                String sourcePath=file.getAbsolutePath();
				                String targetPath=str.getPath()+File.separator+file.getName();
				                Files.move(Paths.get(sourcePath), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
				            }
				           
					     }
				    } catch (ExportException e1) {
						JOptionPane.showMessageDialog(null,"erreur : "+ e1.getMessage());
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});

		setVisible(false);
	}
}
