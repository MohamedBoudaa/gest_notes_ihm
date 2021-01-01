package com.components;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.bll.SearchManager;
import com.bll.SearchManagerImpl;
import com.gui.LoginPannel;
import com.gui.SearchPane;

public class DisplayDetailsBtn extends ButtonColumn{
	
	


	public static final SearchManagerImpl SM = new SearchManagerImpl();
	public static final String label = "(+)";
	private String cne ;
	private JPanel panel ;

	
	public DisplayDetailsBtn(JTable table, int column) {
		super(table, column);
		
	}
	public DisplayDetailsBtn(JTable table, int column,String cne,JPanel panel) {
		super(table, column);
		this.cne = cne;
		this.panel = panel;
	}
	
	
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		
//		
//	}


	

	public String getCne() {
		return cne;
	}


	public void setCne(String cne) {
		this.cne = cne;
	}
	
	
	
	
}
