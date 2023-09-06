import java.util.Scanner;

public class Main {

	static int[][] dp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n=scann.nextInt();
		int k=scann.nextInt();
		dp=new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			dp[i][i]=1;
			dp[i][1]=1;
		}
		for (int i = 2; i < n+1; i++) {
			for (int j = 2; j < n+1; j++) {
				if(i<j) {
					dp[i][j]=0;
				}
				else if(i!=j && j!=1) {
					dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
