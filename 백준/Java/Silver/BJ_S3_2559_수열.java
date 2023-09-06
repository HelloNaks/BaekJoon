import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int K=scann.nextInt();
		int[] arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		int[] sum= new int[N-K+1];
		for(int i=0;i<K;i++) {
			sum[0]+=arr[i];
		}
		for(int i=1;i<N-K+1;i++) {
			sum[i]=sum[i-1]-arr[i-1]+arr[K+i-1];
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<sum.length;i++) {
			max=Math.max(max, sum[i]);
		}
		System.out.println(max);
	}
}
