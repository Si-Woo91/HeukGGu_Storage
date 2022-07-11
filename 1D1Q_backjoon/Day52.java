package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 10872번

팩토리얼

문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

출력
첫째 줄에 N!을 출력한다.*/

public class Day52 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		result = factorial(N);
		
		System.out.println(result);
		
		br.close();
	}
	
	// 재귀함수 활용
	public static int factorial(int N) {
		if(N<=1) {					// 0과 1일때는 1이므로
			return 1;
		} else {
			return N * factorial(N-1);
		}
	}
	
}
