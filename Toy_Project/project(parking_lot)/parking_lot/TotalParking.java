package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

public class TotalParking {
	
	public static int comm() {
		DAO dao = new DAO();
		int a = (10-dao.selectComm().size());
		
		return a;
	}
	
	public static int oneTime() {
		DAO dao = new DAO();
		int a = (20-dao.selectOnetime().size());
		
		return a;
	}
	
	public static void TotalParking() {
		System.out.println("현재 남은 자리");
		System.out.println("정기권 : " + comm() + "	일회권 : " + oneTime());
		
	}
	
	
}