package study_0424;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.Scanner;
//import java.util.StringTokenizer;

/*	네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 
	그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
	다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

	1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 “공백”(“ “) 또는 “벽”(“#”) 두 종류로 이루어져 있다.
	2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 “지도 1”과 “지도 2”라고 하자. 
		지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
		지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
	3. “지도 1”과 “지도 2”는 각각 정수 배열로 암호화되어 있다.
	4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다
	네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
*/

/*
* 입력 형식
* 입력으로 지도의 한 변 크기 n 과
* 
*  2개의 정수 배열 arr1, arr2가 들어온다.
*	1 ≦ n ≦ 16
*	arr1, arr2는 길이 n인 정수 배열로 주어진다.
*	정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2^n - 1을 만족한다.
*/

/*
* 출력 형식
* 원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.
*/
public class SecretMap {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.print("정수 입력 >> ");
		int n = sc.nextInt();
//		int n = Integer.parseInt(br.readLine());
		String[] answer = new String[n];
		int[] arr1 = new int [n];
		int[] arr2 = new int [n];
		
		for(int i = 0; i < n; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine()," ");
//			arr1[i] = Integer.parseInt(st.nextToken());
//			arr2[i] = Integer.parseInt(st.nextToken());
//			arr1[i] = sc.nextInt();
			System.out.print("arr1 "+ (i+1) +"번째 입력 >> ");
			arr1[i] = sc.nextInt();
			
			System.out.print("arr2 "+ (i+1) +"번째 입력 >> ");
			arr2[i] = sc.nextInt();
			
			// 10진수 -> 2진수 변환
			String binary_num1 = Integer.toBinaryString(arr1[i]);
			String binary_num2 = Integer.toBinaryString(arr2[i]);
//			System.out.println(binary_num1);
//			System.out.println(binary_num2);
//			System.out.println(binary_number1.length());
//			System.out.println(binary_number2.length());
			int len1 = binary_num1.length();
			int len2 = binary_num2.length();
			
			String result = "";
			
			/*
			 * 2진수로 변환했을때, 앞에 0을 붙여야 하는 경우
			 * arr1[i] = 9 -> 01001 이 되어야 하는데
			 * 이 경우 1001로 출력되어서 길이 값이 4
			 * 따라서 (n - len1) 만큼 "0"을 추가 
			 */
			if(binary_num1.length() < n) {
				for(int j = 0; j < n - len1; j++) {
					binary_num1 = "0" + binary_num1;
				}
			}

			if(binary_num2.length() < n) {
				for(int j = 0; j < n - len2; j++) {
					binary_num2 = "0" + binary_num2;
				}
			}
		
			for(int j = 0; j < binary_num1.length(); j++ ) {
				if(binary_num1.charAt(j) == '1' || binary_num2.charAt(j) == '1') {
					result += "#";
				}else {
					result += " ";
				}
				
			}
			answer[i] = result;
		}
		for(int i = 0; i < n; i++) {
			System.out.print("결과 >> ");
			System.out.println(answer[i]); 
		}
		sc.close();
		
//		int[] arr1 = new int [n];
//		int[] arr2 = new int [n];
//		
//		for(int i = 0; i < n; i++) {
//			arr1[i] = sc.nextInt();				// 배열 값 입력 받기
//		}
//		
//		for(int i = 0; i < n; i++) {
//			arr2[i] = sc.nextInt();				// 배열 값 입력 받기
//		}
//		
//		
		
//		String b = "";
//		String[][] a = {};
//		int num = 14;
//		for(int i = 0; i < n; i++) {
//			while(arr1[i] > 0) {
//				b = arr1[i] % 2 + b;
//				arr1[i] /= 2;
//				for(int j = 0; j < i+1; j++) {
//					a[i][j] = b;
//					System.out.println(a[i][j]);
//				}
//			}
//		}
		
//		 String[][] b = {};
////		 int number = 123;
//		 for(int i = 0; i < arr1.length; i++) {
//			 for(int j = 0; j < arr1.length; j++) {
//				 String bi ="";
//				 while(arr1[i]>0) {
//					 bi = arr1[i] % 2 + bi;
//					 arr1[i] /=2;
//				 }
//				 b[i][j] = bi;
//				 System.out.println(b[i][j]);
//			 }
//			 b[i] = bi;
//			 System.out.println(b[i]);
		
//		for(int i = 0; i < n; i++) {
//
//		}

	}
}
