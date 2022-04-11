package backjun;

//import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Day21 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());						// 입력받을 갯수 
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	// 문자의 공백을 쪼개주는 역할
			int a = Integer.parseInt(st.nextToken());					// a 정수 입력
			int b = Integer.parseInt(st.nextToken());					// b 정수 입력
			System.out.println(a+b);
		}
		br.close();
		
//		Scanner sc = new Scanner(System.in);
//		int sum = 0;
//		int t = sc.nextInt();
//		
//		for(int i = 0; i < t; i++) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			sum = a+b;
//			System.out.println(sum);
//		}
	}
}
