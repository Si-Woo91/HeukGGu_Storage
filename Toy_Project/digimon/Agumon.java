package digimon;			//22_04_04_22_43

public class Agumon extends DigimonGame{
	
	Agumon() {																// 생성자
		super(100, 100, "아구몬");											// 기본 체력, 포만감, 이름
	}
	
	@Override
	public void Eat() {				
		System.out.println("\n아구몬이 음식을 먹습니다.\n더줘 태일아~\n");
		this.setHp(5);														// 체력 5증가
		this.setSatiety(10, 100);											// 포만감 10증가, *최대 포만감 100
		super.Eat();
		super.StatusOutput();
	}

	
	@Override
	public void Sleep() {
		System.out.println("\n태일아 졸려~~");
		this.setHp(3);														// 체력 3증가
		this.setSatiety(-5, 100);											// 포만감 5감소, *최대포만감100
		super.Sleep();
		super.StatusOutput();
	}
	
	@Override
	public void Walk() {	
		for(int i = 0; i < 4; i++ ) {										// 걷기 실행시 텍스트 4번 출력(0.6초동안)
			System.out.println("뚜벅");
			try {
				Thread.sleep(600);
			} catch (Exception e) {
			}
		}
		this.setHp(-4);														// 체력 4감소
		this.setSatiety(-7, 100);											// 포만감 7감소, *최대포만감 100
		super.Walk();
		super.StatusOutput();
	}

	public void Attak() {																// 추상클래스 적용
		System.out.printf("%s이 공격을 합니다.\n꼬마~ 불꽃! \n\n", this.getName());				// 공격 기술명 출력
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
