package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day53 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 정수 개수
		
		ArrayList<Integer> list = new ArrayList<>();	// 정수를 담아줄 리스트
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	// append를 통해 배열 list에 계속해서 추가
            sb.append(list.get(i) + "\n");
        }
        
        System.out.println(sb.toString());
        
        br.close();
		
		///////////////////////////////////////////////////////
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i< N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < N; i++) {
      	// append를 통해 배열 list에 계속해서 추가
          sb.append(arr[i]).append('\n');
          
      }
      System.out.println(sb.toString());
		
	}
}
