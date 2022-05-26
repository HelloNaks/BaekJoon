import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static ArrayList<Node> list[];
	static int from, to;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int M=scann.nextInt();
		int max=0;
		int min=Integer.MAX_VALUE;

        list = new ArrayList[N + 1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			int c=scann.nextInt();
			max = Math.max(c, max);
            min = Math.min(c, min);
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		from=scann.nextInt();
		to =scann.nextInt();

        int result=0;
        while(min<=max) {
        	int mid = (min+max)/2;
        	visited=new boolean[N+1];
        	
        	if(bfs(mid)) {
        		min = mid + 1;
        		result = mid;
        	}else {
        		max = mid - 1;
        	}
        }
        System.out.println(result);
	}
	private static boolean bfs(int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.add(from);
		visited[from]=true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp==to) {
				return true;
			}
			for(int i=0;i<list[temp].size();i++) {
				if(list[temp].get(i).weight >= mid && visited[list[temp].get(i).next] == false) {
					visited[list[temp].get(i).next] = true;
					q.offer(list[temp].get(i).next);
				}
			}
		}
		return false;
	}
	public static class Node{
		int next;
		int weight;
		public Node(int next, int weight) {
			super();
			this.next = next;
			this.weight = weight;
		}
	}
}
