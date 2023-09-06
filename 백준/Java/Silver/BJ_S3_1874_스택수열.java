import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int n;
	static Stack<Integer> st = new Stack<Integer>();
	static StringBuilder sb = new StringBuilder();
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		int t, last = 0;
		v=new boolean[n+1];
		
		for (int i = 0; i < n; i++) {
			t=Integer.parseInt(br.readLine());
			if(i==0) {
				for(int j=1;j<=t;j++) {
					st.push(j);
					v[j]=true;
					sb.append("+").append("\n");
				}
				last=t;
				st.pop();
				sb.append("-").append("\n");
			}else {	//처음이 아닌경우
				
				if(st.contains(t)) {
					while(st.contains(t)) {
						st.pop();
						sb.append("-").append("\n");
					}
				}else if(t<last) {
					System.out.println("NO");
					return;
				}else {
					for(int j=last+1;j<=t;j++) {
						st.push(j);
						v[j]=true;
						sb.append("+").append("\n");
					}
					last=t;
					st.pop();
					sb.append("-").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
