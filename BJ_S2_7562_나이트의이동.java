import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int ans = 0;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			int I = scann.nextInt();
			int a = scann.nextInt();
			int b = scann.nextInt();
			Node st = new Node(a, b);
			int c = scann.nextInt();
			int d = scann.nextInt();
			Node end = new Node(c, d);
			ans = bfs(I, st, end);
			System.out.println(ans);
		}
	}

	private static int bfs(int i, Node st, Node end) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(st);
		if(st.r==end.r && st.c==end.c) {
			return 0;
		}
		map = new int[i][i];
		visited = new boolean[i][i];
		map[end.r][end.c] = 1;
		visited[st.r][st.c]=true;
		int cnt = 0;
		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Node temp = q.poll();
				for (int d = 0; d < 8; d++) {
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];
					if (isChecked(i, nr, nc) && map[nr][nc]==1) {
						return cnt;
					} else if (isChecked(i,nr,nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
						visited[nr][nc]=true;
						q.offer(new Node(nr, nc));
					}
				}
			}
		}
		return 0;
	}

	private static boolean isChecked(int i, int nr, int nc) {
		return nr >= 0 && nr < i && nc >= 0 && nc < i;
	}

	private static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
