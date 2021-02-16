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

import com.bll.SearchManagerImpl;

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
		lblWelcom.setBounds(263, 11, 460, 83);
		add(lblWelcom);
		
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		dcd.setValue(5, "", "CP1");
		dcd.setValue(11, "", "CP2");
		dcd.setValue(7, "", "GI1");
		dcd.setValue(9, "", "GI2");
		dcd.setValue(3, "", "GI3");
		dcd.setValue(8, "", "GC1");
		dcd.setValue(0, "", "GC2");
		dcd.setValue(6, "", "GC3");
		dcd.setValue(12, "", "GEE1");
		dcd.setValue(1, "", "GEE2");
		dcd.setValue(0, "", "GEE3");
		dcd.setValue(12, "", "GEER1");
		dcd.setValue(11, "", "GEER2");
		dcd.setValue(9, "", "GEER3");
		
		JFreeChart jchart =  ChartFactory.createBarChart3D("Etat d'avancement", null, null, dcd, PlotOrientation.VERTICAL,true,true,false);
	
		CategoryPlot plot = jchart.getCategoryPlot();
		
		plot.setRangeGridlinePaint(Color.black);
		
		ChartPanel chartPan = new ChartPanel(jchart,true);
		chartPan.setLocation(10, 370);
		chartPan.setVisible(true);
		
		chartPan.setSize(592,280);
		add(chartPan);
		setVisible(true);
		
	}
}
