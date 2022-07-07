package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*2751번 수 정렬하기2
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.*/

public class Day51 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 정수 개수
		
        ArrayList<Integer> list = new ArrayList<>();	// 정수를 담아줄 리스트
 
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));	// 반복문을 통해 리스트에 정수 담아주기
        }
        
        Collections.sort(list);	// collections.sort를 사용하여 오름차순으로 정렬
 
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	// append를 통해 배열 list에 계속해서 추가
            sb.append(list.get(i) + "\n");
        }
        
        System.out.println(sb.toString());
        
        br.close();
	}
}
