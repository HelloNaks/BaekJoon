import java.util.Scanner;

public class Main {

	static int[][] dp;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n = scann.nextInt();
		dp=new int[n][n];
		arr=new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j]=scann.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		for(int i=1;i<n;i++) {
			for (int j = 0; j < n - i; j++) {
				dp[n-i-1][j] = arr[n-i-1][j] + Math.max(dp[n-i][j], dp[n-i][j+1]);
			}
		}
		
		System.out.println(dp[0][0]);
	}

}
