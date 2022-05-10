package study_0510;

import java.util.Scanner;

/*문제	1789번 수들의 합
서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?

입력
첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.

출력
첫째 줄에 자연수 N의 최댓값을 출력한다.*/

// * N이 최댓값이 되려면 1부터 시작

public class Study {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;		// 자연수들의 합
		int count = 0;		// 서로 다른 자연수의 개수
		
		long S = sc.nextLong();
	
		int i = 1;			// 제일 작은 자연수 1부터 시작하기 위한 변수
		while(true) {
			sum += i;
			
			if(sum > S) {	// 자연수들의 합이 입력 받은 S보다 클시 while문 탈출
				break;
			}
			count++;
			i++;			
		}
		
//		for(int i = 1; i < S; i++) {
//			
//			if(sum > S) {			// 1부터의 합이 S보다 큰 시점이 되면
//				count--;			// 더해준 정수 개수를 하나 마이너스 해준다
//				break;
//			}
//			sum += i;				// 1부터 합
//			count++;
//		}
		
		System.out.println(count);
		
		sc.close();
	}
}
