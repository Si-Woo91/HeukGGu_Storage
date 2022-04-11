package digimon;		//22_04_04_22_43

import java.util.Random;
import java.util.Scanner;

public abstract class DigimonGame {
	private int hp;																// 체력
	private int satiety;														// 포만감
	private int step;															// 걸음수
	private int totalStep;														// 누적 걸음수
	private String name;														// 디지몬의 이름
	
	Scanner sc = new Scanner(System.in);										// 선택사항을 입력 받기 위해
	Random rd = new Random();													// 걸음수를 받기 위한 랜덤 클래스 객체 생성
	
	Enemy enemy = new Enemy(100, "데블몬");										// 적 디지몬 객체 생성
			
	public DigimonGame(int hp, int satiety, String name) {						// 최대 체력 및 포만감, 디지몬 이름 설정
		super();
		this.hp = hp;
		this.satiety = satiety;
		this.setName(name);
	}
	
	public void Eat() {															// 음식을 먹었을때 
		// 삼항연산자로 100을 초과하지 못하도록 막아줌
		this.hp = (this.hp == 100)? this.hp = 100 : ((this.hp >= 100)? this.hp = 100: this.hp);
	}
	
	public void Sleep() {														// 수면을 가졌을때
		// 삼항연산자로 100을 초과하지 못하도록 막아줌
		this.hp = (this.hp == 100)? this.hp = 100 : ((this.hp >= 100)? this.hp = 100 : this.hp);
		// 삼항 연산자로 0 또는 0보다 작을때 0으로 고정시키기
		this.satiety = (this.satiety == 0)? this.satiety = 0 : ((this.satiety <= 0)? this.satiety = 0 : this.satiety);
		for(int i = 0; i < 3; i++) {											// 1초 동안 zzZ를 3번 출력하도록
			System.out.println("zzZ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
	
	public void Walk() {														// 걸었을때. 단,체력과 포만감이 1이라도 있으면 실행
		// 삼항연산자로 체력이 0 또는 0보다 작을때 0으로 고정시키기
		this.hp = (this.hp == 0)? this.hp = 0 : ((this.hp <= 0)? this.hp = 0 : this.hp);
		// 삼항연산자로 포만감이 0 또는 0보다 작을때 0으로 고정시키기
		this.satiety = (this.satiety == 0)? this.satiety = 0 : ((this.satiety <= 0)? this.satiety = 0 : this.satiety);

		if(totalStep < 15 ) {													// 걸음수 조건(누적걸음수가 15미만일때)
			this.step = rd.nextInt(5)+1;										// 걸음수를 1부터 받아주기 위해 +1을 해준다.
			System.out.printf("%d걸음 걸었습니다. \n",this.step);
			this.totalStep += this.step;										// 걸음수를 누적걸음수에 더해준다.
			
			if(this.totalStep >= 15) {											// 누적 걸음수가 15이상일경우		
				this.totalStep = 15;											// 15고정하여 출력
				System.out.printf("누적 걸음 수 : %d \n\n", this.totalStep);
				this.Fight();
				this.totalStep = 0;												// 누적 걸음수 0으로 초기화
			}else {																// 누적걸음수가 15가 아닐시 15-현재까지 걸음수 출력
				System.out.printf("누적 걸음 수 : %d \n", this.totalStep);
				System.out.printf("(적을 만나기까지 %d만큼 남았습니다.)\n\n", 15-this.totalStep);
			}
		}	
	}
	
	
	public void Fight() {														// 적이 나타났을때의 싸움을 택할시  
			enemy.appear();														// 적 클래스의 appear를 불러온다.
			System.out.println("1. 싸운다. \n2. 도망간다.");
			System.out.println("(1 또는 2를 제외한 다른걸 입력시 도망간다.)");
		
		String num = sc.nextLine();												// 싸운다 / 도망간다 선택입력받기
	
		switch(num) {													
			case "1": 
				this.Attak();													// 싸움 선택시 Attak 실행
				break;
			default:
				System.out.printf("%s은 도망쳤다. \n\n", this.getName());				// 도망 선택시
				break;
			}	
	}
	
		
	public void StatusOutput() {												// 각 행동을 실행 후 체력, 포만감 출력
		System.out.printf("현재 체력 : %d \n", this.getHp());
		System.out.printf("현재 포만감 : %d \n", this.getSatiety());
		System.out.println();
	}
	
	/*
	 * 디지몬들의 현재 상태를 보여준다
	 * 디지몬 이름, 현재 체력, 현재 포만감
	 */
	public void ShowState() {													
		System.out.printf("-------------------------\n");
		System.out.printf("|	디지몬 상태	|\n");
		System.out.printf("|디지몬 이름:	%s	|\n", this.getName());
		System.out.printf("|현재 체력	: 	%d	|\n", this.getHp());
		System.out.printf("|현재 포만감: 	%d	|\n", this.getSatiety());
		System.out.printf("-------------------------\n\n");
	}

	public abstract void Attak(); 												// 공격을 실행하는 추상메서드
	
	
	public int getHp() {														// 체력
		return hp;
	}

	public void setHp(int hp) {										// 매개변수 hp : 각 디지몬들의 체력 증감이 다르므로  증감폭 설정.
		this.hp += hp;	
	}

	public int getSatiety() {													// 포만감
		return satiety;
	}

	/*
	 *  this.satiety - 현재 포만감
	 *  매개변수 satiety - 포만감 증감폭
	 *  maxSat - 각 디지몬의 최대 포만감
	 *  각 디지몬마다 증감폭이 다르기때문에  기본적으로 증가를 해주게 설정하고 각 디지몬 클래스에서 증가 또는 감소의 폭을 설정해준다.
	 *  현재 포만감이 최대 포만감과 같거나 크면 최대 포만감으로 고정하고, 그렇지 않으면 현재 포만감을 돌려주는 삼항연산자를 사용.
	 */
	public void setSatiety(int satiety, int maxSatiety) {
		this.satiety += satiety;
		this.satiety = (this.satiety == maxSatiety)? this.satiety =  maxSatiety: ((this.satiety >= maxSatiety)? this.satiety = maxSatiety : this.satiety) ;
	}

	public int getStep() {														// 걸음수
		return step;			
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getTotalStep() {													// 누적걸음수
		return totalStep;
	}

	public void setTotalStep(int totalStep) {
		this.totalStep = totalStep ;
	}
	
	public String getName() {													// 디지몬 이름									
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
