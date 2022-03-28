package backjun;

import java.util.Scanner;

public class Day14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();					// 낮에 올라가는 높이
		int b = sc.nextInt();					// 밤에 미끄러지는 높이
		int lenght = sc.nextInt(); 				// 나무막대 높이
		
		int day = 0;

		day = (lenght-b) / (a-b);					// 몫이 일수
		
		if((lenght-b) % (a-b) != 0) {				// 나머지가 남으면 1일 추가
			day++;
		}
			
		System.out.println(day);
		sc.close();
		
	}
}
