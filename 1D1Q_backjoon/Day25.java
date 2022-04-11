package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day25{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(st.nextToken());			// 줄 수 입력받기
		
		for(int i = 0; i < n; i++) {
			int num = n - i;
			bw.write(num+"\n");								// n부터 1까지 출력
		}
		bw.flush();											// 버퍼 비우기
		bw.close();											// 닫아주기
		br.close();
	}
}
