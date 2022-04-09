package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day24 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());				// 정수 n 입력 받기
		
		for(int i = 1; i <= n; i++) {							// 입력 받은 n까지 한 줄에 하나씩 출력
			bw.write(i+"\n");
		}	
		br.close();
		bw.flush();
		bw.close();
	}
}
