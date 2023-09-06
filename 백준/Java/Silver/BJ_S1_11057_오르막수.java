import java.util.Scanner;

public class Main {

	static int mod=10007;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int[][] dp = new int[N+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j]+=dp[i-1][k];
					dp[i][j]%=mod;
				}
			}
		}
		long answer=0;
		for(int i=0;i<10;i++) {
			answer+=dp[N][i];
		}
		System.out.println(answer%mod);
	}
}
