package backjun;

import java.util.Scanner;

public class Day16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();				// x 좌표
		int y = sc.nextInt();				// y 좌표
		
		
		if(x > 0 && y > 0) {				// x,y 가  양수, 양수이면 1			
			System.out.println("1");
		}else if(x < 0 && y > 0) {			// x,y 가  음수, 양수이면 2	
			System.out.println("2");
		}else if(x < 0 && y < 0) {			// x,y 가  음수, 음수이면 3	
			System.out.println("3");
		}else if(x > 0 && y < 0) {			// x,y 가  양수, 음수이면 4	
			System.out.println("4");
		}
	///////////////////////////////////////////////////////////////////////////////////////	
		if(x > 0) {							// x가 양수일 경우 
			if(y > 0) {						// y가 양수일 경우 1출력
				System.out.println("1");
			}else if(y<0) {					// y가 음수일 경우 4출력
				System.out.println("4");	
			}
		}else if(x < 0) {					// x가 음수일 경우
			if(y > 0) {						// y가 양수일 경우 2 출력
				System.out.println("2");
			}else if(y<0) {					// y가 음수일 경우 3 출력
				System.out.println("3");
			}
		}
		
		sc.close();
	}
}
