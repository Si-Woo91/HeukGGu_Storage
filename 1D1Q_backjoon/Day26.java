package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day26 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());						// 케이스 개수
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());				// 두 정수 받아주기
			int num2 = Integer.parseInt(st.nextToken());
			int sum = num1+num2;
			bw.write("Case #" + i+1 +":" + sum + "\n");					// 출력문 예시처럼 출력
//			System.out.println("Case #" + i+1 +":" + sum);
		}

		
		System.out.println("------------------------------");
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			System.out.println("Case #" + i + ": " 
			+(Integer.parseInt(st.nextToken())
			+Integer.parseInt(st.nextToken())));
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
