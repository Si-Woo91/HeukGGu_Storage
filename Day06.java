package backjun;

import java.util.Scanner;

public class Day06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(hansu(sc.nextInt()));
		sc.close();
	}
	public static int hansu(int n) {
		int c = 0;
		
		if(n < 100) {
			return n;
		}else {
			c = 99;
			if(n == 1000) {
				n = 999;
				}
				
			for(int i = 100; i <= n; i++) {
				int hund = i / 100;
				int ten = (i / 10) % 10;
				int one = (i % 100) % 10;
				
				if((hund - ten) == (ten - one)) {
					c++;
				}
				
			}
		}
		return c;
	}
}
