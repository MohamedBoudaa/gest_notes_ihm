package com.gui;

import javax.swing.JPanel;

import com.bll.ImportManagerImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ImportPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public ImportPane() {

		setSize(1003, 769);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(11, 11, 483, 747);
		add(panel);
		panel.setLayout(null);
		
		JButton importBtn = new JButton("New button");
		importBtn.setBounds(10, 11, 156, 54);
		panel.add(importBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(503, 11, 490, 747);
		add(panel_1);
		
		
		importBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();

					ImportManagerImpl.importFromCsvFile(selectedFile.getAbsolutePath());
				}

			}
		});
		
		
		
		setVisible(false);
	}
}
