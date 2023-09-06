import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node>[] list;
	
	static int N, max_num = 0, max=0;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		v=new boolean[N+1];
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			list[parent].add(new Node(child,weight));
			list[child].add(new Node(parent,weight));
		}
		
		v[1]=true;
		dfs(1,0);
		
		v=new boolean[N+1];
		v[max_num]=true;
		dfs(max_num,0);
		System.out.println(max);
		
	}
	
	
	private static void dfs(int num, int weight) {
		if(max<weight) {
			max=weight;
			max_num=num;
		}
		
		for(Node n: list[num]) {
			if(!v[n.num]) {
				v[n.num]=true;
				dfs(n.num, weight+n.weight);
			}
		}
	}


	public static class Node{
		int num;
		int weight;
		
		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
	}
}
