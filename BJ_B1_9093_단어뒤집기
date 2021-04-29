import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				char[] ch = s.toCharArray();
				for (int i = 0; i < ch.length / 2; i++) {
					char temp = ch[i];
					ch[i] = ch[ch.length - 1 - i];
					ch[ch.length - 1 - i] = temp;
				}
				for (int i = 0; i < ch.length; i++) {
					sb.append(ch[i]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
