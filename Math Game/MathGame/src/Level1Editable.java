import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JTextPane;


public class Level1Editable
{

	public JFrame frame;
	private JTextField NPC1Amount;
	private JTextField NPC2Amount;
	private JTextField NPC3Amount;
	private JTextField EndAmount;
	private JLabel TotalLabel;
	private JButton btnNewButton;
	
	int Amount1;
	int Amount2;
	int Amount3;
	int StartAmount;
	int FinalAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Level1Editable window = new Level1Editable();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Level1Editable()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 659, 486);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel TotalPanel = new JPanel();
		TotalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TotalPanel.setBounds(0, 0, 499, 76);
		frame.getContentPane().add(TotalPanel);
		TotalPanel.setLayout(null);
		
		TotalLabel = new JLabel("");
		TotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		TotalLabel.setBounds(10, 11, 479, 54);
		TotalPanel.add(TotalLabel);
		
		JLabel GateKeeper = new JLabel("");
		GateKeeper.setIcon(new ImageIcon("images/King-icon.png"));
		GateKeeper.setBounds(482, 260, 75, 70);
		frame.getContentPane().add(GateKeeper);
		
		JLabel NPC1 = new JLabel("");
		NPC1.setIcon(new ImageIcon("images/Leprechaun-icon.png"));
		NPC1.setBounds(118, 270, 48, 70);
		frame.getContentPane().add(NPC1);
		
		JLabel NPC3 = new JLabel("");
		NPC3.setIcon(new ImageIcon("images/Teacher-icon.png"));
		NPC3.setBounds(348, 175, 48, 58);
		frame.getContentPane().add(NPC3);
		
		JLabel NPC2 = new JLabel("");
		NPC2.setIcon(new ImageIcon("images/Man-icon.png"));
		NPC2.setBounds(286, 260, 48, 70);
		frame.getContentPane().add(NPC2);
		
		btnNewButton = new JButton("Done Editing");
		btnNewButton.setBounds(178, 388, 113, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new doneEditingButtonHandler());
		
		NPC1Amount = new JTextField();
		NPC1Amount.setBounds(99, 250, 86, 20);
		frame.getContentPane().add(NPC1Amount);
		NPC1Amount.setColumns(10);
		
		NPC2Amount = new JTextField();
		NPC2Amount.setBounds(268, 244, 86, 20);
		frame.getContentPane().add(NPC2Amount);
		NPC2Amount.setColumns(10);
		
		NPC3Amount = new JTextField();
		NPC3Amount.setBounds(330, 157, 86, 20);
		frame.getContentPane().add(NPC3Amount);
		NPC3Amount.setColumns(10);
		
		EndAmount = new JTextField();
		EndAmount.setBounds(467, 212, 89, 20);
		frame.getContentPane().add(EndAmount);
		EndAmount.setColumns(10);
		
		JTextPane FinalAmountPane = new JTextPane();
		FinalAmountPane.setText("End Amount");
		FinalAmountPane.setBounds(561, 212, 48, 36);
		frame.getContentPane().add(FinalAmountPane);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(468, 237, 89, 23);
		frame.getContentPane().add(SubmitButton);
		SubmitButton.addActionListener(new submitButtonHandler());
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setBounds(502, 0, 138, 36);
		frame.getContentPane().add(ResetButton);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon("images/backgroundl1.jpg"));
		Background.setBounds(0, 0, 640, 445);
		frame.getContentPane().add(Background);
		
	}
	
	public class doneEditingButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			frame.dispose();
		}
	}
	
	public class submitButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Amount1 = Integer.parseInt(NPC1Amount.getText());
			Amount2 = Integer.parseInt(NPC2Amount.getText());
			Amount3 = Integer.parseInt(NPC3Amount.getText());
			FinalAmount = Integer.parseInt(EndAmount.getText());
			
			if(((Amount1+Amount2+Amount3)==FinalAmount)
					||((Amount1+Amount2)==FinalAmount)
					||((Amount1+Amount3)==FinalAmount)
					||((Amount2+Amount3)==FinalAmount))//only one variable can be wrong for the equation still to be valid
			{
				TotalLabel.setText(FinalAmount + " = " + Amount1 + " + " + Amount2 + " + " + Amount3);
				Connection connection=sqliteConnection.dbConnector();
				{
				try{	
					String entry="insert into Level1 values(0," + Amount1 + "," + Amount2 + "," + Amount3 + "," + FinalAmount + ")";
					java.sql.Statement pst=connection.createStatement();
					pst.executeUpdate(entry);
					pst.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				}
			}
			else
			{
				TotalLabel.setText("This is not a valid equation");
			}
		}
	}
}
