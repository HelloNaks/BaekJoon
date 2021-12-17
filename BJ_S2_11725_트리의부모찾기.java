import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[] v;
	static int[] parent;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		N=Integer.parseInt(br.readLine());
		list=new ArrayList[N+1];
		parent=new int[N+1];
		v=new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i]=new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				dfs(i);
			}
		}
		for(int i=2;i<=N;i++) {
			System.out.println(parent[i]);
		}
	}
	private static void dfs(int x) {
		if(v[x]) return;
		v[x]=true;
		for(int i: list[x]) {
			if(!v[i]) {
				parent[i]=x;
				dfs(i);
			}
		}
	}

}
