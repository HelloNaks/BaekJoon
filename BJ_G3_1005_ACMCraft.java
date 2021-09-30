import java.util.*;

public class Main {

	static int T, target;
	static int[] degree;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int N=sc.nextInt();
			degree=new int[N+1];
			arr=new int[N+1];
			dp=new int[N+1];
			int K=sc.nextInt();

			List<Integer>[] list = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				list[i]=new ArrayList<>();
			}
			
			for (int i = 1; i <= N; i++) {
				arr[i]=sc.nextInt();
			}
			
			for (int i = 0; i < K; i++) {
				int from=sc.nextInt();
				int to=sc.nextInt();
				list[from].add(to);
				degree[to]++;
			}
			
			target=sc.nextInt();
			sb.append(topologicalSort(list,N)+"\n");
			
		}
		System.out.print(sb.toString());
	}
	private static int topologicalSort(List<Integer>[] list, int n) {
		Queue<Integer> q=new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if(degree[i]==0) {
				q.add(i);
				dp[i]=arr[i];
			}
		}
		while(!q.isEmpty()) {
			int v=q.poll();
			for(int k:list[v]) {
				dp[k]=Math.max(dp[k], dp[v]+arr[k]);
				if(--degree[k] == 0) {
					q.add(k);
				}
			}
		}
		return dp[target];
	}

}
