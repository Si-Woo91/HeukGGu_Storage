package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Scanner;

public class Day22 {
	public static void main(String[] args) throws IOException {						// throws를 통해 예외를 던져준다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int n = Integer.parseInt(br.readLine());									// BufferedReader를 통해서 입력
		for(int i = 1; i < n+1; i++) {												// for문을 통해 1부터 n번째까지 더해줌.
			sum += i;
		}
		bw.write(sum + "\n" );														// 더한 값을 출력
														
		br.close();
		bw.flush();
		bw.close();
		
		
//		Scanner sc = new Scanner(System.in);
//		int sum = 0;
//		int n = sc.nextInt();
//		
//		for(int i = 1; i < n+1; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		sc.close();

	}
}
