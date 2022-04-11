package digimon;			//22_04_04_22_43

public class Gabumon extends DigimonGame {

	Gabumon() {															// 생성자
		super(100, 150, "파피몬");										// 기본 체력, 포만감, 이름
	}

	
	@Override
	public void Eat() {
		System.out.println("\n파피몬이 먹이를 먹습니다.\n맛있어 매튜\n");
		this.setHp(6);													// 체력 6증가
		this.setSatiety(9, 150);										// 포만감 9증가, 최대포만감 150
		super.Eat();
		super.StatusOutput();
	}
	
	
	@Override
	public void Sleep() {
		System.out.println("\n매튜 나 잘게~");
		
		this.setHp(4);													// 체력 4증가
		this.setSatiety(-4, 150);										// 체력 4감소, 최대포만감 150
		super.Sleep();
		super.StatusOutput();
	}

	
	@Override
	public void Walk() {
		for(int i = 0; i < 4; i++ ) {									// 걷기 실행시 텍스트 4번 출력(0.6초동안)
			System.out.println("뚜벅");
			try {
				Thread.sleep(600);
			} catch (Exception e) {
			}
		}
		this.setHp(-3);													// 체력 3감소
		this.setSatiety(-6, 150);										// 포만감 6감소, 최대포만감 150
		super.Walk();
		super.StatusOutput();
	}

	public void Attak() {																// 추상클래스 적용
		System.out.printf("%s이 공격을 합니다.\n파란 불꽃~ \n\n", this.getName());				// 공격 기술명 출력
	}


	
	
	
	
	
	
	
	
	
	

}
