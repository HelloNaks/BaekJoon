import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		long sum = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scann.nextInt();
		}
		Arrays.sort(arr);
		for (int i = N - 1; i >= 0; i--) {
			arr[i] = arr[i] * (N - i);
			if (sum < arr[i])
				sum = arr[i];
		}
		System.out.println(sum);
	}
}
