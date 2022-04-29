package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day39 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
//		int num1 = Integer.parseInt(br.readLine());
//		int num2 = Integer.parseInt(br.readLine());
//		
//		// 입력 받은 정수들을 뒤집어주는 연산
//		int a = (num1 % 10)*100 + (((num1 % 100) / 10) *10) + (num1 / 100);	
//		int b = (num2 % 10)*100 + (((num2 % 100) / 10) *10) + (num2 / 100);
		
		///////////////////////////////////////////////////////////////////
        /*
         * StringBuilder : String객체와 String 객체를 더해준다.
         * reverse() : 문자열을 뒤집어 준다.
         */
		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		bw.write((a > b ? a : b) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
