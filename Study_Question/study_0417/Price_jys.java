package study_0417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 2017년에 이어, 2018년에도 카카오 코드 페스티벌이 개최된다!
 * 
 * 카카오 코드 페스티벌에서 빠질 수 없는 것은 바로 상금이다. 
 * 2017년에 개최된 제1회 코드 페스티벌에서는, 본선 진출자 100명 중 21명에게 아래와 같은 기준으로 상금을 부여하였다.
 * 
 * 2018년에 개최될 제2회 코드 페스티벌에서는 상금의 규모가 확대되어, 본선 진출자 64명 중 31명에게 아래와 같은 기준으로 상금을 부여할 예정이다.
 * 
 * 제이지는 자신이 코드 페스티벌에 출전하여 받을 수 있을 상금이 얼마인지 궁금해졌다. 
 * 그는 자신이 두 번의 코드 페스티벌 본선 대회에서 얻을 수 있을 총 상금이 얼마인지 알아보기 위해, 상상력을 발휘하여 아래와 같은 가정을 하였다.
 * 제1회 코드 페스티벌 본선에 진출하여 a등(1 ≤ a ≤ 100)등을 하였다. 단, 진출하지 못했다면 a = 0으로 둔다.
 * 제2회 코드 페스티벌 본선에 진출하여 b등(1 ≤ b ≤ 64)등을 할 것이다. 단, 진출하지 못했다면 b = 0으로 둔다.
 * 제이지는 이러한 가정에 따라, 자신이 받을 수 있는 총 상금이 얼마인지를 알고 싶어한다.
 * 
 * 첫 번째 줄에 제이지가 상상력을 발휘하여 가정한 횟수 T(1 ≤ T ≤ 1,000)가 주어진다.
 *
 * 입력
 * 다음 T개 줄에는 한 줄에 하나씩 제이지가 해본 가정에 대한 정보가 주어진다. 
 * 각 줄에는 두 개의 음이 아닌 정수 a(0 ≤ a ≤ 100)와 b(0 ≤ b ≤ 64)가 공백 하나를 사이로 두고 주어진다.
 * 
 * 출력
 * 각 가정이 성립할 때 제이지가 받을 상금을 원 단위의 정수로 한 줄에 하나씩 출력한다.
 * 입력이 들어오는 순서대로 출력해야 한다.
 */

public class Price_jys {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine(),"");
		Scanner sc = new Scanner(System.in);

		
		int T = Integer.parseInt(st1.nextToken());
        if(T >= 1 && T <= 1000) {							// T의 조건
            int[][] rank = new int[T][2];					// 2 -> 인덱스 0 = 2017의 순위, 인덱스 1 = 2018의 순위
            int[] reward = new int[T];						// 각 횟수의 상금을 담아줄 배열
            for(int i = 0; i < T; i++) {
                for(int j = 0; j < 2; j++) {
                	rank[i][j]=sc.nextInt();				// 각 회차 순위 입력
                }
            }
            
            for(int i = 0; i < T; i++) {					// 2017년도 상금
                if(rank[i][0] > 0) {
                    if(rank[i][0] == 1) {
                        reward[i] += 5000000;
                    }else if(rank[i][0] <= 3) {
                        reward[i] += 3000000;
                    }else if(rank[i][0] <= 6) {
                        reward[i] += 2000000;
                    }else if(rank[i][0] <= 10) {
                        reward[i] += 500000;
                    }else if(rank[i][0] <= 15) {
                        reward[i] += 300000;
                    }else if(rank[i][0] <= 21) {
                        reward[i] += 100000;
                    }
                }
            }
            
            for(int i = 0; i < T; i++) {					// 2018년도 상금
                if(rank[i][1] > 0) {
                    if(rank[i][1] == 1) {
                        reward[i] += 5120000;
                    }else if(rank[i][1] <= 3) {
                        reward[i] += 2560000;
                    }else if(rank[i][1] <= 7) {
                        reward[i] += 1280000;
                    }else if(rank[i][1] <= 15) {
                        reward[i] += 640000;
                    }else if(rank[i][1] <= 31) {
                        reward[i] += 320000;
                    }
                } 
            }    
            
            for(int i=0; i < T; i++) {
            	bw.write(reward[i]+"\n");
            }
        }
		sc.close();
		bw.flush();			
		bw.close();
		br.close();
	}
}
