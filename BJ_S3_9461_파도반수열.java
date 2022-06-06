import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T=scann.nextInt();
		for(int t=0;t<T;t++) {
			int N=scann.nextInt();
			long[] dp = new long[N+1];
			dp[0]=0;
			dp[1]=1;
			if(N>1) {
				dp[2]=1;
			}
			for(int i=3;i<=N;i++) {
				dp[i]= dp[i-2]+dp[i-3];
			}
			System.out.println(dp[N]);
		}
	}
}
