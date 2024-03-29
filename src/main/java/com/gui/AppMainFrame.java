package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.bll.ImportManagerImpl;
import com.bll.SearchManagerImpl;
import com.bo.Module;

import java.awt.SystemColor;

public class AppMainFrame extends JFrame {

	private JPanel contentPane;
	private static final String URL_RESOURCES = new String("src/main/java/com/resources/");
	private static final SearchManagerImpl searchManager = new SearchManagerImpl();
	private SearchPane searchPane;
	private AddStudentPane addStudentPane;
	private ImportPane importPane;
	private ExportPane exportPane;
	private MoyennesPane moyennesPane;

	
	
	/**
	 * Create the frame.
	 */
	public AppMainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1256, 700);
		setLocationRelativeTo(null); // centrer sur l ecrant
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		setUndecorated(true);

		JLabel lblX = new JLabel("X");
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblX.setBackground(new Color(230, 230, 250));
		lblX.setBounds(1225, 2, 31, 27);
		contentPane.add(lblX);

		////////////////////////////////////////////////////////////////////////////////////
		/// CLOSE ON CLICK LABEL X MOUSE EVENT
		////////////////////////////////////////////////////////////////////////////////////

		lblX.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Etes vous sure de quitter l'application", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.WHITE);
			}

		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(251, 29, 1003, 660);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		searchPane = new SearchPane();
		searchPane.setVisible(true);
		panel_1.add(searchPane);
		addStudentPane = new AddStudentPane();
		panel_1.add(addStudentPane);
		importPane = new ImportPane();
		panel_1.add(importPane);
		moyennesPane = new MoyennesPane();
		panel_1.add(moyennesPane);
		exportPane = new ExportPane();
		panel_1.add(exportPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 72, 141));
		panel.setBounds(2, 2, 241, 698);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(31, 11, 173, 173);

		ImageIcon icon = new ImageIcon(URL_RESOURCES + "logo-ensah.png"); // load the image to a imageIcon
		Image image = icon.getImage(); // transform it
		Image newimg = image.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(),
				java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		icon = new ImageIcon(newimg); // transform it back
		logoLabel.setIcon(icon);
		panel.add(logoLabel);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.addMouseListener(new PanelBtnMouseAdpt(panel_3_1) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(searchPane);
			}
		});
		panel_3_1.setBackground(new Color(0, 82, 151));
		panel_3_1.setBounds(0, 208, 241, 69);
		panel.add(panel_3_1);

		JLabel lblRecherche = new JLabel("Rechercher");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setFont(new Font("Dialog", Font.BOLD, 15));
		lblRecherche.setBounds(59, 11, 172, 47);
		panel_3_1.add(lblRecherche);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.addMouseListener(new PanelBtnMouseAdpt(panel_3_2) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(addStudentPane);
			}
		});
		panel_3_2.setBackground(new Color(0, 82, 151));
		panel_3_2.setBounds(0, 278, 241, 69);
		panel.add(panel_3_2);

		JLabel lblAjouter = new JLabel("Ajouter un \u00E9tudiant");
		lblAjouter.setForeground(Color.WHITE);
		lblAjouter.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAjouter.setBounds(59, 11, 172, 47);
		panel_3_2.add(lblAjouter);

		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.addMouseListener(new PanelBtnMouseAdpt(panel_3_3) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(importPane);


			}

		});
		panel_3_3.setBackground(new Color(0, 82, 151));
		panel_3_3.setBounds(0, 348, 241, 69);
		panel.add(panel_3_3);

		JLabel lblImporter = new JLabel("Importer");
		lblImporter.setForeground(Color.WHITE);
		lblImporter.setFont(new Font("Dialog", Font.BOLD, 15));
		lblImporter.setBounds(59, 11, 172, 47);
		panel_3_3.add(lblImporter);

		JPanel panel_3_3_2 = new JPanel();
		panel_3_3_2.setLayout(null);
		panel_3_3_2.addMouseListener(new PanelBtnMouseAdpt(panel_3_3_2) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(moyennesPane);
				
			}
		});
		panel_3_3_2.setBackground(new Color(0, 82, 151));
		panel_3_3_2.setBounds(0, 418, 241, 69);
		panel.add(panel_3_3_2);

		JLabel lblcalculerMoyennes = new JLabel("Calculer moyennes\r\n");
		lblcalculerMoyennes.setForeground(Color.WHITE);
		lblcalculerMoyennes.setFont(new Font("Dialog", Font.BOLD, 15));
		lblcalculerMoyennes.setBounds(59, 11, 172, 47);
		panel_3_3_2.add(lblcalculerMoyennes);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setLayout(null);
		panel_3_3_1.addMouseListener(new PanelBtnMouseAdpt(panel_3_3_1) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(exportPane);
				
				
			}
		});
		panel_3_3_1.setBackground(new Color(0, 82, 151));
		panel_3_3_1.setBounds(0, 488, 241, 69);
		panel.add(panel_3_3_1);

		JLabel lblExporter = new JLabel("Exporter\r\n");
		lblExporter.setForeground(Color.WHITE);
		lblExporter.setFont(new Font("Dialog", Font.BOLD, 15));
		lblExporter.setBounds(59, 11, 172, 47);
		panel_3_3_1.add(lblExporter);
		
		JPanel panel_3_3_1_1 = new JPanel();
		panel_3_3_1_1.setLayout(null);
		panel_3_3_1_1.addMouseListener(new PanelBtnMouseAdpt(panel_3_3_1_1));
		panel_3_3_1_1.setBackground(new Color(0, 82, 151));
		panel_3_3_1_1.setBounds(0, 629, 241, 69);
		panel.add(panel_3_3_1_1);

		JLabel lblDconnexion = new JLabel("D\u00E9connexion");
		lblDconnexion.setForeground(Color.WHITE);
		lblDconnexion.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDconnexion.setBounds(59, 11, 172, 47);
		panel_3_3_1_1.add(lblDconnexion);

		panel_3_3_1_1.addMouseListener(new PanelBtnMouseAdpt(panel_3_3_1_1) {
			@Override
			public void mouseClicked(MouseEvent e) {
				AppMainFrame.this.dispose();
				
				JFrame f = new LoginPannel();
				f.setVisible(true);
				
				
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////
		/// SET VISIBLE THE CLICKED PANNEL
		////////////////////////////////////////////////////////////////////////////////////

	}

	public void menuClicked(JPanel panel) {
		exportPane.setVisible(false);
		importPane.setVisible(false);
		addStudentPane.setVisible(false);
		searchPane.setVisible(false);
		moyennesPane.setVisible(false);
		panel.setVisible(true);
	}

	private class PanelBtnMouseAdpt extends MouseAdapter {

		JPanel panel;

		public PanelBtnMouseAdpt(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(0, 62, 141));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 82, 151));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(0, 92, 171));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(0, 62, 141));
		}
	}
}
