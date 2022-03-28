package backjun;

import java.util.Scanner;

public class Day12 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();				// 연도를 입력받을 변수
//		
//		// 연도가 4의 배수이고 연도가 400의 배수이면 == 1
//		// 연도가 4의 배수가 아니면 == 0
//		// 연도가 4의 배수이고 연도가 400의 배수가 아니고 100의 배수도 아니라면 == 1
//		// 연도가 4의 배수이고 연도가 400의 배수가 아니고 100의 배수라면  == 0
//		int y = (year % 4 == 0)? ((year % 400 == 0)? 1 : (year % 100 != 0)? 1 : 0) : 0 ;
//		
//		System.out.println(y);		// 삼항연산자를 담은 변수 y를 출력

		
		if(year % 4 == 0) {						// 연도가 4의 배수 일때
			if(year % 400 == 0) {				// 연도가 4의 배수이고 400의 배수일때
				System.out.println(1);
			}else if(year % 100 != 0) {			// 연도가 4의 배수이고 100의 배수가 아닐때
				System.out.println(1);
			}else {
				System.out.println(0);			// 400의 배수가 아니고 100의 배수일때
			}
		}else {
			System.out.println(0);				// 4의 배수가 아닐때
		}
		sc.close();
	}
}
