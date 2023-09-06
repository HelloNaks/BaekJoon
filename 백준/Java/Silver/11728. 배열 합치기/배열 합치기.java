import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] brr = new int[M];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			brr[i]=sc.nextInt();
		}
		int[] answer = new int[N+M];
		int a=0, b=0;
		int idx = 0;
		while(true) {
			if(a>=N) {
				for(int i=b;i<M;i++) {
					sb.append(brr[i]+" ");
				}
				break;
			}else if(b>=M) {
				for(int i=a;i<N;i++) {
					sb.append(arr[i]+" ");
				}
				break;
			}
			if(arr[a]>brr[b]) {
				sb.append(brr[b]+" ");
				b++;
			}else {
				sb.append(arr[a]+" ");
				a++;
			}
		}
		System.out.println(sb);
	}

}
