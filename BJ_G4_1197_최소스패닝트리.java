import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int[] parent;
	static int V;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		V=scann.nextInt();
		int E=scann.nextInt();
		parent = new int[V+1];
		for(int i=1;i<V+1;i++) {
			parent[i]=i;
		}
		pq = new PriorityQueue<>();
		
		for(int i=0;i<E;i++){
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
			union(a, b);
			
			ret += temp.val;
			if(++cnt==V) {
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
		int tempa = find(a);
		int tempb = find(b);
		if(tempa==tempb) {
			return;
		}
		parent[b]=a;
	}
	public static class Edge implements Comparable<Edge> {
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
			return Integer.compare(this.val, o.val);
		}
	}
}
