package study_0417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

/* 
타노스는 프로그램의 균형을 위해서는 리스트의 원소 절반을 무작위로 삭제해야 한다고 믿고 있다.
타노스가 손가락을 튕겼을 때(프로그램을 실행했을 때) 입력된 리스트에서 
절반의 원소를 무작위로 삭제하여 리턴하는 인피니티 건틀렛 프로그램을 작성하시오.
(무작위 삭제이므로 입력값이 같아도 출력값이 매번 달라야 합니다)
(Scanner 이용)

입력 예시
[2, 3, 1, 6, 5, 7]

출력 예시 1
[2, 5, 7]

출력 예시 2
[3, 6, 5]

* 참고: 리스트의 원소가 홀수개일 경우 절반의 확률로 절반보다 많은 원소가 삭제되거나 
         절반보다 적은 원소가 삭제되어야 합니다.
         (만약 리스트의 원소가 7개라면 절반의 확률로 3개 또는 4개의 원소가 삭제됨)
*/
public class Thanos_Jack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());	
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");	
	
		Random rd = new Random();

		int t = Integer.parseInt(st1.nextToken());
		String[] arr = new String[t];
		for(int i = 0; i < t; i++) {
			arr[i] = st2.nextToken();
		}
		
		int a;
		if(rd.nextInt(2) == 0) {					
			//Math.ceil : 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer로 반환
			a = (int)Math.ceil(arr.length/2.0);		
		}else {
			//Math.floor : 숫자를 가장 가까운 정수 또는 지정된 유의값의 배수로 내린다.
			//				음수일 경우 모드에 따라 0에 가까워지거나 0에서 어지는 방향으로 멀반올림
			a = (int)Math.floor(arr.length/2.0);	
		}
		
		int j = 0;
		while(j != a){								// 제외 할 값을 저장받는다
			int b = rd.nextInt(arr.length);			// 배열의 길이수 만큼 무작위로 값을 받고
			if(arr[b] != ""){						// 해당 인덱스의 값이 "" 아닐시 
				arr[b] = "";						// ""으로 넣어준다.
				j++;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			if(arr[i].equals("") == false) {		// 배열의 값 중 ""이 아니라면 그 값을 출력
				bw.write(arr[i] + " ");
			}
		}
		bw.flush();						// 버퍼 비워주기
		bw.close();						// 버퍼 닫기
		br.close();
	}
}