import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		long[][] dp=new long[30][30];
		for(int i=0;i<30;i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		for(int i=2;i<30;i++) {
			for(int j=1;j<30;j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		for(int i=0;i<N;i++) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			System.out.println(dp[b][a]);
		}
	}
}
