import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;


public class Level7 {

	JFrame frame;
	
	private int fails = 0;
	
	private String username;
	
	private int total, npc1, npc2, npc3, npc4, npc5, npc6, npc7, npc8, npc9;
	private String equation = "";
	private String newEquation = "";
	
	JLabel equationLabel = new JLabel("");
	
	Connection connection = sqliteConnection.dbConnector();
	{
		try{
			String query="select * from Level7 order by rand() limit 1";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while( rs.next()){
				equation = rs.getString("equation");
				total = rs.getInt("total");
				npc1 = rs.getInt("ans1");
				npc2 = rs.getInt("ans2");
				npc3 = rs.getInt("ans3");
				npc4 = rs.getInt("ans4");
				npc5 = rs.getInt("ans5");
				npc6 = rs.getInt("ans6");
				npc7 = rs.getInt("ans7");
				npc8 = rs.getInt("ans8");
				npc9 = rs.getInt("ans9");
			}
			System.out.println(equation + ", " + total + ", " + npc1 + ", " + npc2 + ", " + npc3 + ", " + npc4 + ", " + npc5 + ", " + npc6 + ", " + npc7 + ", " + npc8 + ", " + npc9);
			
			pst.close();
			rs.close();
		}
		catch(Exception e7){
			JOptionPane.showMessageDialog(null, e7);
			System.exit(0);
		}
	}
	
	
	
	private JTextField npc1Text = new JTextField();
	private JTextField npc2Text = new JTextField();
	private JTextField npc5Text = new JTextField();
	private JTextField npc4Text = new JTextField();
	private JTextField npc3Text = new JTextField();
	private JTextField npc7Text = new JTextField();
	private JTextField npc8Text = new JTextField();
	private JTextField npc6Text = new JTextField();
	private JTextField npc9Text = new JTextField();
	
	JTextArea explanationTextarea = new JTextArea();
	JPanel levelComBorder = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level7 window = new Level7("AHenley");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Level7(String UserName){
		username = UserName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 586);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		npc1Text.setHorizontalAlignment(SwingConstants.CENTER);
		
		levelComBorder.setVisible(false);
		
		npc1Text.setText("" + npc1);
		npc2Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc2Text.setText("" + npc2);
		npc3Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc3Text.setText("" + npc3);
		npc4Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc4Text.setText("" + npc4);
		npc5Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc5Text.setText("" + npc5);
		npc6Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc6Text.setText("" + npc6);
		npc7Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc7Text.setText("" + npc7);
		npc8Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc8Text.setText("" + npc8);
		npc9Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc9Text.setText("" + npc9);
		equationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		equationLabel.setText(equation);
		
		
		levelComBorder.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Congradulations!", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelComBorder.setBounds(165, 96, 349, 394);
		frame.getContentPane().add(levelComBorder);
		levelComBorder.setLayout(null);
		
		JPanel levelComPanel = new JPanel();
		levelComPanel.setBounds(6, 18, 175, 370);
		levelComBorder.add(levelComPanel);
		
		JTextArea txtrCongradulationsYouveFinished = new JTextArea();
		txtrCongradulationsYouveFinished.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtrCongradulationsYouveFinished.setEditable(false);
		txtrCongradulationsYouveFinished.setWrapStyleWord(true);
		txtrCongradulationsYouveFinished.setLineWrap(true);
		txtrCongradulationsYouveFinished.setText("Nice job!!! You've finished the final level in the game. Click continue to move one.");
		levelComPanel.add(txtrCongradulationsYouveFinished);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/star-icon.png"));
		label.setBounds(198, 49, 128, 148);
		levelComBorder.add(label);
		
		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Ack window = new Ack(username);
				window.frame.setVisible(true);
			}
		});
		btnContinue.setBounds(209, 341, 117, 29);
		levelComBorder.add(btnContinue);
		
		
		JLabel chiefLabel = new JLabel("");
		chiefLabel.setIcon(new ImageIcon("images/chief-icon.png"));
		chiefLabel.setBounds(32, 362, 121, 122);
		frame.getContentPane().add(chiefLabel);
		
		JLabel horseLabel = new JLabel("");
		horseLabel.setIcon(new ImageIcon("images/Horse-icon.png"));
		horseLabel.setBounds(277, 377, 101, 102);
		frame.getContentPane().add(horseLabel);
		
		JLabel eagleLabel = new JLabel("");
		eagleLabel.setIcon(new ImageIcon("images/Eagle-icon.png"));
		eagleLabel.setBounds(217, 128, 57, 70);
		frame.getContentPane().add(eagleLabel);
		
		JLabel indianLabel = new JLabel("");
		indianLabel.setIcon(new ImageIcon("images/Indian-icon.png"));
		indianLabel.setBounds(682, 362, 121, 122);
		frame.getContentPane().add(indianLabel);
		
		JLabel mouseLabel = new JLabel("");
		mouseLabel.setIcon(new ImageIcon("images/Mouse-icon.png"));
		mouseLabel.setBounds(176, 433, 57, 78);
		frame.getContentPane().add(mouseLabel);
		
		JLabel rabbitLabel = new JLabel("");
		rabbitLabel.setIcon(new ImageIcon("images/Rabbit-icon.png"));
		rabbitLabel.setBounds(289, 317, 48, 48);
		frame.getContentPane().add(rabbitLabel);
		
		JLabel tigerLabel = new JLabel("");
		tigerLabel.setIcon(new ImageIcon("images/Tiger-icon.png"));
		tigerLabel.setBounds(511, 186, 41, 48);
		frame.getContentPane().add(tigerLabel);
		
		JLabel turtleLabel = new JLabel("");
		turtleLabel.setIcon(new ImageIcon("images/Turtle-icon.png"));
		turtleLabel.setBounds(536, 332, 41, 48);
		frame.getContentPane().add(turtleLabel);
		
		JLabel snakeLabel = new JLabel("");
		snakeLabel.setIcon(new ImageIcon("images/Snake-icon.png"));
		snakeLabel.setBounds(520, 377, 57, 72);
		frame.getContentPane().add(snakeLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "problem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 0, 558, 84);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		equationLabel.setBounds(6, 18, 546, 53);
		panel_1.add(equationLabel);
		
		
		npc1Text.setEditable(false);
		npc1Text.setBounds(60, 337, 68, 28);
		frame.getContentPane().add(npc1Text);
		npc1Text.setColumns(10);
		
		npc2Text.setEditable(false);
		npc2Text.setColumns(10);
		npc2Text.setBounds(165, 421, 68, 28);
		frame.getContentPane().add(npc2Text);
		
		npc5Text.setEditable(false);
		npc5Text.setColumns(10);
		npc5Text.setBounds(287, 471, 68, 28);
		frame.getContentPane().add(npc5Text);
		
		npc4Text.setEditable(false);
		npc4Text.setColumns(10);
		npc4Text.setBounds(277, 288, 68, 28);
		frame.getContentPane().add(npc4Text);
		
		npc3Text.setEditable(false);
		npc3Text.setColumns(10);
		npc3Text.setBounds(206, 110, 68, 28);
		frame.getContentPane().add(npc3Text);
		
		npc7Text.setEditable(false);
		npc7Text.setColumns(10);
		npc7Text.setBounds(490, 159, 68, 28);
		frame.getContentPane().add(npc7Text);
		
		npc8Text.setEditable(false);
		npc8Text.setColumns(10);
		npc8Text.setBounds(520, 312, 68, 28);
		frame.getContentPane().add(npc8Text);
		
		npc6Text.setEditable(false);
		npc6Text.setColumns(10);
		npc6Text.setBounds(509, 433, 68, 28);
		frame.getContentPane().add(npc6Text);
		
		npc9Text.setEditable(false);
		npc9Text.setColumns(10);
		npc9Text.setBounds(712, 337, 68, 28);
		frame.getContentPane().add(npc9Text);
		
		JButton npc1Button = new JButton("choose");
		npc1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc1Text.getText();
				equationLabel.setText(newEquation);
				if(npc1 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
					
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc1Button.setBounds(57, 317, 71, 25);
		frame.getContentPane().add(npc1Button);
		
		JButton npc2Button = new JButton("choose");
		npc2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc2Text.getText();
				equationLabel.setText(newEquation);
				if(npc2 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc2Button.setBounds(162, 403, 71, 25);
		frame.getContentPane().add(npc2Button);
		
		JButton npc5Button = new JButton("choose");
		npc5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc5Text.getText();
				equationLabel.setText(newEquation);
				if(npc5 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc5Button.setBounds(287, 497, 71, 25);
		frame.getContentPane().add(npc5Button);
		
		JButton npc4Button = new JButton("choose");
		npc4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc4Text.getText();
				equationLabel.setText(newEquation);
				if(npc4 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc4Button.setBounds(277, 267, 71, 25);
		frame.getContentPane().add(npc4Button);
		
		JButton npc8Button = new JButton("choose");
		npc8Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc8Text.getText();
				equationLabel.setText(newEquation);
				if(npc8 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc8Button.setBounds(517, 291, 71, 25);
		frame.getContentPane().add(npc8Button);
		
		JButton npc6Button = new JButton("choose");
		npc6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc6Text.getText();
				equationLabel.setText(newEquation);
				if(npc6 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc6Button.setBounds(511, 459, 71, 25);
		frame.getContentPane().add(npc6Button);
		
		JButton npc7Button = new JButton("choose");
		npc7Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc7Text.getText();
				equationLabel.setText(newEquation);
				if(npc7 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc7Button.setBounds(490, 138, 71, 25);
		frame.getContentPane().add(npc7Button);
		
		JButton npc3Button = new JButton("choose");
		npc3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc3Text.getText();
				equationLabel.setText(newEquation);
				if(npc3 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc3Button.setBounds(206, 91, 71, 25);
		frame.getContentPane().add(npc3Button);
		
		JButton npc9Button = new JButton("choose");
		npc9Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newEquation = equation + " = " + npc9Text.getText();
				equationLabel.setText(newEquation);
				if(npc9 == total){
					System.out.println("level complete");
					explanationTextarea.setText("You got the right answer! Great job");
					levelComBorder.setVisible(true);
				
					try{

						String queryMap="select Level from Student where UName='"+username+"'";
						PreparedStatement pst=connection.prepareStatement(queryMap);
						ResultSet rs=pst.executeQuery();
						
						int userLevel = 0 ;
						while(rs.next()){
							userLevel=rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if( userLevel < 8) {
							Statement stmt = connection.createStatement();
							String queryUpdate="UPDATE Student SET Level=8 WHERE UName='"+username+"'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 7, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();

					}catch(Exception p){
						JOptionPane.showMessageDialog(null,p);
						System.exit(1);
					}
				}else{
					System.out.println("fail");
					explanationTextarea.setText("Thats not the right answer, but try again to find the right one!");
					fails ++;
				}
			}
		});
		npc9Button.setBounds(709, 317, 71, 25);
		frame.getContentPane().add(npc9Button);
		
		
		JButton backButton = new JButton("back to map");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		backButton.setBounds(570, 0, 227, 35);
		frame.getContentPane().add(backButton);

		JButton resetButton = new JButton("reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationLabel.setText(equation);
				explanationTextarea.setText("Solve the problem, then choose the animal or person who has the right amount!");
				levelComBorder.setVisible(false);
			}
		});
		resetButton.setBounds(570, 35, 227, 35);
		frame.getContentPane().add(resetButton);
		explanationTextarea.setWrapStyleWord(true);
		explanationTextarea.setLineWrap(true);
		

		explanationTextarea.setEditable(false);
		explanationTextarea.setText("Solve the problem, then choose the animal or person who has the right amount!");
		explanationTextarea.setBounds(587, 94, 210, 70);
		frame.getContentPane().add(explanationTextarea);
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon("images/level7Bg.jpg"));
		bgLabel.setBounds(0, 0, 803, 564);
		frame.getContentPane().add(bgLabel);

	}
}
