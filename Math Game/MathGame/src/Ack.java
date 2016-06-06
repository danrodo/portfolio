import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Ack {

	JFrame frame;
	
	String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ack window = new Ack("AHenley");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ack(String UserName){
		username = UserName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 743, 688);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMap = new JButton("Map");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnMap.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnMap.setBounds(41, 599, 164, 41);
		frame.getContentPane().add(btnMap);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnLogout.setBounds(549, 599, 164, 41);
		frame.getContentPane().add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/King-icon.png"));
		label.setBounds(0, 493, 84, 74);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images/Santa-icon.png"));
		label_1.setBounds(96, 493, 79, 80);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("images/Pirate-icon.png"));
		label_2.setBounds(176, 447, 120, 141);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("images/Mermaid-icon.png"));
		label_3.setBounds(308, 483, 106, 104);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("images/Robot-icon (1).png"));
		label_4.setBounds(365, 337, 250, 250);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(582, 379, 66, 59);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("images/chief-icon.png"));
		label_6.setBounds(605, 459, 118, 128);
		frame.getContentPane().add(label_6);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("images/ackBackground.png"));
		imageLabel.setBounds(0, 208, 743, 379);
		frame.getContentPane().add(imageLabel);
		
		JLabel lblCongradulations = new JLabel("Congradulations!");
		lblCongradulations.setBounds(0, 0, 675, 59);
		lblCongradulations.setForeground(new Color(0, 0, 0));
		lblCongradulations.setBackground(Color.ORANGE);
		lblCongradulations.setFont(new Font("Lucida Bright", Font.PLAIN, 50));
		lblCongradulations.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblCongradulations);
		
		JTextArea mainTextarea = new JTextArea();
		mainTextarea.setBounds(0, 59, 743, 607);
		mainTextarea.setForeground(new Color(255, 255, 255));
		mainTextarea.setBackground(new Color(100, 149, 237));
		mainTextarea.setEditable(false);
		mainTextarea.setFont(new Font("Lucida Bright", Font.PLAIN, 30));
		mainTextarea.setWrapStyleWord(true);
		mainTextarea.setLineWrap(true);
		mainTextarea.setText("Well done " + username + "! You finished the game. Click logout to exit out of the game, or click map to go replay any level!");
		frame.getContentPane().add(mainTextarea);
	}
}
