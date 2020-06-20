import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnect {

	public void DataCon() {
		String connectionSting = "jdbc:sqlserver://DESKTOP-4G0UGLF\\SQLEXPRESS;database=GSMS;is=true";
		String user = "sa";
		String password = "1212";
		try {
			Connection con = DriverManager.getConnection(connectionSting, user, password);
			System.out.println("Connnected");
			
			String sql = "select id, password from login";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("password") + "-----------" + rs.getString("id"));;
				}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DataBaseConnect dc = new DataBaseConnect();
		dc.DataCon();
	}
}
