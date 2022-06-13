package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection dbConn;
	
	public static Connection getConnection(){

		
		if(dbConn==null){
			
			try {
			
				String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
				
				String user = "parking";
				String password = "1234";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbConn = DriverManager.getConnection(url, user, password);
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return dbConn;
	}

	
	public static void close(){
		
		if(dbConn!=null){

			try {
				
				if(!dbConn.isClosed()){
					dbConn.close();
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		dbConn = null;

	}
}