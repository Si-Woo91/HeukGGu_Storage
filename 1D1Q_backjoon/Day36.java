package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*문제 2675 문자열 반복
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 
두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 
문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 

출력
각 테스트 케이스에 대해 P를 출력한다.*/

public class Day36 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); 	// 케이스 개수
		String[] str;								// 반복횟수 와 문자 받아줄 변수
		int R;										// 반복횟수
		String S;									// 문자
		
		for(int i = 0; i < T; i++) {
			str = br.readLine().split(" ");			// 반복횟수와 문자를 같이 받아서 " " 기준으로 나눠준다
			R = Integer.parseInt(str[0]);			// 반복횟수
			S = str[1];								// 문자
			
				for(int j = 0; j < S.length(); j++) {
					for(int x = 0; x < R ; x++) {
						bw.write(S.charAt(j)+"");	// S의 값들을 반복하여 출력
					}
				}
				
				bw.write("\n");
				bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
