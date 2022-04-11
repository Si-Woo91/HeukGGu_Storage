package backjun;

import java.util.Scanner;

public class Day15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();						// 시
		int M = sc.nextInt();						// 분
		
		// 입력 받은 분이 45분 미만일때
		if(M < 45) {						
			H--;									// 시 감소
			M = 60-(45 - M);						// 분 감소
			if(H < 0) {						
				H = 23;								// 23시로 재할당
			}
			System.out.println(H + " " + M);
		}else {
			System.out.println(H + " " + (M - 45));
		}
		sc.close();
	}
} 
