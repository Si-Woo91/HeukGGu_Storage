package study_0417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * [그림]과 같이 4개의 슈트(모양: S, D, H, C)와 13개의 랭크(값 : A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K)로 
 * 구성된 52장의 카드가 있다. 
 * S = 스페이드  D = 다이아  H = 하트  C = 클로버
 * 첨부된 [그림] 참조
 * 52장의 카드에서 임의의 5장의 카드를 주었을 때 카드 핸드(선택된 5장의 카드)의 종류가 9종류가 있다. 아래는 9종류의 카드 핸드를 설명한다. 
 *
 * 1. Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다/
 * (여기서는 로얄 플러쉬를 포함한다. 로얄 플러쉬는 모두 동일한 슈트에 T, J, Q, K, A를 갖는다).
 * 2. Four of a Kind : 5장 중 4개의 랭크(값)가 모두 같다./
 * 3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
 * 4. Flush : 5장이 모두 동일한 슈트다./
 * 5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다./
 * 6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3)./
 * 7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3)./
 * 8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7)./
 * 9. High card : 1~8번에 해당하지 않는다.  
 * 
 * 예시) 입력 - S5 S6 S7 S8 S9 출력 - Straight Flush다. 
 * 
 * <입력방법 >
 * 첫 줄에는 테스트 케이스가 개수다.(생략가능)
 * 두 번째 줄부터는 5개의 카드가 공백과 함께 주어진다. 
 * 
 * 
 * 출처 - https://swexpertacademy.com/main/main.do
 * 		SW ExpertAcademy 9760. Poker Game
 * 
 */
public class Problem_ksw {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");		// 입력 및 " " 기준으로 쪼개기
		
		String[] card = new String[5];	// 손에 들고 있는 패
		char[] suit = { 'S', 'D', 'H', 'C' };
		char[] rank = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
		int kinds = 9;  // 패의 종류
		
		for(int i = 0; i < 1; i++) {
			int[] s_temp = new int[4];						// 문양, 숫자 초기화 용도
			int[] r_temp = new int[14];
		
			for(int j = 0; j < 5; j++) {
				card[j] = st2.nextToken();					// 카드 입력 받기
			}
			
			for(int j = 0; j < 5; j++) {					
				for(int y = 0; y < suit.length; y++) {		// 문양 담기
					if(suit[y] == card[j].charAt(0)) {		
						s_temp[y]++;
					}
				}
				for(int k = 0; k < rank.length; k++ ) {		// 숫자 담기
					if(rank[k] == card[j].charAt(1)) {
						r_temp[k]++;
					}
				}
			}
//--------------------------------------------------------------------------------------			
			
			
			
			//Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
			 for (int j = 1; j < r_temp.length-4; j++) {			// 범위 내에서 5개가 연속일 경우	 
	                if (r_temp[j] == r_temp[j + 1] && r_temp[j] == r_temp[j + 2] && r_temp[j] == r_temp[j + 3] &&
	                		r_temp[j] == r_temp[j + 4] && r_temp[j] == 1) {
	                	kinds = 5;
	                }
	            }
			int temp_k1 = kinds;									// Straight의 값을 저장
			 
			//Flush : 5장이 모두 동일한 슈트다.
			for(int j = 0; j < s_temp.length; j++ ) {
				if(s_temp[j] == 5) {
					kinds = 4;
				}
			}
			int temp_k2 = kinds;									// Flush의 값을 저장
			
			//Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다
			if(temp_k2 == 4 && temp_k1 == 5) {
				kinds = 1;
			}
			
			
			// One pair, Two pair, Three of a kind, Four of a Kind ,Full House
			int temp = 0;											// 원페어인지 투페어인지 구분하기 위해 
			int temp_o = 0;
			int temp_t= 0;
			for(int j = 0; j < r_temp.length; j++) {				// 같은 수가 몇개가 있는지
				if(r_temp[j] == 2) {
					temp++;
					if(temp == 2) {									// temp가 2이면 투페어, 1이면 원페어
						kinds = 7;
					}else if(temp == 1) {
						kinds = 8;
						temp_o = kinds;
					}
				}else if(r_temp[j] == 3) {
					kinds = 6;
					temp_t = kinds;
				}else if(r_temp[j] == 4) {
					kinds = 2;
				}
			}
			
			//Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
			if(temp_o == 8 && temp_t == 6 ) {			
				kinds = 3;
			}
			
		}
		
		
//		 * 1. Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다/
//		 * (여기서는 로얄 플러쉬를 포함한다. 로얄 플러쉬는 모두 동일한 슈트에 T, J, Q, K, A를 갖는다).
//		 * 2. Four of a Kind : 5장 중 4개의 랭크(값)가 모두 같다./
//		 * 3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
//		 * 4. Flush : 5장이 모두 동일한 슈트다./
//		 * 5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다./
//		 * 6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3)./
//		 * 7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3)./
//		 * 8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7)./
//		 * 9. High card : 1~8번에 해당하지 않는다.  
		
		
	switch(kinds) {				// 족보 출력
	case 1:
		System.out.println("Straight Flush");
		break;
	case 2:
		System.out.println("Four of a Kind");
		break;
	case 3:
		System.out.println("Full House");
		break;
	case 4:
		System.out.println("Flush");
		break;
	case 5:
		System.out.println("Straight");
		break;
	case 6:
		System.out.println("Three of a kind");
		break;
	case 7:
		System.out.println("Two pair");
		break;
	case 8:
		System.out.println("One pair");
		break;
	default:
		System.out.println("High card");
	}
	br.close();
	
	}
}	