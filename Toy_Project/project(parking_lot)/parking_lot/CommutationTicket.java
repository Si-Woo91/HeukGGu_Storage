package parking_lot;

/*				시간지나면 견인하조
		김시우, 문기연, 박종휘, 김강영, 박지윤
*/

import java.util.Scanner;
import java.util.regex.Pattern;

public class CommutationTicket {
	
	public static void CommuTicket() throws AuthenException {

		DAO dao = new DAO();

		ParkingDTO dto = new ParkingDTO();

		Scanner sc = new Scanner(System.in);

		// 정기권 등록 시작
		System.out.println("정기권을 선택하셨습니다. \n" + "정기권은 30일 단위이며, 자유롭게 입차 가능합니다.\n"
				+ "다만 기간 내에 연장 또는 기간 초과 후 출차해주지 않으시면 견인되오니 주의 부탁드립니다.");
		for (int i = 0; i < 60; i++) {
			System.out.print("-");
		}

		try {
			Thread.sleep(300); // 0.3초 대기
		} catch (InterruptedException e) {
		}

		// 정기권 남은 수량 조회
		System.out.println("\n정기권 수량 조회 중입니다.");

		try {
			Thread.sleep(300); 
		} catch (InterruptedException e) {
		}

		System.out.println("...");

		try {
			Thread.sleep(300); 
		} catch (InterruptedException e) {
		}

		// TotalParking Class에서 정기권 남은 수량 불러오기
		ParkingMain pm = new ParkingMain();
		if (dao.selectComm().size() == 10) {
			System.out.println("정기권이 마감되었습니다.");

			try {
				Thread.sleep(1500); // 1.5초 대기
			} catch (InterruptedException e) {
			}

			return; // main 화면으로 돌아가기

		} else {
			System.out.println("정기권이 " + (10 - dao.selectComm().size()) + "개 남았습니다.");
		}

		try {
			Thread.sleep(300); 
		} catch (InterruptedException e) {
		}

		System.out.println("정기권을 등록할 수 있습니다.");

		try {
			Thread.sleep(300); 
		} catch (InterruptedException e) {
		}

		try {
			Thread.sleep(300); 
		} catch (InterruptedException e) {
		}

		// 차량 번호 입력
		boolean a = true;
		while (a) {
			System.out.println("차량 번호를 입력해주세요!");
			dto.setCarNumber(sc.nextLine());
				// 오타 방지
				boolean isCarNumber = Pattern.matches("^([0-9가-힣]{3,4})\\s?[0-9]{4}", dto.getCarNumber()); // 차량번호 확인 정규표현식
				if (!isCarNumber) {
					System.out.println("잘못된 차량번호입니다.");
					
					try {
						Thread.sleep(300); 
					} catch (InterruptedException e) {
					}
					
					System.out.println("다시 입력해 주세요.");
					continue;
				} else {
					if(dao.iscommu().containsKey(dto.getCarNumber())) {
						System.out.println("중복된 차량번호입니다. 다시 입력해주세요.");
						continue;
					} else {
						break;
					}
				}
		}
		
		// 차량 소유자 이름 입력
		System.out.println("차량 소유자 이름을 입력해주세요!");
		String name = sc.nextLine();
		dto.setName(name);
		
		// 연락처 입력
		System.out.println("연락처를 입력해주세요!");
		boolean b = true;
		while (b) {
			String phoneNum = sc.nextLine();
			dto.setPhoneNum(phoneNum);

			boolean isPhoneNum = Pattern.matches("^01(?:0|1|)(?:\\d{4})\\d{4}$", dto.getPhoneNum()); // 핸드폰 번호 확인 정규표현식
			if (!isPhoneNum) {
				System.out.println("핸드폰 번호 형식이 맞지 않습니다.");

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
				}

				System.out.println("다시 입력해 주세요.");
				continue;
			}
			break;
		}

		// 차종 입력
		System.out.println("차종을 입력해주세요!");

		Payment pa = new Payment();

		boolean c = true;
		while (c) {
			System.out.println("1. 경차 " + " / " + " 2. 일반");
			String kind = sc.nextLine();
			dto.setCarKinds(kind); // DB등록
			if (dto.getCarKinds().contains("경차") || dto.getCarKinds().contains("1")) {
				System.out.println("10%가 할인됩니다.");
				for (int i = 0; i < 15; i++) {
					System.out.print("-");
				}

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
				}

				System.out.println("\n감사합니다.\n" + "결제창으로 넘어갑니다.");

				dto.setWhatDate(1);
				pa.payment();

			} else if (dto.getCarKinds().contains("일반") || dto.getCarKinds().contains("2")) {
				for (int i = 0; i < 15; i++) {
					System.out.print("-");
				}

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
				}

				System.out.println("\n감사합니다.\n" + "결제창으로 넘어갑니다.");

				dto.setWhatDate(1);
				pa.payment();
				
			} else {
				System.out.println("다시 입력해주세요!");
				continue;
			}
			break;
		}

		// DB에 저장되게 하는 메소드
		 dao.insertCommuTicket(dto.getCarNumber(), dto.getCarKinds(), dto.getName(), dto.getPhoneNum(), dto.getRegistration_date(), dto.getTerm());
	}
	
	// 차량번호 중복제거 매소드
	public static boolean already(String Car_Num) {
		ParkingDTO dto = new ParkingDTO();
		DAO dao = new DAO();
		return dao.selectComm().contains(dto.getCarNumber());
	}
}
