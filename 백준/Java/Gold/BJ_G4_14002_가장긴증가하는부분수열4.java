import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer = 0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && dp[i]<=dp[j]) {
					dp[i]=dp[j]+1;
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		
		int cnt=answer;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=N-1;i>=0;i--) {
			if(cnt == dp[i]) {
				stack.push(arr[i]);
				cnt--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(answer);
		System.out.println(sb);
	}

}
