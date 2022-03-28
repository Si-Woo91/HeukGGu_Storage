package backjun;

import java.util.Scanner;

public class Day10 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int [9];					// 배열 선언
		int max = 0;								// 최대값을 넣어줄 변수
		int count = 0;								// 최댓값의 위치
		
		for(int i = 0; i < num.length; i++) {		
			num[i] = sc.nextInt();					// 배열의 요소 값 입력
			if(num[i] > max) {						// i번째 값과 max를 비교
				max = num[i];						// 비교하여 최대값 넣어주기
				count = i;							// 인덱스 번호 넣어주기
			}
		}
		System.out.println(max);					// max 출력
		System.out.println(count + 1);				// 위치는 인덱스 + 1 이므로 
		sc.close();
	}
}
