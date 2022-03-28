package backjun;

import java.util.Scanner;

public class Day02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for( int i = 0; i<num; i++ ){
			for(int j = 0; j < num; j++) {
				if(j < (num-1)-i) {
					System.out.print(" ");
				}else {
					System.out.print("*");				
				}
			}
			System.out.println("");
		}
		
		System.out.println("-----------------------");
		
		for(int i = 0; i<num; i++) {
			for(int j= i+1; j < num; j++) {
				System.out.print(" ");
				}	
			for(int a = (num-1)-i; a < num; a++) {
				System.out.print("*");
			}
				System.out.println();
		}
		sc.close();
		
		
		
		
		
		
	}
}
