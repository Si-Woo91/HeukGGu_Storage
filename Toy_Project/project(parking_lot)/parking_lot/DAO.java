package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// DB 데이터 넣기
public class DAO {
	ParkingDTO dto = new ParkingDTO();
	
	
	// 정기권 데이터 넣기
	public int insertCommuTicket(String carNumber, String carKinds, String name, String PhoneNum, String Registration_date, int Term) {
		
		int result = 0;
		
		Connection con = DBConn.getConnection();
		// DB에 쿼리 날리는 방식
		PreparedStatement pstmt = null;
		String sql;
		
		
		try {
			sql = "insert into commutationTicket (carNumber, carKinds, name, phoneNum, Registration_date, term)";
			sql += "values (?, ?, ?, ?, sysdate, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, carNumber);
			pstmt.setString(2, carKinds);
			pstmt.setString(3, name);
			pstmt.setString(4, PhoneNum);
			pstmt.setInt(5, Term);
			
/*			executeUpdate 함수를 사용하는 방법입니다.
			 -> INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
			 -> CREATE / DROP 관련 구문에서는 -1 을 반환합니다.*/
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	public int insertOneTime(String carNumber) {
		
		int result = 0;
		
		Connection con = DBConn.getConnection();
		// DB에 쿼리 날리는 방식
		PreparedStatement pstmt = null;
		String sql;
		
		
		try {
			sql = "insert into oneTimeTicket (carNumber)";
			sql += "values (?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, carNumber);
			
			/*			executeUpdate 함수를 사용하는 방법입니다.
			 -> INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
			 -> CREATE / DROP 관련 구문에서는 -1 을 반환합니다.*/
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 입차
	public int insertEntrance(String carNumber, String carKinds, String entranceTime) {
		int result = 0;
		
		Connection con = DBConn.getConnection();
		// DB에 쿼리 날리는 방식
		PreparedStatement pstmt = null;
		String sql;
		
		
		try {
			sql = "insert into entrance(carNumber, carKinds,  entranceTime) ";
			sql += "values (?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, carNumber);
			pstmt.setString(2, carKinds);
			
			/*			executeUpdate 함수를 사용하는 방법입니다.
			 -> INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
			 -> CREATE / DROP 관련 구문에서는 -1 을 반환합니다.*/
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	
		// 총 주차현황 조회
	   public List<ParkingDTO> selectTotalParking() {
	      
	      Connection conn = new DBConn().getConnection();            
	      ArrayList<ParkingDTO> list_day = new ArrayList<ParkingDTO>();      
	      Connection con = null;      
	      PreparedStatement pstmt = null;      
	      ResultSet rs = null;      
	      int index = 1;            
	      try {         
	         con = DBConn.getConnection();         
	         StringBuffer sql = new StringBuffer();         
	         sql.append("select carNumber from entrance");         
	         pstmt = con.prepareStatement(sql.toString());                  
	         
	         //insert, update, delete, select         
	         rs = pstmt.executeQuery();   //쿼리 실행               
	         while(rs.next()) { //데이터베이스형식과 java 형식이 다름.            
	            index = 1;    //1부터 시작            
	            String carNumber = rs.getString(index++);            
	            
	            ParkingDTO dto = new ParkingDTO(carNumber);
	            
	            list_day.add(dto);         
	            }            
	         } catch (SQLException e) {  
	        	 
	            e.printStackTrace();      
	            } 
	      return list_day;
	   }

	   // 정기권 조회
	   public List<ParkingDTO> selectComm() {
		   
		   Connection conn = new DBConn().getConnection();            
		   ArrayList<ParkingDTO> list_comm = new ArrayList<ParkingDTO>();      
		   Connection con = null;      
		   PreparedStatement pstmt = null;      
		   ResultSet rs = null;      
		   int index = 1;            
		   try {         
			   con = DBConn.getConnection();         
			   StringBuffer sql = new StringBuffer();         
			   sql.append("select carNumber from commutationTicket");         
			   pstmt = con.prepareStatement(sql.toString());                  
			   
			   //insert, update, delete, select         
			   rs = pstmt.executeQuery();   //쿼리 실행               
			   while(rs.next()) { //데이터베이스형식과 java 형식이 다름.            
				   index = 1;    //1부터 시작            
				   String carNumber = rs.getString(index++);            
				   
				   ParkingDTO dto = new ParkingDTO(carNumber);
				   
				   list_comm.add(dto);         
			   }            
		   } catch (SQLException e) {  
			   
			   e.printStackTrace();      
		   } 
		   return list_comm;
	   }
	   
	   // 일회권 조회
	   public List<ParkingDTO> selectOnetime() {
		   
		   Connection conn = new DBConn().getConnection();            
		   ArrayList<ParkingDTO> list_ent = new ArrayList<ParkingDTO>();      
		   Connection con = null;      
		   PreparedStatement pstmt = null;      
		   ResultSet rs = null;      
		   int index = 1;            
		   try {         
			   con = DBConn.getConnection();         
			   StringBuffer sql = new StringBuffer();         
			   sql.append("select carNumber from oneTimeTicket");         
			   pstmt = con.prepareStatement(sql.toString());                  
			   
			   //insert, update, delete, select         
			   rs = pstmt.executeQuery();   //쿼리 실행               
			   while(rs.next()) { //데이터베이스형식과 java 형식이 다름.            
				   index = 1;    //1부터 시작            
				   String carNumber = rs.getString(index++);            
				   
				   ParkingDTO dto = new ParkingDTO(carNumber);
				   
				   list_ent.add(dto);         
			   }            
		   } catch (SQLException e) {  
			   
			   e.printStackTrace();      
		   } 
		   return list_ent;
	   }
	
	// 출차
	public int deleteExit(String carNumber) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		
		try {
			String sql = "delete from entrance where carNumber=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, carNumber);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.commit();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
	
	// 정기권 삭제
	public int deleteComm(String carNumber) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		
		try {
			String sql = "delete from commutationTicket where carNumber=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, carNumber);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 일회권 삭제
	public int deleteOneTime(String carNumber) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		
		try {
			String sql = "delete from oneTimeTicket where carNumber=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, carNumber);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 출차 시 시간 가져오는 방법
			public HashMap<String, String> time() {
				HashMap<String, String> time = new HashMap<>();
				
				try {
					Connection conn = DBConn.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from entrance");
					
					while(rs.next()) {
						time.put(rs.getString(1), rs.getString(3));
					}
					System.out.println(time);
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return time;
			}
			
	// 정기권 여부 조회
			public HashMap<String, String> iscommu(){
				HashMap<String, String> iscommu = new HashMap<>();
				
				try {
					Connection conn = DBConn.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from commutationTicket");
					
					while(rs.next()) {
						iscommu.put(rs.getString(1), rs.getString(2));
					}
//					System.out.println(iscommu);
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return iscommu;
			}
			
			public HashMap<String, String> date() {
				HashMap<String, String> date = new HashMap<>();
				
				try {
					Connection conn = DBConn.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from commutationTicket");
					
					while(rs.next()) {
						date.put(rs.getString(1), rs.getString(5));
					}
					System.out.println(date);
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return date;
			}
			
			public HashMap<String, String> ent_carKinds() {
				HashMap<String, String> ent_carKinds = new HashMap<>();
				
				try {
					Connection conn = DBConn.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from entrance");
					
					while(rs.next()) {
						ent_carKinds.put(rs.getString(1), rs.getString(2));
					}
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return ent_carKinds;
			}
}	