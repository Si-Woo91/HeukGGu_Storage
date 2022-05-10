package backjoon;

import java.util.Scanner;

/*문제	2839 설탕 배달
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 
설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 
5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

출력
상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.*/

public class Day45 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 설탕무게
		
		int cnt = 0;				// 봉지의 개수
		
		while(true) {
			if(N % 5 == 0) {		// 5로 나눴을때 나머지가 0이라면 
				cnt += N / 5;		// 봉지의 개수(몫) 출력
				System.out.println(cnt);
				break;
			}else {					// 아니라면 3씩 빼준다.
				N -= 3;
				cnt++;
			}
			
			if(N < 0) {				// 정확하게 만들수 없다면 -1
				System.out.println("-1");
				break;
			}
		}
		sc.close();
	}
}
