package backjoon;

/*문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
 aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다.
 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

출력
첫째 줄에 그룹 단어의 개수를 출력한다.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day42 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0; 										// 그룹 단어 개수 담을 변수
		
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			boolean check[] = new boolean[26];				// 알파벳이 사용된 내역
			boolean temp = true; 							// 그룹 단어 인지 체크
			
			for (int j = 0; j < S.length(); j++) {
				// 아스키 코드값으로 저장
				int index = S.charAt(j)-'a';
				if(check[index] == true) { 					// 이전에 사용한적이 있는 문자인지
					if(S.charAt(j) != S.charAt(j-1)) { 		// 이전 문자와 연속되지 않는다면
						temp = false;						// 그룹 단어가 아니라면 반복문 탈출
						break;								
					}
				}else { 									// 이전에 사용한적이 없는 문자인지
					check[index] = true; 					// 문자 사용 체크
				}
			}
			if(temp == true) {
				cnt++;										// 그룹 단어 개수 증가								
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
