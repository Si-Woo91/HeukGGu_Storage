package study_0501;

import java.util.Scanner;

/*
 * 뱀이 지나간 자리 ---------
 * 
 * 뱀은 모두가 알고있다시피 지그재그로 몸을 비틀며 이동한다. 여기서는 뱀이 지나간 자리를 시각화하여 출력해보자.
 * 
 * 우선 뱀은 N행 M열의 평면에서 움직일 것이다. 뱀은 (1,1) 좌표에서 똬리를 틀고있는 상태이다.
 * 여기서 출발하여 우측 끝까지 갔다가 벽을 만나면 그 아래로 2행만큼 이동한다.
 * 그 후 다시 좌측 끝까지 갔다가 벽을 만나면 마찬가지로 2행만큼 아래로 이동한다.
 * 이렇게 계속 움직이다가 더 이상 아래로 이동할 수 없으면 그 자리에서 멈춘다.
 * 
 * 뱀이 이동할 평면의 크기 N,M이 주어지면 뱀이 이동한 자리를 표시하는 프로그램을 작성하여라.
 * 
 * 입력 <<
 * 평면의 크기를 나타내는 두 정수 N,M을 입력받는다. 
 * 
 * 출력 <<
 * N개의 줄에 걸쳐서 뱀이 지나간 자리를 시각화하여 출력
 * 이때 뱀이 지나간 자리는 '#'으로 , 지나가지 않은 자리는 '.'으로 출력한다.
 *
 */

public class snake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		
		int i = 0;
			
			// 두 라인을 하나의 세트로 묶어주었기 때문에 n/2
			for(i = 0; i < n / 2  ; i++) {
				// #으로만 이루어진 줄
				for(int j = 0; j < m ; j++){
					System.out.print("#");
				}	
				// #으로 한줄 출력 후 count를 증가
				count++;
				System.out.println("");

				// count가 홀수 일 때, 오른쪽 끝에만 # 출력 
				if(count % 2 != 0) {
					for(int j = 0; j < m ; j++) {
						if(j == m - 1) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}
					System.out.println("");
				}	
				
				// count가 짝수 일 때, 왼쪽 끝에만 # 출력
				if(count % 2 == 0) {
					for(int j = 0; j < m ; j++) {
						if(j == 0) {
							System.out.print("#");
						}else {
							System.out.print(".");
						}
					}
					System.out.println("");
				}
			}
			
			// 라인 수가 홀 수 일 때, 제일 마지막 라인은 #으로 한줄 출력 
			if(n % 2 != 0) {
				for(int j = 0; j < m ; j++){
					System.out.print("#");
				}	
					System.out.println();
			}
			sc.close();
	}
}