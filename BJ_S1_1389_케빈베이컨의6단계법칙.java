import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] bacon;
	static List<Integer>[] list;
	static int N, M;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		bacon = new int[N+1];
		int min=Integer.MAX_VALUE;
		list = new LinkedList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i]=new LinkedList<>();
		}
		for(int i=0;i<M;i++) {
			int a = scann.nextInt();
			int b = scann.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1;i<=N;i++) {
			bfs(i);
		}
		for(int i=1;i<=N;i++) {
			min=Math.min(min, bacon[i]);
		}
		for(int i=1;i<=N;i++) {
			if(min==bacon[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited=new boolean[N+1];
		visited[start]=true;
		int cnt=0;
		
		int index=0;
		q.add(start);
		while(!q.isEmpty()) {
			if(cnt==N-1) {
				break;
			}
			int size=q.size();
			index++;
			for(int s=0;s<size;s++) {
				int temp=q.poll();
				for(int i:list[temp]) {
					if(!visited[i]) {
						visited[i]=true;
						cnt++;
						bacon[start]+=index;
						q.add(i);
					}
				}
			}
		}
	}
}
