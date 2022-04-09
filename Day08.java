package backjun;

import java.util.Scanner;

public class Day08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = 0, B = 0;
		int T = sc.nextInt();	// 케이스 개수

		
		for(int i = 1; i <= T; i++) {
			A = sc.nextInt();							// 정수 A 입력
			B = sc.nextInt();							// 정수 B 입력
			System.out.printf("Case #%d: %d + %d = %d \n", i, A, B, A+B);
		}
		sc.close();
		
		
	}
}
