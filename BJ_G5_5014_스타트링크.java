import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static int[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		v = new int[F + 1];
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		v[S] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == G) {
				System.out.println(v[temp] - 1);
				return;
			}
			int du = temp + U;
			if (du <= F && v[du] == 0) {
				q.add(du);
				v[du] = v[temp] + 1;
			}
			int dd = temp - D;
			if (dd > 0 && v[dd] == 0) {
				q.add(dd);
				v[dd] = v[temp] + 1;
			}
		}
		if(v[G]==0)
			System.out.println("use the stairs");
	}
}
