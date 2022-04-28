package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*문제
영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 
단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

입력
첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 
단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.

출력
첫째 줄에 단어의 개수를 출력한다.*/

public class Day38_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		
		String str = br.readLine();            // 입력
		String[] str_arr = str.split(" ");     // 입력 받은 문장을 공백을 기준으로 나눠준다.
		for(int i = 0; i < str_arr.length; i++) {
			if(str_arr[i] != null) {
				count++;                        // 배열 안에 단어가 있을 시 count를 증가 시킨다.
			}else {
				return;
			}
		}
		bw.write(count+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
