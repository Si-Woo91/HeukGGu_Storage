package Study_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*문제	1357	뒤집힌 덧셈
어떤 수 X가 주어졌을 때, X의 모든 자리수가 역순이 된 수를 얻을 수 있다. Rev(X)를 X의 모든 자리수를 역순으로 만드는 함수라고 하자. 
예를 들어, X=123일 때, Rev(X) = 321이다. 그리고, X=100일 때, Rev(X) = 1이다.

두 양의 정수 X와 Y가 주어졌을 때, Rev(Rev(X) + Rev(Y))를 구하는 프로그램을 작성하시오

입력
첫째 줄에 수 X와 Y가 주어진다. X와 Y는 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제의 정답을 출력한다.*/

public class Study_0516 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		sum = Integer.parseInt(Rev(X))+Integer.parseInt(Rev(Y));	// 각각 뒤집어서 더해준다.
		System.out.println(Integer.parseInt(Rev(sum)));				// 더해준 값을 뒤집어 준다.
	}
	
	// 역순으로 만들어주는 메소드
	public static String Rev(int x) {
		StringBuilder sb = new StringBuilder();	
		String a;
		// x가 0보다 크면 x를 10으로 나눴을때의 나머지를 받아온다.
		while(x > 0) {			
			a = (x % 10) + "";				// 일의 자리수 부터 차례로 받아서 저장
			x = x / 10;						// 일의 자리수를 제외하기 위해
			sb.append(a); 					// 받은 숫자를 차례로 이어준다.
		}
		return sb.toString();
	}
}
