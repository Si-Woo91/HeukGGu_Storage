package backjun;

import java.util.Scanner;

public class Day09 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();						// N 입력
		
		int temp = n;
		int count = 0;								// 사이클 횟수를 담을 변수
		if(n >= 0 && n <= 99) {						// N의 범위
			while(true) {
			// n / 10; --> 십의 자리수
			// n % 10 --> 일의 자리수
			
			n = ((n%10)*10) + (((n / 10) + (n % 10)) % 10);	
				
			count++;			// 사이클 횟수
			
				if (temp == n) {					// 처음 입력받은 수와 temp에 저장해둔 값이 일치 할시 반복문 탈출
					break;
				}
			}
		}
		System.out.println(count);					// 몇 사이클 돌았는지 출력
		sc.close();
	}
}
