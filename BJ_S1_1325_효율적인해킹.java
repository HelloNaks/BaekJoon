import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static List<Integer>[] list;
	static int[] v;
	static int[] ans;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		list=new ArrayList[N+1];
		ans=new int[N+1];
		v=new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<=M;i++) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			list[a].add(b);
		}
		
		for(int i=1;i<=N;i++) {
			v=new int[N+1];
			bfs(i);
		}
		int max=0;
		for(int i=1;i<=N;i++) {
			max=Math.max(max, ans[i]);
		}
		for(int i=1;i<=N;i++) {
			if(max==ans[i]) {
				System.out.print(i+" ");
			}
		}
	}
	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		v[num]=1;
		while(!q.isEmpty()) {
			num=q.poll();
			for(int n: list[num]) {
				if(v[n] == 0) {
					ans[n]++;
					v[n]=1;
					q.add(n);
				}
			}
		}
	}
}
