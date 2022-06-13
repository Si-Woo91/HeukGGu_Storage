package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Inout {
	static ParkingDTO dto = new ParkingDTO();
	static TotalParking tp = new TotalParking();

	public static void Enterance() throws AuthenException{
		Scanner sc = new Scanner(System.in);
		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formatedNow = now.format(formatter);
		DAO dao = new DAO();
		
		while (true) {
			System.out.println("차량 번호를 입력해주세요!");
			dto.setCarNumber(sc.nextLine());
			boolean isNum = Pattern.matches("^([0-9가-힣]{3,4})\\s?[0-9]{4}", dto.getCarNumber()); // 차량번호 확인 정규표현식

			if (!isNum) {
				System.out.println("잘못된 차량번호입니다.");
			} else {
				System.out.print("1. 정기권(20만원)" + "\t" + "2. 일회권(30분에 5000원, 이후 10분 단위로 1000원씩 부과됩니다)"+"\n"+"[한글입력]>>");
				String num = sc.next();
				
				switch (num) {
				case "정기권":
					dto.setWhatDate(1);
					if(dao.iscommu().containsKey(dto.getCarNumber())) {
						dto.setCarKinds(dao.iscommu().get(dto.getCarNumber()));
						System.out.println("등록된 차량입니다.");
			            System.out.println("입차완료"); 
						dao.insertEntrance(dto.getCarNumber(), dto.getCarKinds(), dto.getEntranceTime());
			        } else {
							System.out.println("등록되지 않은 차량입니다.[등록을 원하시면 '등록'을 입력해주세요.]");
							String pay = sc.next();
							if (pay.equals("등록")) {
								CommutationTicket.CommuTicket();
							}
			        }
					break;
				case "일회권":
					dto.setWhatDate(2);
					System.out.println("차종을 입력해주세요!(경차\t일반)");
					dto.setCarKinds(sc.next());
					if (dto.getCarKinds().equals("경차")) {
						dto.setEntranceTime(now.format(formatter));
					} else if (dto.getCarKinds().equals("일반")) {
						dto.setEntranceTime(now.format(formatter));
					} else {
						return;
					}
					System.out.println("입차완료");
					dao.insertEntrance(dto.getCarNumber(), dto.getCarKinds(),dto.getEntranceTime());
					dao.insertOneTime(dto.getCarNumber());
					return;
				}
			}
			break;
		}
	}

	public static void Exit() throws AuthenException{
		Scanner sc = new Scanner(System.in);
		CommutationTicket ct = new CommutationTicket();
		Payment pay = new Payment();
		DAO dao = new DAO();
		while (true) {
			System.out.println("출차를 진행합니다.");
			System.out.println("차량 번호를 입력해주세요!");
			dto.setCarNumber(sc.next());
			
			boolean isNum = Pattern.matches("^([0-9가-힣]{3,4})\\s?[0-9]{4}", dto.getCarNumber());	// 차량번호 확인 정규표현식

			if (!isNum) {
				System.out.println("잘못된 차량번호입니다.");
				continue;
			} else {
				if(dao.iscommu().containsKey(dto.getCarNumber())) {
					// 해당 차량번호 정기권 남은 날짜 출력
					
					// 날짜 출력 로직
					int exp_date = 0;
					int result = 0;
					
					String date = dao.date().get(dto.getCarNumber());
					String[] date_sp = date.split("\\s");
					String get_date = date_sp[0]; // db에 저장되어 있던 등록 날짜
					
					System.out.println("정기권 등록 날짜 : " + get_date);
					
					// 현재 날짜
					LocalDate now = LocalDate.now();

					System.out.println("현재 날짜 : " + now);
					
					// 현재 날짜 String 타입으로 변경
					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");   
					String formatedNow1 = now.format(formatter1);
					
					// 날짜 포맷 맞춤용 객체
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					try {
						Date r_date = format.parse(get_date);
						Date n_date = format.parse(formatedNow1);
						
						long diffSec = (n_date.getTime() - r_date.getTime()) / 1000; // 초 차이
						long diffDays = diffSec / (24*60*60);	// 일 차이
						
						exp_date = 30 - (int)diffDays;
						
					} catch (ParseException e) {
						e.printStackTrace();
					} // 날짜 출력 로직 끝
					
					if(exp_date>0) {
						System.out.println(exp_date + "일 남았습니다.");	
						result = dao.deleteExit(dto.getCarNumber());
					} else {
						System.out.println("정기권 종료일 입니다.\n정기권 연장 없이 주차되어 있을 경우 견인됩니다~");
						
						// 입차 테이블 out
						result = dao.deleteExit(dto.getCarNumber());
						// 정기권 테이블 out
						dao.deleteComm(dto.getCarNumber());
					}
					
				} else {
					// 해당 차량 시간계산 후 요금지불
					String time = (dao.time().get(dto.getCarNumber()));
					String[] time_sp = time.split("\\s");
					String get_time = time_sp[1];
					System.out.println("입차 시간 : " + get_time);
					
					LocalTime now = LocalTime.now();
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
					String formatedNow2 = now.format(formatter2);
					
					SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
					try {
						Date d1 = f.parse(get_time);
						Date d2 = f.parse(formatedNow2);
						
						System.out.println("출차 시간 : " + formatedNow2);
						
						long diff = d2.getTime()-d1.getTime();
						dto.setMin((diff/1000)/60);
						
						System.out.println(dto.getMin() + "분");
						
					} catch (ParseException e) {
						e.printStackTrace();
					} // 요금지불 로직 끝
					
					pay.payment();
					
					// 입차 테이블 out
					int result = dao.deleteExit(dto.getCarNumber());
					// 일회권 테이블 out
					dao.deleteOneTime(dto.getCarNumber());
				}
			}
			break;
		}
	}
}