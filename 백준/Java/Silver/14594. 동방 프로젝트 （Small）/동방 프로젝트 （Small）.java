import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+2];
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			for(int j=from;j<to;j++) {
				arr[j]=1;
			}
		}
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(arr[i]==0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
