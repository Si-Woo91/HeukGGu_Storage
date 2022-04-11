package digimon;			//22_04_04_22_43

import java.util.Scanner;


public class Digivice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		/*
		 *  DigimonGame 클래스의 myDigimon 변수를 선언만 한다.
		 *  * null 값으로 받은 이유
		 *  아래에서 디지몬을 선택할 시 각 디지몬들의 클래스 즉, DigimonGame의 자식클래스들로 객체를 생성하기 위하여 
		 *  myDigimon이라는 변수만 선언하고 null 값을 담아 두었다.
		 */

		DigimonGame myDigimon = null;										
		System.out.println("-----------------------------------------------");
		System.out.println("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□");
		System.out.println("□■□■□■□■□■□■□■□■□■□■□   □■□■□■□■□■□■□■□■□■□■□■□");
		System.out.println("□■□■□■□■□■□■□■□■□■□       ■□■□■□■□■□■□■□■□■□■□■");
		System.out.println("□■□■□■□■□■□■□■□■□           ■□■□■□■□■□■□■□■□■□■");
		System.out.println("□■□■□■□■□■□■□■□■   Digimon   □■□■□■□■□■□■□■□■□■");
		System.out.println("□■□■□■□■□■□■□■□■ Tamagotchi  ■□■□■□■□■□■□■□■□■□");
		System.out.println("□■□■□■□■□■□■□■□■             ■□■□■□■□■□■□■□■□■□");
		System.out.println("□■□■□■□■□■□■□■□■□           □■□■□■□■□■□■□■□■□■□");
		System.out.println("□■□■□■□■□■□■□■□■□■□        ■□■□■□■□■□■□■□■□■□■□");
		System.out.println("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□");
		System.out.println("-----------------------------------------------");
		System.out.println("		  --게임 시작--			");
		System.out.println("디지몬을 선택 하시오.");
		System.out.println("1. 아구몬\n2. 파피몬\n3. 파닥몬");
		System.out.println("(해당 숫자를 제외한 것을 입력시 기본으로 아구몬이 선택됩니다.)");
		System.out.printf("선택 >> ");
		String choice = sc.nextLine();
		System.out.println();

		if(choice.equals("2")) {														// 파피몬 선택
			myDigimon = new Gabumon();
			System.out.println("파피몬이 선택되었습니다.");
		}else if(choice.equals("3")) {													// 파닥몬 선택
			myDigimon = new Patamon();
			System.out.println("파닥몬이 선택되었습니다.");
		}else {
			myDigimon = new Agumon();													// 1과 해당 숫자 외 입력시 기본으로 아구몬 선택
			System.out.println("아구몬이 선택되었습니다.");
		}
//-------------------------------------------------------------------------------------		
		
		while(true) {
			System.out.println("1. 먹기\n2. 잠자기\n3. 걷기\n4. 상태보기\n5. 끝내기");
			System.out.printf("선택 >> ");
			choice = sc.nextLine();
			
			if(choice.equals("5")) {													// 선택시 반복문 탈출해서 게임 종료
				break;
			}else if(choice.equals("1")) {												// 자식타입에 재정의 된 Eat()이 실행
				myDigimon.Eat();
			}else if(choice.equals("2")) {												// 자식타입에 재정의 된 Sleep()이 실행
				myDigimon.Sleep();
			}else if(choice.equals("3")) {												// 자식타입에 재정의 된 Walk()이 실행
				if(myDigimon.getHp() != 0 && myDigimon.getSatiety() != 0) {				
					myDigimon.Walk();
				}else {																	// hp 또는 satiety 둘 중 하나가 0이면 더이상 걷지 못하고 다시 선택하기
					System.out.println("체력 또는 포만감을 채우고 실행 해주세요.");
				}
			}else if(choice.equals("4")) {												// 자식타입에 재정의 된 ShowState()이 실행
				myDigimon.ShowState();
			}else {
				System.out.println("잘 못 입력했습니다.\n");
			}
		}
		sc.close();
	}	
}
