import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.mysql.jdbc.JDBC4ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class studentStats {

	JFrame frame;
	private String username;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentStats window = new studentStats("AHenley");
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
	public studentStats(String student) {
		username = student;
		initialize();
	}
	
	public String calcAvg(int lev){
		int l_fail = 1;
		int rows1 = 1;
		Connection connection = sqliteConnection.dbConnector();
		try {
			String query = "SELECT Fails FROM Problem where UName='"+username+"' AND Level="+lev;
			PreparedStatement pst = connection.prepareStatement(query);
			JDBC4ResultSet rs = (JDBC4ResultSet) pst.executeQuery();
			rows1 = Math.abs((int) rs.getUpdateCount());
			System.out.println("Rows val:" + rows1);			
			while (rs.next()) {
				l_fail += rs.getInt("Fails");
			}

			rs.close();
			pst.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		if(rows1 > 0){
			return String.valueOf(l_fail/rows1);
		}
		
		return "Incomplete";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 412);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		Object rowNames[][] = { {"1", calcAvg(1)}, {"2", calcAvg(2)}, {"3", calcAvg(3)}, {"4", calcAvg(4)}, {"5", calcAvg(5)}, {"6", calcAvg(6)}, {"7", calcAvg(7)} };
		String columnNames[] = { "Level", "Average (Completed/Incorrect)" } ;
		table = new JTable(rowNames, columnNames);
		table.setEnabled(false);
		table.setBounds(31, 115, 485, 246);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		frame.getContentPane().add(table);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(557, 332, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JLabel lblStudent = new JLabel("Student: "+username);
		lblStudent.setBounds(31, 6, 288, 29);
		frame.getContentPane().add(lblStudent);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setBounds(41, 94, 61, 16);
		frame.getContentPane().add(lblLevel);
		
		JLabel lblAveragecompletionsattempts = new JLabel("Average (Attempts/Completions)");
		lblAveragecompletionsattempts.setBounds(272, 94, 244, 16);
		frame.getContentPane().add(lblAveragecompletionsattempts);
	}
}
