import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		answer = new int[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] ch=s.toCharArray();
			int temp=1;
			for (int j = 0; j < ch.length; j++) {
				if(ch[j]=='O') {
					answer[i]+=temp;
					temp++;
				}else {
					temp=1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
	}

}
