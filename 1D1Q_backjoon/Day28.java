package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day28 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());	
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st1.nextToken());				// 입력 받을 정수 개수	
		int x = Integer.parseInt(st1.nextToken());				// 입력받을 x보다 작은 정수의 기준
		int[] num = new int[n];									// 정수를 담아줄 배열
					
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st2.nextToken());			// 배열의 값 입력
		}
		for(int i = 0; i < n; i++) {
			if(num[i] < x) {
				bw.write(num[i]+" ");							// x보다 작은 값 출력
			}
		}
		bw.flush();												// 버퍼 비워주기
		bw.close();
		br.close();
	}
}
