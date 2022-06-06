import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int n=scann.nextInt();
		int[] arr=new int[n+1];
		int[] DP=new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=scann.nextInt();
		}
		
		DP[0]=0;
		DP[1]=arr[1];
		if(n>1) {
			DP[2]=arr[1]+arr[2];
		}
		for(int i=3;i<=n;i++) {
			DP[i] = Math.max(DP[i-1], Math.max(DP[i-2]+arr[i], DP[i-3]+arr[i-1]+arr[i]));
		}
		System.out.println(DP[n]);
	}
}
