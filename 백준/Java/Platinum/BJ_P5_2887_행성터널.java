import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static Node[] nodes;
	static int[] parent;
	static int N;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		nodes = new Node[N];
		pq = new PriorityQueue<>();
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < N; i++) {
			int x = scann.nextInt();
			int y = scann.nextInt();
			int z = scann.nextInt();
			nodes[i] = new Node(i, x, y, z);
		}
		// x 정렬
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.x - n2.x;
			}
		});
		for (int i = 0; i < N - 1; i++) {
			pq.add(new Edge(nodes[i].idx, nodes[i+1].idx, Math.abs(nodes[i].x - nodes[i+1].x)));
		}

		// y 정렬
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.y - n2.y;
			}
		});
		for (int i = 0; i < N - 1; i++) {
			pq.add(new Edge(nodes[i].idx, nodes[i+1].idx, Math.abs(nodes[i].y - nodes[i+1].y)));
		}
		// z 정렬
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.z - n2.z;
			}
		});
		for (int i = 0; i < N - 1; i++) {
			pq.add(new Edge(nodes[i].idx, nodes[i+1].idx, Math.abs(nodes[i].z - nodes[i+1].z)));
		}

		kruskal();
	}

	private static void kruskal() {
		int ret = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Edge temp = pq.poll();
			int a = find(temp.from);
			int b = find(temp.to);
			if (a == b)
				continue;
			union(a, b);

			ret += temp.val;
			if (++cnt == N-1) {
				break;
			}
		}
		System.out.println(ret);
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int tempa = find(a);
		int tempb = find(b);
		if (tempa == tempb) {
			return;
		}
		parent[tempb] = tempa;
	}

	public static class Node {
		int idx;
		int x;
		int y;
		int z;

		public Node(int idx, int x, int y, int z) {
			this.idx=idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int val;

		public Edge(int from, int to, int val) {
			this.from = from;
			this.to = to;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			return this.val - o.val;
		}
	}

}
