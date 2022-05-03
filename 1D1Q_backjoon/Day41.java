package backjoon;

/*문제
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
크로아티아 알파벳		변경
	č			c=
	ć			c-
	dž			dz=
	đ			d-
	lj			lj
	nj			nj
	š			s=
	ž			z=
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

입력
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

출력
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Day41 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};	// 변경된 크로아티아 알파벳을 배열로 선언
		String str = br.readLine();											// 문자열 입력
		
		for(int i = 0; i < cro.length; i++) {
			// contains를 이용하여 크로아티아 알파벳이 사용되었는지 확인	
			if(str.contains(cro[i])) {							
				//크로아티아 알파벳이 사용되었다면 replace()로 "#"으로 변환시켜준다.
				//변환시키는 이유는 문자열의 길이 값으로 알파벳의 개수를 세어주려고 하는데
				//이때, 크로아티아 알파벳은 2개이상의 문자가 합쳐진 문자로 이를 하나의 문자로 만들어주기 위함이다.
				str = str.replace(cro[i], "#");					
			}													
		}
		bw.write(str.length()+"");								// 길이 값을 출력
		bw.flush();
		bw.close();
		br.close();
	}
}
