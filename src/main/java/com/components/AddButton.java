package com.components;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.bll.SearchManagerImpl;

public class AddButton  extends ButtonColumn{
	
	public static final String label = "(+)";
	private int index;
	


	
	
	public AddButton(JTable table, int column,int index) {
		super(table, column);
		this.index = index;
		System.out.println(this);

	}





	public int getIndex() {
		return index;
	}





	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null, "Clicked button : "+this);
		
	}
	
	

}
