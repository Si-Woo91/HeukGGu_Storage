package backjun;

import java.util.Scanner;

public class Day07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();				// score 변수에 점수 입력받기
		
		if(score >= 90 && score <= 100) {		//	점수가 90 ~ 100점일 경우 A 출력
			System.out.println("A");
		}else if(score >= 80 && score <= 89) {	//	점수가 80 ~ 89점일 경우 B 출력
			System.out.println("B");
		}else if(score >= 70 && score <= 79) {	//	점수가 70 ~ 79점일 경우 C 출력
			System.out.println("C");
		}else if(score >= 60 && score <= 69) {	//	점수가 60 ~ 49점일 경우 D 출력
			System.out.println("D");
		}else {									//	나머지 점수일 경우 F 출력
			System.out.println("F");
		}
		
		sc.close();
		
		
		
		
	}
}
