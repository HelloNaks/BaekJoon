import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int answer = 0;
		int cnt = 0;
		for(int i=0;i<X;i++) {
			answer+=arr[i];
		}
		max=answer;
		cnt++;
		for(int i=X;i<N;i++) {
			answer+=arr[i];
			answer-=arr[i-X];
			if(max==answer) {
				cnt++;
			}else if(max<answer) {
				max=answer;
				cnt=1;
			}
		}
		if(max==0) {
			System.out.println("SAD");
		}else {
			System.out.println(max+"\n"+cnt);
		}
	}

}