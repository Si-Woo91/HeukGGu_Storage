package backjoon;

/*대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 
점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day33 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sum;											// 학생들의 점수의 합
		double avg;											// 학생들의 평균
		double count;										// 평균치를 넘는 학생 수
		int T;												// 테스트 케이스 수
		int N;												// 학생 수
		
		T = Integer.parseInt(br.readLine());							// 케이스 개수
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 							// 학생수 입력
			
			double[] score = new double[N];									// 학생들의 점수를 담아줄 배열
			sum = 0;
			avg = 0;
			
			for(int j = 0; j < score.length; j++) {
				score[j] = Double.parseDouble(st.nextToken());
				
				sum += score[j];											// 학생들의 점수 합
			}
			
			avg = sum / N;													// 학생들의 점수 평균
			count=0;
			for(int j= 0; j < score.length; j++) {
				if(score[j] > avg) {
					count++;												// 평균을 넘는 학생 수
				}
			}
			System.out.printf("%.3f%% \n", (count / N) * 100);				// 평균을 넘는 학생의 비율
		}
		br.close();
	}
}
