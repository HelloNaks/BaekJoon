import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] v;
	static int[] answer;
	static LinkedHashSet<String> hs = new LinkedHashSet<String>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		arr=new int[N];
		v=new boolean[N];
		answer=new int[M];
		for (int i = 0; i < N; i++) {
			arr[i]=scann.nextInt();
		}
		Arrays.sort(arr);
		run(0);
		System.out.println(sb.toString());
	}
	private static void run(int lev) {
		if(lev==M) {
			print();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(lev>=1 && arr[i]<answer[lev-1]) continue;
			v[i]=true;
			answer[lev]=arr[i];
			run(lev+1);
			v[i]=false;
		}
	}
	private static void print() {
		StringBuilder sb2 = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb2.append(answer[i]).append(" ");
		}
		if(!hs.contains(sb2.toString())) {
			sb.append(sb2.toString()).append("\n");
			hs.add(sb2.toString());
		}
	}
}
