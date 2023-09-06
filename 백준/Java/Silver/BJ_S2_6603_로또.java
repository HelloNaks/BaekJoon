import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] v;
	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		while(true) {
			N=scann.nextInt();
			if(N==0) {
				break;
			}
			arr=new int[N];
			v=new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i]=scann.nextInt();
			}
			run(0, 0);
			System.out.println();
		}
	}
	private static void run(int start, int cnt) {
		if(cnt==6) {
			for(int i=0;i<N;i++) {
				if(v[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
		}
		for(int i=start;i<N;i++) {
			v[i]=true;
			run(i+1, cnt+1);
			v[i]=false;
			
		}
	}
}
