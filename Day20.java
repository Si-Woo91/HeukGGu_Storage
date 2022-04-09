package backjun;

import java.util.Scanner;

public class Day20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;							// 상금
		int max = 0;							// 주사위의 최대값
		
		int a = sc.nextInt();					// 각 주사위
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		
		if(a == b && b == c) {					// 세 주사위의 눈이 동일할 때
			max = a;
			money = 10000+max*1000;
		} else if(a == b || b == c || a == c) {	// 두 주사위의 눈만 동일할 때
			if(a == b) {						// a,b 주사위가 같을때
				max = a;
			} else if(b == c) {					// b,c 주사위가 같을때
				max = b;
			} else if(a == c) {					// c,a 주사위가 같을때
				max = c;
			}
			money = 1000+max*100;				
		} else {								// 주사위의 눈이 모두 다를때
			if(a > b) {							// a 주사위 눈이 제일 클 때 
				if(a > c ) {
					max = a;
				}else {
					max = c;
				}
			}else if(b > c) {					// b 주사위 눈이 제일 클 때
				if(b > a) {
					max = b;
				}
			} else {							// c 주사위 눈이 제일 클 때
				max = c;
			}
			money = max * 100;
		}
		
		System.out.println(money);
		
		sc.close();
	}
}
