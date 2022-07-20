package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*1978번 소수 찾기 

문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.*/

public class Day56 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;				// 주어진 수들의 소수의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/* hasMoreTokens()
		- StringTokenizer 클래스 객체에서 다음에 읽어 들일 token이 있으면 true, 없으면 false를 return한다.*/
		while(st.hasMoreTokens()) {
			
			boolean sosu = true;
			int num = Integer.parseInt(st.nextToken());
			
			// 1은 소수가 아니다.
			if(num == 1) {
				continue;
			}
			
			/*Math.sqrt() : 숫자의 제곱근을 반환합니다.
			 *				주어진 숫자에 루트를 씌운다. 
			 */
			for(int i = 2; i <= Math.sqrt(num); i++) {							// 예시1) num == 3 일경우 루트3은 1.73 이므로 성립 x 
				if(num % i == 0) {												// 예시2) num == 4 일경우 루트4 == 2 
					sosu = false;												// 		4 % 2 == 0 이므로 1 2 4를 갖으므로 소수가 아니다
					break;
				}
			}
			
			if(sosu) {			// sosu가 true이면 소수이므로 개수 증가 
				count++;
			}
		}			// while 끝
		
		System.out.println(count);
		
		br.close();
	}
}
