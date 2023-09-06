import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N=scann.nextInt();
		int[] arr=new int[N+1];
		boolean[][] dp = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=scann.nextInt();
		}
		solve(arr, dp, N);
		int M=scann.nextInt();
		for(int i=0;i<M;i++) {
			int start = scann.nextInt();
			int end = scann.nextInt();
			if(dp[start][end]) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void solve(int[] arr, boolean[][] dp, int N) {
		for(int i=1;i<=N;i++) {
			dp[i][i]=true;
		}
		for(int i=1;i<=N-1;i++) {
			if(arr[i]==arr[i+1]) dp[i][i+1]=true;
		}
		for(int i=2;i<N;i++) {
			for(int j=1;j<=N-i;j++) {
				if(arr[j]==arr[j+i] && dp[j+1][j+i-1]) {
					dp[j][j+i] = true;
				}
			}
		}
	}

}
