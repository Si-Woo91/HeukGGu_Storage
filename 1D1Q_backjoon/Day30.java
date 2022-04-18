package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day30 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());		// 정수 입력
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
	
		String mul = String.valueOf(A * B * C);			// 입력 받은 정수의 곱 
		int[] arr = new int[10];						// 0~9까지의 정수의 개수를 담아줄 배열
		
		for(int i = 0; i < mul.length(); i++) {
			arr[(mul.charAt(i) - '0')]++;				// 아스키코드 값에 의해 -'0' 이나 -48을 해주어야 한다. 
		}
		
		for(int j = 0; j < arr.length; j++) {
			bw.write(arr[j]+"\n");						// 0~9까지의 정수의 개수 출력
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
