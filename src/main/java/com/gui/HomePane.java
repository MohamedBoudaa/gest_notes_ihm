package com.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.SwingConstants;

public class HomePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePane() {
		

		setBounds(0, 0, 1003, 661);
		setLayout(null);
		
		JLabel lblWelcom = new JLabel("Bienvenue sur l'application de gestion des notes");
		lblWelcom.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcom.setBounds(40, 24, 685, 83);
		add(lblWelcom);
		
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		dcd.setValue(78, "marks", "toto");
		dcd.setValue(18, "marks", "bobo");
		dcd.setValue(58, "marks", "soso");
		
		JFreeChart jchart =  ChartFactory.createBarChart3D("Statistiques générales", null, "test", dcd, PlotOrientation.VERTICAL,true,true,false);
	
		CategoryPlot plot = jchart.getCategoryPlot();
		
		plot.setRangeGridlinePaint(Color.black);
		
		ChartPanel chartPan = new ChartPanel(jchart,true);
		chartPan.setLocation(40, 102);
		chartPan.setVisible(true);
		
		chartPan.setSize(760,420);
		add(chartPan);
		setVisible(true);
		
	}

}
