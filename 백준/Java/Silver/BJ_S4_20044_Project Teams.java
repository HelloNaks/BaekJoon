import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int min=Integer.MAX_VALUE;
		int[] arr=new int[2*N];
		for(int i=0;i<2*N;i++) {
			arr[i]=scann.nextInt();
		}
		
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			int temp = arr[i]+arr[2*N-i-1];
			min=Math.min(temp, min);
		}
		System.out.println(min);
	}

}
