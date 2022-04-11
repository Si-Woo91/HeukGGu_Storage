package digimon;											//22_04_04_22_43

public class Enemy {																	// 적 클래스
	private int hp;
	private String name;
	
	public Enemy(int hp, String name) {
		this.hp = hp;
		this.name = name;
	}
	
	public void appear() {
		SoundEffect effect = new SoundEffect();											// 객체 생성 및 사용
				
		System.out.println("Warning! Warning!");
		System.out.printf("적(%s , %d)이 나타났다. \n\n", getName(), getHp());
		try {
			effect.sound();
		} catch(Exception e) {
		}
	}
	
	public int getHp() {																// 적 체력
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getName() {															// 적 이름
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
