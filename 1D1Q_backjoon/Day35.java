package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*문제 10809번 알파벳 찾기
알파벳 소문자로만 이루어진 단어 S가 주어진다. 
각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 
포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.

만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 
단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.*/
public class Day35 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word = br.readLine();
		for(char c = 'a' ; c <= 'z' ; c++) {
			bw.write(word.indexOf(c) + " ");
		}
		
		/*
		 * String.indexOf() 
		 * 특정 문자 or 문자열이 앞에서부터 처음 발견되는 인덱스를 반환하고,
		 * 찾지 못하였을 경우 "-1"을 반환한다.
		 * 
		 * .indexOf( "찾을 특정 문자" , "시작할 위치" )
		 * 시작할 위치는 생략이 가능하며, 생략 시 0번째(처음)부터 찾기 시작한다.
		 */
		bw.flush();
		bw.close();
		br.close();
	}
}

















	