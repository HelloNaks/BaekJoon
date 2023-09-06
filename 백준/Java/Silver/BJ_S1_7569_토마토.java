import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N, V, H;
	static int[][][] map;
	static int[] dr = { 1, 0, -1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int ans = -1;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		M = scann.nextInt();
		N = scann.nextInt();
		H = scann.nextInt();
		map = new int[N][M][H];
		visited = new boolean[N][M][H];

		Queue<pos> q = new LinkedList<pos>();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j][h] = scann.nextInt();
				}
			}
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][h] == 1) {
						q.offer(new pos(i, j, h));
						visited[i][j][h] = true;
					}
				}
			}
		}
		bfs(q);

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][h] == 0) {
						System.out.println("-1");
						return;
					}
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

				for (int d = 0; d < 6; d++) {
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];
					int nh = temp.h + dh[d];
					if (checked(nr, nc, nh) && map[nr][nc][nh] == 0 && !visited[nr][nc][nh]) {
						map[nr][nc][nh] = 1;
						visited[nr][nc][nh] = true;
						q.offer(new pos(nr, nc, nh));
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

	private static boolean checked(int nr, int nc, int nh) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H;
	}

	private static class pos {
		int r;
		int c;
		int h;

		public pos(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}

	}
}
