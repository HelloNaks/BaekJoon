import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}
	}
}
