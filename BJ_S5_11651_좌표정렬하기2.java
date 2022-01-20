import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		Node[] arr=new Node[N];
		for(int i=0;i<N;i++) {
			arr[i]=new Node(scann.nextInt(),scann.nextInt());
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			System.out.println(arr[i].x+" "+arr[i].y);
		}
	}

	public static class Node implements Comparable<Node>{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.y==o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
	}
}
