package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day23 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());	// 문자열을 입력 받아 Integer.parseIn를 통해 정수형으로 변환하여 입력받기
		
		for(int i = 0; i < t; i++) {
			// 입력받은 문자열 분리를 위해 매 반복을 위해 StringTokenizer을 생성하면서 동시에 문자열 입력 받는다.
			StringTokenizer st = new StringTokenizer(br.readLine()," ");		
			// StringTokenizer을 통해 분리되어 있는 문자를 받고 다시 Integer.parseInt를 통해 int형으로 변환 후 두 수를 합한다.
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(a + b + "\n"); 
		}
		br.close();			//BufferedReader 닫기
		
		bw.flush();			// 버퍼 비우기
		bw.close();			// BufferedWrite 닫기
	}
}
