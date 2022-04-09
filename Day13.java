package backjun;

import java.util.Scanner;

public class Day13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;					// 입력받은 정수의 합을 담아줄 변수
		int count = sc.nextInt();		// 정수의 개수를 입력 받을 변수
		String str = sc.next();			// 입력해줄 숫자를 담을 변수
		
		for(int i = 0; i < count; i++) {
			sum += str.charAt(i)-'0';	// 아스키코드값으로 반환 -0은 입력받은 숫자 값을 그대로 사용하기 위해.
		}
		System.out.println(sum);		// 정수의 합을 출력
		sc.close();
	}
}
