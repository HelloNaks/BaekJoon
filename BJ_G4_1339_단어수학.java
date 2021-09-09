import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0, answer = 0, temp = 9;
	static String[] sa;
	static int[] al = new int[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		sa = new String[N];
		for (int i = 0; i < N; i++) {
			sa[i]=br.readLine();
		}
		for (int i = 0; i < N; i++) {
			char[] ch = sa[i].toCharArray();
			
			for (int j = 0; j < ch.length; j++) {
				al[ch[j]-'A']+=Math.pow(10, ch.length-j-1);
			}
		}
		for (int i = 0; i < 26; i++) {
			if(al[i]!=0) {
				cnt++;
			}
		}
		
		Arrays.sort(al);
		
		for (int i = 25; i >=26-cnt; i--) {
			answer += al[i]*temp;
			temp--;
		}
		System.out.println(answer);
	}

}
