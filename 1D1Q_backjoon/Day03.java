package backjun;

import java.util.Scanner;

public class Day03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int min = 1000000;					// 최소값 변수 선언 및 초기화	
			int max = -1000000;					// 최대값 변수 선언 및 초기화
			int n = sc.nextInt();				// 배열의 크기(길이)의 값을 입력 받기
//			int[] arr = new int[n];			// 위에서 입력받은 정수 n에 따라 배열의 길이가 변동하는 배열 선언
			
			for(int i = 0; i < n; i++) {
//				arr[i] = sc.nextInt();		// 배열의 각 인덱스의 요소 입력 받기
				int num = sc.nextInt();		// 정수 입력받기
//				if(max < arr[i]) {
//					max = arr[i];
//				}
				if(max < num) {			// 최대값 구하기
					max = num;
				}
				
//				if(min > arr[i]) {
//					min = arr[i];
//				}
				if(min > num) {			// 최소값 구하기
					min = num;
				}
			}
			System.out.println(min + " " + max);		// 최소값, 최대값 출력하기
			sc.close();		
	}
}

