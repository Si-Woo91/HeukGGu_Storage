package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
2750번 수 정렬하기

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/

public class Day54 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		List<Integer> list = new ArrayList<>();
//		
//		// 리스트 풀이법
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		for(int i = 0; i < N; i++) {
//			list.add(Integer.parseInt(br.readLine()));
//		}
//		
//		Collections.sort(list);
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i = 0; i < N; i++) {
//			sb.append(list.get(i) + "\n");
//		}
//		
//		System.out.println(sb.toString());
//		
//		br.close();
		
		////////////////////////////////////////////////////////////////////////
		
		// 배열 풀이법
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
