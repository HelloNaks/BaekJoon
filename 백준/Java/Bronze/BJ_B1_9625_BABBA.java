import java.util.Scanner;

public class Main {

	static int[] dp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int K=scann.nextInt();
		dp = new int[K+1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < K+1; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[K-1]+" "+dp[K]);
	}
}
