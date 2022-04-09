package backjun;

import java.util.Scanner;

public class Day11 {
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		char ch = sc.nextLine().charAt(0);				// 문자를 입력 받는다.
		
		int num = (int)ch;								// char형을 int형으로 강제 형변환 
		
		System.out.println(num);						// 형변환한 값을 출력
		
		sc.close();
	}
}
