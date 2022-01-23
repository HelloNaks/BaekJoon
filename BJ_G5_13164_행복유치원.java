import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, K;
	static int[] arr, diff;
	static long min=0;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		arr = new int[N];
		diff = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		for(int i=0;i<N;i++) {
			if(i==0) {
				diff[i]=0;
				continue;
			}
			diff[i]=arr[i]-arr[i-1];
		}
		
		Arrays.sort(diff);
		for(int i=0;i<N-K+1;i++) {
			min+=diff[i];
		}
		System.out.println(min);
	}
}
