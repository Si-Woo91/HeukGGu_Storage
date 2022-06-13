package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

//DTO : 데이터베이스의 data에 접근하기 위한 객체입니다. DataBase에 접근 하기 위한 로직 & 비지니스 로직을 분리하기 위해 사용합니다.
public class ParkingDTO {	
	
	private String carNumber;				// 차량번호
	private String parkingKinds;			// 주차 종류(정기권 / 일회권)
	private static String carKinds;			// 차량 종류(경차 / 일반)
	private static int whatDate;         	// 결제 보조(정기권:1/일회권:2)
	private String Registration_date;		// 정기권 등록날짜
			
	private String name;					// 차량 소유자(정기권)
	private String phoneNum;				// 소유자 연락처(정기권)
	private int term;						// 남은 계약일수
	private boolean reContract;				// 정기권 재계약 유무
	
	private String entranceTime;			// 입차시간
	
	private String payment;					// 결제 방법(카드 / 현금)
	private int amount;						// 결제 금액
	
	private static long min;
	
	// 생성자
	public ParkingDTO(String carNumber) {
		this.carNumber = carNumber;
	}
	public ParkingDTO() {
		this.carNumber = carNumber;
	}
	
	// getter setter
	static long getMin() {
		return min;
	}
	static void setMin(long min) {
		ParkingDTO.min = min;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getParkingKinds() {
		return parkingKinds;
	}
	public void setParkingKinds(String parkingKinds) {
		this.parkingKinds = parkingKinds;
	}
	public String getCarKinds() {
		return carKinds;
	}
	public void setCarKinds(String carKinds) {
		this.carKinds = carKinds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public boolean getReContract() {
		return reContract;
	}
	public void setReContract(boolean reContract) {
		this.reContract = reContract;
	}
	public String getEntranceTime() {
		return entranceTime;
	}
	public void setEntranceTime(String entranceTime) {
		this.entranceTime = entranceTime;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public static int getWhatDate() {
		return whatDate;
	}
	public static void setWhatDate(int whatDate) {
		ParkingDTO.whatDate = whatDate;
	}
	public String getRegistration_date() {
		return Registration_date;
	}
	public void setRegistration_date(String registration_date) {
		Registration_date = registration_date;
	}

	
	
	
	
	
}
