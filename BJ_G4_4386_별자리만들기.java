import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int n;
	static int[] parent;
	static PriorityQueue<Edge> pq;
	static Star[] stars;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		n=scann.nextInt();
		stars = new Star[n];
//		Map<Star, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			double a = scann.nextDouble();
			double b = scann.nextDouble();
			stars[i] = new Star(i,a,b);
//			map.put(stars[i], i);
		}
		pq= new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)continue;
				double val = Math.sqrt(Math.pow(stars[i].r-stars[j].r, 2)+Math.pow(stars[i].c-stars[j].c, 2));
				pq.add(new Edge(stars[i].index,stars[j].index, val));
			}
		}
		parent = new int[n+1];
		for(int i=1;i<n+1;i++) {
			parent[i]=i;
		}
		
		kruskal();
	}
	
	private static void kruskal() {
		double ret=0;
		int cnt=0;
		
		while(!pq.isEmpty()) {
			Edge temp = pq.poll();
			int a = find(temp.from);
			int b = find(temp.to);
			if(a==b) {
				continue;
			}
			union(a,b);
			
			ret+=temp.val;
			
			if(++cnt==n) {
				break;
			}
		}
		System.out.printf("%.2f",ret);
		
	}

	private static int find(int from) {
		if(from==parent[from]) {
			return from;
		}
		return parent[from]=find(parent[from]);
		
	}

	private static void union(int a, int b) {
		int tempa=find(a);
		int tempb=find(b);
		if(tempa==tempb) {
			return;
		}
		parent[tempb]=tempa;
	}

	public static class Star{
		int index;
		double r;
		double c;
		
		public Star(int index, double r, double c) {
			this.index=index;
			this.r=r;
			this.c=c;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double val;
		
		public Edge(int from, int to, double val) {
			this.from=from;
			this.to=to;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.val>o.val) return 1;
			return -1;
		}
	}
}
