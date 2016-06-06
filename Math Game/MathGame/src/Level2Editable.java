import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Level2Editable
{

	public JFrame frame;
	private JTextField FinalAmount;
	private JTextField NPC4Amount;
	private JTextField NPC5Amount;
	private JTextField NPC2Amount;
	private JTextField NPC3Amount;
	private JTextField NPC1Amount;
	private JLabel TotalLabel;
	private JButton btnNewButton;
	
	int Amount1;
	int Amount2;
	int Amount3;
	int Amount4;
	int Amount5;
	int StartAmount;
	int EndAmount;
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
					Level2Editable window = new Level2Editable();
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
	public Level2Editable()
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
		
		JLabel gateKeeperLabel = new JLabel("");
		gateKeeperLabel.setIcon(new ImageIcon("images/Santa-icon.png"));
		gateKeeperLabel.setBounds(0, 283, 70, 83);
		frame.getContentPane().add(gateKeeperLabel);
		
		JLabel npc1 = new JLabel("");
		npc1.setIcon(new ImageIcon("images/Snowman-icon.png"));
		npc1.setBounds(532, 311, 70, 71);
		frame.getContentPane().add(npc1);
		
		JLabel npc2 = new JLabel("");
		npc2.setIcon(new ImageIcon("images/Ninja-icon.png"));
		npc2.setBounds(273, 321, 48, 61);
		frame.getContentPane().add(npc2);
		
		JLabel npc3 = new JLabel("");
		npc3.setIcon(new ImageIcon("images/Firefighter-icon.png"));
		npc3.setBounds(391, 283, 57, 61);
		frame.getContentPane().add(npc3);
		
		JLabel npc4 = new JLabel("");
		npc4.setIcon(new ImageIcon("images/Dragon-icon.png"));
		npc4.setBounds(151, 114, 48, 53);
		frame.getContentPane().add(npc4);
		
		JLabel npc5 = new JLabel("");
		npc5.setIcon(new ImageIcon("images/Knight-icon.png"));
		npc5.setBounds(273, 170, 57, 53);
		frame.getContentPane().add(npc5);
		
		btnNewButton = new JButton("Done Editing");
		btnNewButton.setBounds(178, 388, 113, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new doneEditingButtonHandler());
		
		NPC2Amount = new JTextField();
		NPC2Amount.setBounds(266, 304, 57, 20);
		frame.getContentPane().add(NPC2Amount);
		NPC2Amount.setColumns(10);
		
		NPC5Amount = new JTextField();
		NPC5Amount.setBounds(273, 147, 57, 20);
		frame.getContentPane().add(NPC5Amount);
		NPC5Amount.setColumns(10);
		
		NPC4Amount = new JTextField();
		NPC4Amount.setBounds(146, 94, 57, 20);
		frame.getContentPane().add(NPC4Amount);
		NPC4Amount.setColumns(10);
		
		FinalAmount = new JTextField();
		FinalAmount.setBounds(20, 232, 69, 20);
		frame.getContentPane().add(FinalAmount);
		FinalAmount.setColumns(10);
		
		NPC1Amount = new JTextField();
		NPC1Amount.setBounds(521, 292, 86, 20);
		frame.getContentPane().add(NPC1Amount);
		NPC1Amount.setColumns(10);
		
		NPC3Amount = new JTextField();
		NPC3Amount.setBounds(391, 263, 60, 20);
		frame.getContentPane().add(NPC3Amount);
		NPC3Amount.setColumns(10);
		
		JTextPane FinalAmountPane = new JTextPane();
		FinalAmountPane.setText("End Amount");
		FinalAmountPane.setBounds(19, 263, 70, 20);
		frame.getContentPane().add(FinalAmountPane);
		
		JPanel TotalPanel = new JPanel();
		TotalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TotalPanel.setBounds(0, 0, 499, 76);
		frame.getContentPane().add(TotalPanel);
		TotalPanel.setLayout(null);
		
		TotalLabel = new JLabel("");
		TotalLabel.setBounds(10, 11, 479, 54);
		TotalPanel.add(TotalLabel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(0, 362, 89, 23);
		frame.getContentPane().add(SubmitButton);
		SubmitButton.addActionListener(new submitButtonHandler());
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setBounds(502, 0, 138, 36);
		frame.getContentPane().add(ResetButton);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon("images/level2Background.jpg"));
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
			Amount4 = Integer.parseInt(NPC4Amount.getText());
			Amount5 = Integer.parseInt(NPC5Amount.getText());
			EndAmount = Integer.parseInt(FinalAmount.getText());
			
			if(((Amount1+Amount2+Amount3+Amount4+Amount5)==EndAmount)
					||((Amount1+Amount2+Amount3+Amount4)==EndAmount)
					||((Amount1+Amount2+Amount3+Amount5)==EndAmount)
					||((Amount1+Amount2+Amount4+Amount5)==EndAmount)
					||((Amount1+Amount3+Amount4+Amount5)==EndAmount)
					||((Amount2+Amount3+Amount4+Amount5)==EndAmount)
					||((Amount1+Amount2+Amount3)==EndAmount)
					||((Amount1+Amount2+Amount4)==EndAmount)
					||((Amount1+Amount2+Amount5)==EndAmount)
					||((Amount1+Amount3+Amount4)==EndAmount)
					||((Amount1+Amount3+Amount5)==EndAmount)
					||((Amount1+Amount4+Amount5)==EndAmount)
					||((Amount2+Amount3+Amount4)==EndAmount)
					||((Amount2+Amount3+Amount5)==EndAmount)
					||((Amount2+Amount4+Amount5)==EndAmount)
					||((Amount3+Amount4+Amount5)==EndAmount)
					||((Amount1+Amount2)==EndAmount)
					||((Amount1+Amount3)==EndAmount)
					||((Amount1+Amount4)==EndAmount)
					||((Amount1+Amount5)==EndAmount)
					||((Amount2+Amount3)==EndAmount)
					||((Amount2+Amount4)==EndAmount)
					||((Amount2+Amount5)==EndAmount)
					||((Amount3+Amount4)==EndAmount)
					||((Amount3+Amount5)==EndAmount)
					||((Amount4+Amount5)==EndAmount))//up to any 3 variables can be wrong and the equation will still work
			{
				TotalLabel.setText(EndAmount + " = " + Amount1 + " + " + Amount2 + " + " + Amount3 + " + " + Amount4 + " + " + Amount5);
				Connection connection=sqliteConnection.dbConnector();
				{
				try{	
					String entry="insert into Level2 values(0," + Amount1 + "," + Amount2 + "," + Amount3 + "," + Amount4 + "," + Amount5 + "," + EndAmount + ")";
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
