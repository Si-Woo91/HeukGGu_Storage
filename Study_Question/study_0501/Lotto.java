package study_0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
*어제, 지민이는 몰래 리조트에 갔다가 입구에 걸려있는 복권 광고를 하나 보았다.
*
*“1부터 N까지의 수 중에 서로 다른 M개의 수를 골라보세요. 저희도 1부터 N까지의 수 중에 서로 다른 M개의 수를 고를건데, 적어도 K개의 수가 같으면 당첨입니다.!”
*
*지민이는 돌아오면서 자신이 복권에 당첨될 확률이 궁금해졌다.
*
*지민이가 복권에 당첨될 확률을 구하는 프로그램을 작성하시오.
*
*입력
*첫째 줄에 세 정수 N, M, K가 주어진다.
*
*출력
*첫째 줄에 지민이가 복권에 당첨될 확률을 출력한다. 절대/상대 오차는 10-9까지 허용한다.
*
*제한
*2 ≤ N ≤ 8
*1 ≤ M ≤ N-1
*1 ≤ K ≤ M
*/

public class Lotto {
	 private static int[] nums;
	    private static int N, M, K;
	    private static List<String> lottoList = new ArrayList<>();

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());

	        nums = new int[N];
	        for (int i = 0; i < N; i++) {
	            nums[i] = i + 1;
	        }

	        combination(0, 0, new StringBuilder());

	        int size = lottoList.size();
	        int totalCnt = 0;

	        for (String temp : lottoList) {
	            for (String s : lottoList) {
	                int cnt = 0;
	                for (int k = 0; k < M; k++) {
	                    if (s.contains(temp.charAt(k) + "")) cnt++;
	                }

	                if (cnt >= K) totalCnt++;
	            }
	        }

	        System.out.println((double) totalCnt / (size * size));
	        
	        br.close();
	    }

	    // 재귀함수
	    private static void combination(int start, int cnt, StringBuilder sb) {
	        if (cnt == M) {
	            lottoList.add(sb.toString());
	            return;
	        }

	        for (int i = start; i < N; i++) {
	            int temp = sb.length();
	            sb.append(nums[i]);
	            combination(i + 1, cnt + 1, sb);
	            sb.setLength(temp);
	        }
	    }
/////////////////////////////////////////////	    
	    
//	    public static int bitCnt(int n) {
//	        int ret = 0;
//	        for (; n > 0; n -= n & -n) {
//	        	ret++;
//	        }
//	        return ret;
//	    }
//	    public static void main(String[] args) throws IOException {
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        StringTokenizer st = new StringTokenizer(br.readLine());
//	        int N = Integer.parseInt(st.nextToken());
//	        int M = Integer.parseInt(st.nextToken());
//	        int K = Integer.parseInt(st.nextToken());
//
//	        /*
//	         * 쉬프트 연산자
//	         * a << b : a의 이진값을 왼쪽으로 b칸 만큼 밀어준다. 이때 비어있는 오른쪽 b칸은 0으로 채운다.
//	         * a >> b : a의 이진값을 오른쪽으로 b칸 만큼 밀어준다. 이때 비어있는 왼쪽 b칸은 0으로 채운다.
//	         */
//	        int bit = (1 << M) - 1;
//	        int a = 0, b = 0;
//	        for (int i = 1; i < 1 << N; ++i) {
//	            if (bitCnt(i) != M) continue;
//	            ++b;
//	            if (bitCnt(bit & i) >= K) ++a;
//	        }
//
//	        System.out.printf("%.15f", (double)a / b);
//	    }
//	    
}
