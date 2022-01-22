import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n=scann.nextInt();
		int[] arr=new int[100001];
		int[] dp=new int[100001];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			arr[i]=scann.nextInt();
		}
		dp[1]=arr[1];
		max=arr[1];
		for(int i=1;i<=n;i++) {
			dp[i]=Math.max(dp[i-1]+arr[i], arr[i]);
			max=Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
