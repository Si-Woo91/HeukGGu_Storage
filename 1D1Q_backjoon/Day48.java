package backjoon;

import java.math.BigInteger;
import java.util.Scanner;

/*문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

출력
첫째 줄에 A+B를 출력한다.*/

public class Day48 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
/*		BigInteger를 사용해야 하는 이유
 
		int는 메모리 크기는 4byte로 표현할 수 있는 범위는 -2,147,483,648 ~ 2,147,483,647이고 long은 메모리 크기는 8byte로 표현할 수 있는 범위는
		-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807입니다. 
		그 범위를 넘어서게 되면 모두 0으로 출력이 됩니다. 숫자의 범위가 저 범위를 넘을 경우는 잘 없겠지만 프로그램 개발 특히 돈과 관련된 개발이나
		알고리즘 문제를 풀 때 항상 최악의 상황을 고려해야 하므로 무한의 정수가 들어갈 수 있는 가능성이 있다면 BigInteger이라는 클래스를 활용하는 것이 좋습니다. 
		BigInteger은 문자열 형태로 이루어져 있어 숫자의 범위가 무한하기에 어떠한 숫자이든지 담을 수 있습니다.
		
		BigInteger은 문자열이기에 사칙연산이 안됩니다.
		 그렇기에 BigIntger 내부의 숫자를 계산하기 위해서는 BigIntger 클래스 내부에 있는 메서드를 사용해야 합니다.
		*/
		
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		System.out.println(A.add(B));				// add를 사용해서 두 수를 더해준다.
		
		sc.close();
	}
}
