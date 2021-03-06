package study_0515;

import java.util.Scanner;

/*계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. 
 * <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.

<그림 1>

예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.

<그림 2>

계단 오르는 데는 다음과 같은 규칙이 있다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나,
첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

입력
입력의 첫째 줄에 계단의 개수가 주어진다.

둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고,
 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

출력
첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.*/

public class Study_2579 {
	public static void main(String[] args) {
		
		// DP(동적계획법)
		/*Bottom-Up 방법	-	문제를 크기가 작은 문제부터 차례대로 쓴다.
							문제의 크기를 조금씩 크게 만들면서 문제를 푼다.
							작은 문제를 풀면서 큰 문제의 답을 구한다.
		풀이 참고 - https://st-lab.tistory.com/132
		*/
		
		Scanner sc = new Scanner(System.in);
		 
		int N = sc.nextInt();
 
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
 
 
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
        
		/*
		반복문 DP배열은 int[] 배열로 쓸 것이기 때문에
		index 0은 초기화해줄 필요 없다.
		*/
		// index = 0 은 시작점이므로 0이다.		
		DP[1] = arr[1];
        
		// N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
 
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2] , DP[i - 3] + arr[i - 1]) + arr[i];
		}
 
		System.out.println(DP[N]);
		
		sc.close();
	}
}
