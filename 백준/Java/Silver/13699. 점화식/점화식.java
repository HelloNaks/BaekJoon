import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[] dp = new long[n+1];
		dp[0]=1;
		recursive(n, dp);
		System.out.println(dp[n]);
	}

	private static void recursive(int n, long[] dp) {
		for(int i=0;i<n;i++) {
			long temp = 0;
			for(int j=0;j<=i;j++) {
				temp += dp[j]*dp[i-j];
			}
			dp[i+1]=temp;
		}
	}

}
