package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day27 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(st.nextToken());			// 줄 수 입력 받기
		for(int i = 1; i <= t; i++) {
			for(int j = 0; j < i; j++) {
				bw.write("*");;								// 별 출력
			}
				bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
