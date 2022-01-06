import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n = scann.nextInt();
		Node[] p = new Node[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Node(scann.nextInt(), scann.nextInt());
		}
		Arrays.sort(p, new Comparator<Node>() {
			@Override
			public int compare(Node p1, Node p2) {
				if(p1.x==p2.x) return p1.y-p2.y;
				return p1.x - p2.x;
			}
		});
		for (int i = 0; i < n; i++) {
			System.out.println(p[i].x + " " + p[i].y);
		}
	}
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
