import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] dp = new long[21];
	static int N;
	static int[] arr;
	
	public static void main (String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[arr[0]]=1;
		
		run(0);
		System.out.println(dp[arr[N-1]]);
	}

	private static void run(int cnt) {
		if(cnt==N-2) {
			return;
		}
		long[] temp = new long[21];
		for(int i=0;i<=20;i++) {
			if(dp[i]!=0) {
				if(i+arr[cnt+1]<=20) {
					temp[i+arr[cnt+1]]+=dp[i];
				}
				if(i-arr[cnt+1]>=0) {
					temp[i-arr[cnt+1]]+=dp[i];
				}
			}
		}
		dp=temp.clone();
		run(cnt+1);
	}
}
