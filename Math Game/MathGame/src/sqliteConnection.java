import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn = null;

	public static Connection dbConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://mathgameadventure.com:3306/jhallen_mathgame",
					"jhallen", "jon9999");
			// JOptionPane.showMessageDialog(null, "Connection successful.");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
