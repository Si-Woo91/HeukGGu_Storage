package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*문제	1157번 단어공부
어제, 지민이는 몰래 리조트에 갔다가 입구에 걸려있는 복권 광고를 하나 보았다.

“1부터 N까지의 수 중에 서로 다른 M개의 수를 골라보세요. 저희도 1부터 N까지의 수 중에 서로 다른 M개의 수를 고를건데, 
적어도 K개의 수가 같으면 당첨입니다.!”

지민이는 돌아오면서 자신이 복권에 당첨될 확률이 궁금해졌다.

지민이가 복권에 당첨될 확률을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 N, M, K가 주어진다.

출력
첫째 줄에 지민이가 복권에 당첨될 확률을 출력한다. 절대/상대 오차는 10-9까지 허용한다.*/

public class Day37 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    String str = st.nextToken();
	        
	    int num;					
	    int[] count = new int[26];	// 대문자의 개수에 따라 인덱스에 저장. 0인덱스는 A에 해당

	    for (int i = 0; i < str.length(); i++) {
	       	if(str.charAt(i)>= 'A' && str.charAt(i) <= 'Z') {
	       		// 'A' 의 아스키 코드값 65를 빼준다.
	       		num = (int)str.charAt(i) - 65 ;
	       		count[num]++;
	       		
	       		// 소문자를 대문자로 변경
	       	} else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
	       		// 32는 아스키코드에 의해 소문자와 대문자의 차이 값
	       		num = (int)str.charAt(i) - 32 - 65;
	       		count[num]++;
	       	}
	    }
	        
	    int max = 0;			// 알파벳의 최대 개수
	    char result = ' ';		// 결과 값 출력
	    for (int i = 0; i < count.length; i++) {
	    	if(max < count[i]){
	    		max = count[i];
	            result = (char)(i+'A');
	        } else if (max == count[i]){
	        	result = '?';
	        }
	    }
	    bw.write(String.valueOf(result));			// char형을 String형으로 변환 후 출력
	        
	    bw.flush();
	    bw.close();
	    br.close();
	        
	}
}
