package digimon;			//22_04_04_22_43

public class Patamon extends DigimonGame {

	Patamon() {																		// 생성자
		super(100, 200, "파닥몬");													// 기본 체력, 포만감, 이름
	}

	
	@Override
	public void Eat() {									
		System.out.println("\n파닥몬이 먹이를 먹습니다.\n리키도 이거 먹어봐\n");
		this.setHp(6);																// 체력 6증가
		this.setSatiety(7, 200);													// 포만감 7증가, 최대 포만감 200
		super.Eat();
		super.StatusOutput();
	}
	
	
	@Override
	public void Sleep() {								
		System.out.println("\n리키 나 졸려~");
		this.setHp(5);																// 체력 5증가
		this.setSatiety(-3, 200);													// 포만감 3감소, 최대 포만감 200
		super.Sleep();
		super.StatusOutput();
	}

	
	@Override
	public void Walk() {								
		for(int i = 0; i < 4; i++ ) {												// 걷기 실행시 텍스트 4번 출력(0.6초동안)
			System.out.println("파닥");
			try {
				Thread.sleep(600);
			} catch (Exception e) {
			}
		}
		this.setHp(-6);																// 체력 6감소
		this.setSatiety(-5, 200);													// 포만감 5감소, 최대 포만감 200
		super.Walk();
		super.StatusOutput();
	}

	public void Attak() {															// 추상클래스 적용
		System.out.printf("%s이 공격을 합니다.\n공기~팡! \n\n", this.getName());			// 공격 기술명 출력
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
