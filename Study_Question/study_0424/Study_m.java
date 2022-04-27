package study_0424;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * 글이나 수학식을 표현하기위해 괄호 (ex. { , [, (  ) 등을 많이 사용한다.
 * 보통 열린 괄호가 ( 가 있으면 순서에 맞게 닫힌 괄호가 있어야 하는데 이것을 우리는 균형잡힌 
 * 괄호(balanced parentheses)라고 얘기한다.
 * 즉 [()]{}{[()()]()} 표현식은 열린, 닫힌 괄호들이 균형잡힌 형태로 표현된것이고,
 * (]) 는 ']'에 대한 열린 괄호가 가 없기 때문에 균형잡힌 형태라고 볼 수 없다.
 * 
 * <Examples of balanced expression>
 * (())
 * {(([]))}
 * 
 * {{}}[]
 * [](){}
 * {{}}{}()[]
 * 
 * <Examples of unbalanced expression>
 * {()
 * [][])
 * }}}}
 * ((()
 * [{](){}
 * 
 * <샘플 입력>
 * {}()
 * ({()}) 
 * {}(
 * 
 * 
 * <샘플 출력>
 * true
 * true
 * false
 * true
 */
public class Study_m {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		String bracket = ""; 
		
		bracket = br.readLine();
		Stack<Character> str = new Stack<Character>(); 
		
		for(int i = 0; i < bracket.length(); i++) {
			
			/*
			 * peek() : 스택 탑에 있는 원소를 반환
			 * push() : 탑에 원소를 추가
			 * pop() : 탑에 있는 원소를 삭제하고 반환
			 * empty() : 스택의 값이 비어있는지 확인
			 * isEmpty() : 스택의 값이 비어있는지 확인
			 * 
			 * empty() 와 isEmpty()
			 * isEmpty()는 포인트를 벡터로 동기화하고, empty()는 포인트를 스택으로 동기화 하지 않는다.
			 * 둘다 boolean 타입을 반환한다.
			 */
			try {
				if(bracket.charAt(i) == ')' && str.peek() == '(' ) {
					str.pop();
				}else if(bracket.charAt(i) == '}' && str.peek() == '{') {
					str.pop();
				}else if(bracket.charAt(i) == ']' && str.peek() == '[') {
					str.pop();
				}else {
					str.push(bracket.charAt(i));
				}
				
			} catch (Exception e) {
				str.push(bracket.charAt(i));
			}
		}
		
		boolean result = false;
		
		if(str.empty()) {
			result = true;
		}else{
			result = false;
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
