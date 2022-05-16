package study_0515;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
(6은 9를 뒤한 세트에는 0번부터 9번까지 숫자가 하집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.*/

public class Study_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		str = str.replace('9', '6');			// 9를 6으로 변환
		
		int[] arr = new int[9];					// 0 1 2 3 4 5 6 7 8 의 개수를 세어줄 배열(9는 6이랑 같기때문에 하나로 인식)
		
		int set = 0;							// 필요한 세트 개수
		
		// 입력 받은 숫자를 하나씩 쪼개어 배열의 각 인덱스의 값을 넣어주면서 플러스
		for(int i = 0; i<str.length(); i++) {
			int num = (int)(str.charAt(i)-48);	// 48 = 아스키코드표의 '0' 에 해당하는 숫자
			arr[num]++;	
		}
		
		// 6은 9를 포함하고 있기 때문에 나누기 2
		if(arr[6] != 0) {
			arr[6] = Math.round(arr[6] / 2.0f); 	// 나누고 반올림 해주기 
		}
		
		// 배열의 인덱스와 set를 비교하여 큰 수를 set에 담아준다.
		for(int i = 0; i < arr.length; i++) {
			set = Math.max(arr[i], set);
		}
		
		bw.write(set+"");	// 필요한 세트 수 출력
		
		bw.flush();
		bw.close();
		br.close();
	}
}
