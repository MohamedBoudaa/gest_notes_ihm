package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.security.auth.login.LoginException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.bll.LoginManager;
import com.bll.LoginManagerImpl;
import com.bo.Compte;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

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
	private final JLabel lblX = new JLabel("X");
	
	/**
	 * Create the frame.
	 */
	public LoginPannel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 347);
		setLocationRelativeTo ( null );
		setUndecorated(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		///			CLOSE ON CLICK LABEL X MOUSE EVENT
		////////////////////////////////////////////////////////////////////////////////////
		
		lblX.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Etes vous sure de quitter l'application","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					dispose();
				}
			}
			
			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.WHITE);
			}
			
		});
		
		
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		formPan = new JPanel();
		formPan.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		formPan.setBackground(UIManager.getColor("Tree.textBackground"));
		setTitle("Login");
		formPan.setLayout(null);
		panel.setBackground(UIManager.getColor("Tree.textBackground"));
		panel.setBounds(43, 115, 318, 169);
		
		
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
		
		
		//////////////////////////////////////////////////////////////////////////////
		////					Login Event Listener for Button					  ////
		//////////////////////////////////////////////////////////////////////////////
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LoginManager loginManager = new LoginManagerImpl();
		
				Compte compte = new Compte(userF.getText(), new String(pwF.getPassword()) );
				
				try {
					if(loginManager.login(compte)) {
						dispose();
						
						JFrame f = new AppMainFrame();
						f.setVisible(true);
						
					}else {
						throw new LoginException("Mot de passe incorrect");
					}
				}catch(LoginException e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Erreur");
					e2.printStackTrace();
				}
				
			}
		});
		
		
		
		
		panel.add(btn);
		
		getContentPane().add(formPan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#005297"));
		panel_1.setBounds(0, 0, 399, 93);
		formPan.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel loginTitle = new JLabel("<html><body>Ecole Nationale des Sciences<br>Appliquées d'Al Hoceima</body></html>");
		loginTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitle.setForeground(UIManager.getColor("PasswordField.background"));
		loginTitle.setFont(new Font("Courier New", Font.ITALIC, 15));
		loginTitle.setBounds(91, 11, 280, 58);
		panel_1.add(loginTitle);
		
		logoLabel.setBounds(17, 11, 64, 64);
		
		ImageIcon icon = new ImageIcon(URL_RESOURCES + "logo-ensah.png"); // load the image to a imageIcon
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		
		
		logoLabel.setIcon(icon);
		panel_1.add(logoLabel);
		lblX.setBackground(new Color(0, 0, 128));
		lblX.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(368, 0, 31, 27);
		
		panel_1.add(lblX);
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
//					AppMainFrame frame = new AppMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
