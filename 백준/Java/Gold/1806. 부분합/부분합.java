import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int st = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(st<=N && end<=N) {
			if(sum>=S && min > end - st) {
				min = Math.min(min, end-st);
			}
			if(sum < S) {
				sum += arr[end];
				end++;
			}else {
				sum -= arr[st++];
			}
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
	}

}
