import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int max=Integer.MIN_VALUE;
		int[] arr= new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=scann.nextInt();
		}
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			dp[i]=arr[i];
			for(int j=1;j<i;j++) {
				if(arr[j]<arr[i] && dp[i]<dp[j]+arr[i]) {
					dp[i]=dp[j]+arr[i];
				}
			}
			max=Math.max(max,dp[i]);
		}
		System.out.println(max);
	}
}
