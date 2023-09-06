import java.util.*;

public class Main {

	static int T;
	static int[] arr, degree;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 0; t < T; t++) {
			int N=scann.nextInt();
			arr = new int[N+1];
			degree = new int[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i]=scann.nextInt();
			}
			
			List<Integer>[] list = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				list[i]=new ArrayList<>();
			}
			
			for (int i = 1; i <= N; i++) {
				int from = arr[i];
				for (int j = i+1; j <= N; j++) {
					list[from].add(arr[j]);
					degree[arr[j]]++;
				}
			}
			
			int M=scann.nextInt();
			for (int i = 0; i < M; i++) {
				int from = scann.nextInt();
				int to = scann.nextInt();
				if(list[from].contains(to)) {
					list[from].remove((Integer)to);
					list[to].add(from);
					degree[from]++;
					degree[to]--;
				} else {
					list[to].remove((Integer)from);
					list[from].add(to);
					degree[to]++;
					degree[from]--;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			Queue<Integer> q = new LinkedList<>();
			
			int cnt=0;
			for (int i = 1; i <= N; i++) {
				if(degree[i]==0) {
					cnt++;
					q.add(i);
				}
			}
			if(cnt>1) {
				System.out.println("?");
				continue;
			}
			
			int result=0;
			
			boolean isFinished = false;
			for (int i = 1; i <= N; i++) {
				if(q.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					isFinished= true;
					break;
				}
				
				int from = q.poll();
				result++;
				sb.append(from).append(" ");
				for (int to : list[from]) {
					degree[to]--;
					if(degree[to]==0) q.add(to);
				}
			}
			if(isFinished==true) continue;
			
			System.out.println(sb.toString());
		}

	}

}
