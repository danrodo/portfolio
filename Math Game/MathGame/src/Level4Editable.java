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


public class Level4Editable
{

	JFrame frame;
	private JTextField StartAmountInput;
	
	JLabel pile1 = new JLabel("");
	JLabel pile2 = new JLabel("");
	JLabel pile3 = new JLabel("");
	JLabel pile4 = new JLabel("");
	JLabel pile5 = new JLabel("");
	JLabel pile6 = new JLabel("");
	private final JTextField FinalAmount = new JTextField();
	private final JTextPane FinalAmountPane = new JTextPane();
	private final JTextField Amount1 = new JTextField();
	private final JTextField Amount3 = new JTextField();
	private final JTextField Amount2 = new JTextField();
	private final JTextField Amount4 = new JTextField();
	private final JTextField Amount5 = new JTextField();
	private final JTextField Amount6 = new JTextField();
	private final JButton SubmitButton = new JButton("Submit");
	private JLabel TotalLabel;
	
	int amount1;
	int amount2;
	int amount3;
	int amount4;
	int amount5;
	int amount6;
	int startamount;
	int finalamount;

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
					Level4Editable window = new Level4Editable();
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
	public Level4Editable()
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
		
		JLabel gkLabel = new JLabel("");
		gkLabel.setIcon(new ImageIcon("images/Pirate-icon.png"));
		gkLabel.setBounds(42, 150, 117, 135);
		frame.getContentPane().add(gkLabel);
		
		
		pile1.setIcon(new ImageIcon("images/cannonballs.png"));
		pile1.setBounds(229, 229, 30, 36);
		frame.getContentPane().add(pile1);
		
		
		pile2.setIcon(new ImageIcon("images/cannonball.png"));
		pile2.setBounds(387, 312, 37, 36);
		frame.getContentPane().add(pile2);
		
		
		pile3.setIcon(new ImageIcon("images/cannonballs.png"));
		pile3.setBounds(371, 250, 30, 35);
		frame.getContentPane().add(pile3);
		
		
		pile4.setIcon(new ImageIcon("images/cannonball.png"));
		pile4.setBounds(491, 341, 30, 36);
		frame.getContentPane().add(pile4);
		
		
		pile5.setIcon(new ImageIcon("images/cannonball.png"));
		pile5.setBounds(530, 324, 30, 36);
		frame.getContentPane().add(pile5);
		
		
		pile6.setIcon(new ImageIcon("images/cannonballs.png"));
		pile6.setBounds(375, 386, 37, 36);
		frame.getContentPane().add(pile6);
		
		StartAmountInput = new JTextField();
		StartAmountInput.setBounds(527, 42, 86, 20);
		frame.getContentPane().add(StartAmountInput);
		StartAmountInput.setColumns(10);
		FinalAmount.setBounds(42, 96, 86, 20);
		FinalAmount.setColumns(10);
		
		frame.getContentPane().add(FinalAmount);
		Amount1.setBounds(219, 205, 50, 20);
		Amount1.setColumns(10);
		
		frame.getContentPane().add(Amount1);
		Amount2.setBounds(381, 296, 43, 20);
		Amount2.setColumns(10);
		
		frame.getContentPane().add(Amount2);
		Amount3.setBounds(362, 229, 50, 20);
		Amount3.setColumns(10);
		
		frame.getContentPane().add(Amount3);
		Amount4.setBounds(487, 324, 37, 20);
		Amount4.setColumns(10);
		
		frame.getContentPane().add(Amount4);
		Amount5.setBounds(524, 310, 36, 20);
		Amount5.setColumns(10);
		
		frame.getContentPane().add(Amount5);
		Amount6.setBounds(366, 362, 50, 20);
		Amount6.setColumns(10);
		
		frame.getContentPane().add(Amount6);
		FinalAmountPane.setText("End Amount");
		FinalAmountPane.setBounds(50, 127, 75, 20);
		
		frame.getContentPane().add(FinalAmountPane);
		
		JTextPane StartAmountPane = new JTextPane();
		StartAmountPane.setText("Start Amount");
		StartAmountPane.setBounds(537, 72, 75, 20);
		frame.getContentPane().add(StartAmountPane);
		
		JPanel TotalPanel = new JPanel();
		TotalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		TotalPanel.setBounds(0, 0, 499, 76);
		frame.getContentPane().add(TotalPanel);
		TotalPanel.setLayout(null);
		
		TotalLabel = new JLabel("");
		TotalLabel.setBounds(10, 11, 479, 54);
		TotalPanel.add(TotalLabel);
		
		SubmitButton.setBounds(52, 293, 89, 23);
		frame.getContentPane().add(SubmitButton);
		SubmitButton.addActionListener(new submitButtonHandler());
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.setBounds(502, 0, 138, 36);
		frame.getContentPane().add(ResetButton);
		
		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon("images/pirateshipbg.jpg"));
		Background.setBounds(0, 0, 640, 445);
		frame.getContentPane().add(Background);
		
		
	}
	public class submitButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			amount1 = Integer.parseInt(Amount1.getText());
			amount2 = Integer.parseInt(Amount2.getText());
			amount3 = Integer.parseInt(Amount3.getText());
			amount4 = Integer.parseInt(Amount4.getText());
			amount5 = Integer.parseInt(Amount5.getText());
			amount6 = Integer.parseInt(Amount6.getText());
			startamount = Integer.parseInt(StartAmountInput.getText());
			finalamount = Integer.parseInt(FinalAmount.getText());
			
			if(((startamount-amount1-amount2-amount3-amount4-amount5-amount6)==finalamount)
				||((startamount-amount1-amount2-amount3-amount4-amount5)==finalamount)
				||((startamount-amount1-amount2-amount3-amount4-amount6)==finalamount)
				||((startamount-amount1-amount2-amount3-amount5-amount6)==finalamount)
				||((startamount-amount1-amount2-amount4-amount5-amount6)==finalamount)
				||((startamount-amount1-amount3-amount4-amount5-amount6)==finalamount)
				||((startamount-amount2-amount3-amount4-amount5-amount6)==finalamount)
				||((startamount-amount1-amount2-amount3-amount4)==finalamount)
				||((startamount-amount1-amount2-amount3-amount5)==finalamount)
				||((startamount-amount1-amount2-amount3-amount6)==finalamount)
				||((startamount-amount1-amount2-amount4-amount5)==finalamount)
				||((startamount-amount1-amount2-amount4-amount6)==finalamount)
				||((startamount-amount1-amount2-amount5-amount6)==finalamount)
				||((startamount-amount1-amount2-amount4-amount6)==finalamount)
				||((startamount-amount1-amount2-amount5-amount6)==finalamount)
				||((startamount-amount1-amount3-amount4-amount5)==finalamount)
				||((startamount-amount1-amount3-amount4-amount6)==finalamount)
				||((startamount-amount1-amount3-amount5-amount6)==finalamount)
				||((startamount-amount1-amount4-amount5-amount6)==finalamount)
				||((startamount-amount2-amount3-amount4-amount5)==finalamount)
				||((startamount-amount2-amount3-amount4-amount6)==finalamount)
				||((startamount-amount2-amount3-amount5-amount6)==finalamount)
				||((startamount-amount2-amount4-amount5-amount6)==finalamount)
				||((startamount-amount3-amount4-amount5-amount6)==finalamount)
				||((startamount-amount1-amount2-amount3)==finalamount)
				||((startamount-amount1-amount2-amount4)==finalamount)
				||((startamount-amount1-amount2-amount5)==finalamount)
				||((startamount-amount1-amount2-amount6)==finalamount)
				||((startamount-amount1-amount3-amount4)==finalamount)
				||((startamount-amount1-amount3-amount5)==finalamount)
				||((startamount-amount1-amount3-amount6)==finalamount)
				||((startamount-amount1-amount4-amount5)==finalamount)
				||((startamount-amount1-amount4-amount6)==finalamount)
				||((startamount-amount1-amount5-amount6)==finalamount)
				||((startamount-amount2-amount3-amount4)==finalamount)
				||((startamount-amount2-amount3-amount5)==finalamount)
				||((startamount-amount2-amount3-amount6)==finalamount)
				||((startamount-amount2-amount4-amount5)==finalamount)
				||((startamount-amount2-amount4-amount6)==finalamount)
				||((startamount-amount2-amount5-amount6)==finalamount)
				||((startamount-amount3-amount4-amount5)==finalamount)
				||((startamount-amount3-amount4-amount6)==finalamount)
				||((startamount-amount3-amount5-amount6)==finalamount)
				||((startamount-amount4-amount5-amount6)==finalamount)
				||((startamount-amount1-amount2)==finalamount)
				||((startamount-amount1-amount3)==finalamount)
				||((startamount-amount1-amount4)==finalamount)
				||((startamount-amount1-amount5)==finalamount)
				||((startamount-amount1-amount6)==finalamount)
				||((startamount-amount2-amount3)==finalamount)
				||((startamount-amount2-amount4)==finalamount)
				||((startamount-amount2-amount5)==finalamount)
				||((startamount-amount2-amount6)==finalamount)
				||((startamount-amount3-amount4)==finalamount)
				||((startamount-amount3-amount5)==finalamount)
				||((startamount-amount3-amount6)==finalamount)
				||((startamount-amount4-amount5)==finalamount)
				||((startamount-amount4-amount6)==finalamount)
				||((startamount-amount5-amount6)==finalamount))//up to any 4 variables can be wrong and the equation will still work
			{
				TotalLabel.setText(finalamount + " = " + startamount + " - " + amount1 + " - " + amount2 + " - " + amount3 + " - " + amount4 + " - " + amount5 + " - " + amount6);
				Connection connection=sqliteConnection.dbConnector();
				{
				try{	
					String entry="insert into Level4 values( 0," + finalamount + "," + amount1 + "," + amount2 + "," + amount3 + "," + amount4 + "," + amount5 + "," + amount6 + "," + startamount + ")";
					java.sql.Statement pst=connection.createStatement();
					pst.executeUpdate(entry);
					pst.close();
				}catch(Exception e){
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
