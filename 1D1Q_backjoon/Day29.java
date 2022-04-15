package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day29 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st ;
		int a;
		int b;
		String str;
		
//		while(br.readLine() != null) {
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
//			bw.write(a+b);
			System.out.println(a+b);
		}
		
//		bw.flush();
//		bw.close();
		br.close();
	}
}
