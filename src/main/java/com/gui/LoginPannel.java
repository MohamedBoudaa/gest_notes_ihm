package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class LoginPannel extends JFrame {

	private JPanel formPan;

	private static final String URL_RESOURCES = new String("src/main/java/com/resources/");
	
	private JLabel userLab = new JLabel("Username :");
	private JTextField userF = new JTextField();
	private JLabel pwLab = new JLabel("Password :");
	private JPasswordField pwF = new JPasswordField();
	private final JPanel panel = new JPanel();
	private final JButton btn = new JButton("Connexion");
	private JLabel logoLabel = new JLabel();
	
	/**
	 * Create the frame.
	 */
	public LoginPannel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 347);
		formPan = new JPanel();
		formPan.setBackground(UIManager.getColor("Tree.textBackground"));
		setTitle("Login");
		formPan.setLayout(null);
		panel.setBackground(UIManager.getColor("Tree.textBackground"));
		panel.setBounds(32, 116, 318, 169);
		
		formPan.add(panel);
		panel.setLayout(null);
		userLab.setBounds(0, 0, 82, 89);
		panel.add(userLab);
		userF.setBorder(UIManager.getBorder("RadioButton.border"));
		userF.setBounds(92, 31, 217, 26);
		panel.add(userF);
		pwLab.setBounds(0, 44, 82, 114);
		panel.add(pwLab);
		pwF.setBorder(UIManager.getBorder("RadioButton.border"));
		pwF.setBounds(92, 88, 217, 26);
		panel.add(pwF);
		btn.setBorder(UIManager.getBorder("MenuBar.border"));
		btn.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		btn.setBounds(209, 135, 100, 23);
		
		panel.add(btn);
		
		getContentPane().add(formPan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#005297"));
		panel_1.setBounds(0, 0, 383, 92);
		formPan.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel loginTitle = new JLabel("<html><body>Ecole Nationale des Sciences<br>Appliquées d'Al Hoceima</body></html>");
		loginTitle.setForeground(UIManager.getColor("PasswordField.background"));
		loginTitle.setFont(new Font("Courier New", Font.ITALIC, 15));
		loginTitle.setBounds(91, 11, 282, 58);
		panel_1.add(loginTitle);
		
		logoLabel.setBounds(17, 11, 64, 64);
		
		ImageIcon icon = new ImageIcon(URL_RESOURCES + "logo-ensah.png"); // load the image to a imageIcon
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		
		
		logoLabel.setIcon(icon);
		panel_1.add(logoLabel);
//		validate();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPannel frame = new LoginPannel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
