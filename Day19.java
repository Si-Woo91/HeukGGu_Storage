package backjun;

import java.util.Scanner;

public class Day19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h;			// 현재 시
		int m;			// 현재 분
		int t;			// 타이머
		
		h = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		h += t / 60;				// 몫 만큼 시간을 더해준다
		m += t % 60;				// 나머지를 입력받은 분에 더해준다.
		
		if(m >= 60) {				// 분이 60분 이상일때
			h += 1;					
			m -= 60;
		}
		
		if(h >= 24) {				// 시가 24이상일때
			h -= 24;
		}

		System.out.printf("%d %d", h, m);
		

		sc.close();
	}
}
