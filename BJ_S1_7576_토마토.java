import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N, V;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int ans = -1;
	static int flag = 0;
	static int tm = 2;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		M = scann.nextInt();
		N = scann.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		Queue<pos> q = new LinkedList<pos>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scann.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.offer(new pos(i, j));
					visited[i][j] = true;
				}
			}
		}
		bfs(q);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}

		System.out.println(ans);
	}

	private static void bfs(Queue<pos> q) {

		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();

			for (int s = 0; s < size; s++) {
				pos temp = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];

					if (checked(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
						map[nr][nc] = 1;
						visited[nr][nc] = true;
						q.offer(new pos(nr, nc));
					}
				}

			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			ans++;
		}

	}

	private static boolean checked(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	private static class pos {
		int r;
		int c;

		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + "]";
		}

	}
}
