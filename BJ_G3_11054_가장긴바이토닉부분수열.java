import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] dp;
	static int[] rdp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		arr=new int[N+1];
		dp=new int[N+1];
		rdp=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=scann.nextInt();
		}
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<=i;j++) {
				if(arr[i]>arr[j] && dp[i] < dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
		}
		for(int i=N;i>=1;i--) {
			rdp[i]=1;
			for(int j=N;j>=i;j--) {
				if(arr[i]>arr[j] && rdp[i]<rdp[j]+1) {
					rdp[i]=rdp[j]+1;
				}
			}
		}
		
		int answer=0;
		for(int i=1;i<=N;i++) {
			if(answer<dp[i]+rdp[i]) {
				answer = dp[i]+rdp[i];
			}
		}
		System.out.println(answer-1);
	}

}
