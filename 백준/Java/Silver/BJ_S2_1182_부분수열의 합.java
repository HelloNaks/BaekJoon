import java.util.Scanner;

public class Main {

	static int answer=0;
	static int N, S;
	static int[] arr;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		S=scann.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		run(0,0);
		if(S==0) answer-=1;
		System.out.println(answer);
	}

	private static void run(int cnt, int now) {
		if(cnt==N) {
			if(now==S)
				answer++;
			return;
		}
		run(cnt+1, now+arr[cnt]);
		run(cnt+1, now);
		
	}

}
