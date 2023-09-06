import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] sum;
	static long ans=0;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n=scann.nextInt();
		arr=new int[n+1];
		sum=new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=scann.nextInt();
		}
		sum[1]=arr[1];
		for(int i=2;i<=n;i++) {
			sum[i]=sum[i-1]+arr[i];
		}
		
		for(int i=1;i<=n;i++) {
			ans += arr[i] * (sum[n]-sum[i]);
		}
		System.out.println(ans);
	}
}
