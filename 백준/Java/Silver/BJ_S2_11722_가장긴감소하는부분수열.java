import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		int[] arr= new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=scann.nextInt();
		}
		int max=0;
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<i;j++) {
				if(arr[j]>arr[i] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
