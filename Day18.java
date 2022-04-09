package backjun;

import java.util.Scanner;

public class Day18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int min = 101;
		double max = -1;									// 최대 점수를 담아줄 변수
		double avg = 0;										// 평균을 담아줄 변수
		double sum = 0;										// 조작 점수의 합
		int n = sc.nextInt();								// 과목 수
				
		double[] score = new double[n];						// 본점수
		double[] lie_score = new double[n];					// 조작점수
		
		for(int i = 0; i < score.length; i++) {				// 본 점수 입력 받기
			score[i] = sc.nextInt();
			
			if(score[i] > max) {							// 본점수 중 최대 점수 찾기
				max = score[i];
			}
			
//			if(score[i] < min) {
//				min = score[i];
//			}
//			System.out.println(score[i]);
		}
//		System.out.println(max);
//		System.out.println("---------");
		for(int i = 0; i < lie_score.length; i++) {			// 조작 점수 받기
//			System.out.println(score[i]);
			lie_score[i] = (score[i]/max)*100;
//			System.out.println(aa[i]);
			sum += lie_score[i];							
		}
//		System.out.println(sum);
//		System.out.println(min);
//		System.out.println(max);
		
//		avg = score[i]/max*100;
		
		
		avg = sum/ lie_score.length; 						// 조작 점수 평균
		System.out.printf("%f",avg);
		
		
		
		sc.close();
	}
}
