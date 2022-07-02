import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static PriorityQueue<Edge> pq;
	static int[] parent;
	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N=scann.nextInt();
		int M=scann.nextInt();
		pq=new PriorityQueue<>();
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			int c=scann.nextInt();
			pq.add(new Edge(a,b,c));
		}
		System.out.println(kruskal());
	}
	private static int kruskal() {
		int ret=0;
		int cnt=0;
		while(!pq.isEmpty()) {
			Edge temp = pq.poll();
			int a=find(temp.from);
			int b=find(temp.to);
			if(a==b) {
				continue;
			}
			union(a,b);
			ret+=temp.val;
			if(++cnt==N) {
				break;
			}
		}
		return ret;
	}
	public static int find(int a) {
		if(a==parent[a]) {
			return a;
		}
		return parent[a]=find(parent[a]);
	}
	public static void union(int a, int b) {
		int x=find(a);
		int y=find(b);
		if(x==y) {
			return;
		}
		parent[y]=x;
	}
	public static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int val;
		public Edge(int from, int to, int val) {
			this.from=from;
			this.to=to;
			this.val=val;
		}
		@Override
		public int compareTo(Edge o) {
			return this.val-o.val;
		}
	}

}
