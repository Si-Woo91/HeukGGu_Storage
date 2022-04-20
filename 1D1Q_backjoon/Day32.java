package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 8958번
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 
 * 예를 들어, 10번 문제의 점수는 3이 된다.
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 */

public class Day32 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());		// 케이스 갯수
		
		String[] str = new String[T];					
		
		for(int i = 0; i < T; i++) {					// 케이스 개수만큼 입력 받기
			str[i] = br.readLine();
		}
		
		for(int i = 0; i < T; i++) {
			int sum = 0;								// 합 초기화
			int cnt = 0;								// 'O' 개수에 따라 값 증가
			
			for(int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) == 'O') {			// 각 인덱스에 담겨있는 값을 문자로 쪼개서 비교
					cnt++;
					sum += cnt;
				}else {
					cnt = 0;
				}
			}
			bw.write(sum+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
