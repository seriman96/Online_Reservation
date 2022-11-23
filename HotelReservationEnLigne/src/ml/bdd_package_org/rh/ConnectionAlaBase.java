package ml.bdd_package_org.rh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionAlaBase {
	
		private String url;
		private String username;
		private String password;
		
		public ConnectionAlaBase(String url, String username, String password) {
			this.url = url;
			this.username = username;
			this.password = password;
		}
		
		public static ConnectionAlaBase getInstance() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionAlaBase instance = new ConnectionAlaBase("jdbc:mysql://localhost:3306/hotel","root","");
			return instance;
		}
		
		
		public Connection getConnection() throws SQLException{
			Connection connexion = DriverManager.getConnection(url,username,password);
			
			return connexion;
					
					
			
		}
		
		
		public Option getUtilisateur() {
			return new OptionImple(this);
		}

	

}
