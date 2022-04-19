package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다.
 *  예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
 *  수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 
 *  그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 */

public class Day31 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] num = new int[10];			// 10개의 정수를 입력하여 담아줄 변수
		int temp;							// 42로 나눴을때 나머지가 같을 경우 +1 해줄 변수
		int count = 0;						// 나머지가 다른 경우의 수를 담아줄 변수
		for(int i = 0; i < 10; i++) {
			num[i]= Integer.parseInt(br.readLine()) % 42;
		}
		
		
		for(int i = 0; i < 10; i++) {
			temp = 0;
			for(int j = i+1; j < 10; j++) {
				if(num[i] == num[j]) {
					temp ++;	// num에 담겨진 값들을 비교하여 동일한것이 있을시 +1하여 중복으로 세는 것을 방지
				}
			}
			if(temp == 0) {
				count ++;		// num의 값 중 서로 다른 값이 있다면 +1하여 서로 다른 수가 몇 개있는지
			}
		}
		bw.write(count+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
